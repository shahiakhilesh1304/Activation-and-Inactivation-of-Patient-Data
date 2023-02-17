package com.mphrx.api.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mphrx.api.ConcentDTO.Category;
import com.mphrx.api.ConcentDTO.Coding;
import com.mphrx.api.ConcentDTO.Extension;
import com.mphrx.api.ConcentDTO.Patient;
import com.mphrx.api.ConcentDTO.Period;
import com.mphrx.api.ConcentDTO.UpdateCategory;
import com.mphrx.api.ConcentDTO.UpdateCoding;
import com.mphrx.api.ConcentDTO.UpdateExtension;
import com.mphrx.api.ConcentDTO.UpdatePatient;
import com.mphrx.api.ConcentDTO.UpdatePeriod;
import com.mphrx.api.DTO.Entry;
import com.mphrx.api.DTO.Resource;
import com.mphrx.api._790.CardNumberRequest;
import com.mphrx.api._790.ActivateResponse;
import com.mphrx.api.reqres.Concent;
import com.mphrx.api.reqres.ConcentCreateRequest;
import com.mphrx.api.reqres.ConcentCreateResponse;
import com.mphrx.api.reqres.ConcentUpdateRequest;
import com.mphrx.api.reqres.ConcentUpdateResponse;
import com.mphrx.api.reqres.PatientIdResponse;
import com.mphrx.api.utility.APICaller;

@Service
public class InActiveate790Service {
	public static final Logger log = LoggerFactory.getLogger(InActiveate790Service.class);
	@Autowired
	APICaller apiCall;
	ObjectMapper mapper = new ObjectMapper();
	SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
	
	public ActivateResponse activatePatient(CardNumberRequest request) {
		ActivateResponse response = new ActivateResponse();
		try {
			String id = null;
			String cardNumber = request.getCardNumber();
			PatientIdResponse responseF = this.apiCall.patient_Demographic_Fetch_With_Identifier(cardNumber);
			if (responseF != null) {
				List<Entry> entry = responseF.getEntry();
				if (entry != null) {
					for (Entry e : entry) {

						Resource resource = e.getResource();
						if (resource != null) {
							id = resource.getId();
							
							log.info("Patient Id Found, Hence Patient is available {}",id);
							log.info("Fetching Concent with Patient Id -> {}",id);
							Concent responseC = this.apiCall.searchConcent(id);
							if(responseC != null)
							{
								//update as concent is available
								List<com.mphrx.api.ConcentDTO.Entry> concentEntry = responseC.getEntry();
								for(com.mphrx.api.ConcentDTO.Entry ce:concentEntry)
								{
									com.mphrx.api.ConcentDTO.Resource concentResource = ce.getResource();
									if(concentResource.getStatus().toUpperCase().equals("INACTIVE"))
									{
										log.info("Concent is inactive, Activating ...");
										ConcentUpdateRequest updateRequest = new ConcentUpdateRequest();
										log.info("Concent Id => {}",concentResource.getId());
										updateRequest.setId(concentResource.getId());
										updateRequest.setResourceType("Consent");
										updateRequest.setStatus("active");
										List<UpdateExtension> updateExtension = new ArrayList<>();
										UpdateExtension extension = new UpdateExtension();
										List<Extension> ex= concentResource.getExtension();
										for(Extension i:ex)
										{
											extension.setUrl(i.getUrl());
											extension.setValueString("everyone");
											updateExtension.add(extension);
										}
										updateRequest.setExtension(updateExtension);
										List<UpdateCategory> updateCategory = new ArrayList<>();
										UpdateCategory category = new UpdateCategory(); 
										List<Category> cat = concentResource.getCategory();
										List<Coding> code = new ArrayList<>();
										UpdateCoding c = new UpdateCoding();
										List<UpdateCoding> updateCode = new ArrayList<>();
										for(Category i:cat) {
											category.setText(i.getText());
											code = i.getCoding();
											for(Coding j:code)
											{
												c.setCode(j.getCode());
												c.setDisplay(j.getDisplay());
												updateCode.add(c);
											}
											category.setCoding(updateCode);
											updateCategory.add(category);
										}
										updateRequest.setCategory(updateCategory);
										Patient patient = concentResource.getPatient();
										UpdatePatient updatePatient = new UpdatePatient();
										updatePatient.setDisplay(patient.getDisplay());
										updatePatient.setReference(patient.getDisplay());
										updateRequest.setPatient(updatePatient);
										Period period = concentResource.getPeriod();
										UpdatePeriod updatePeriod = new UpdatePeriod();
										updatePeriod.setStart(period.getStart());
										updateRequest.setPeriod(updatePeriod);
										ConcentUpdateResponse updateAPIResponse = this.apiCall.updateConcent(new Gson().toJson(updateRequest),concentResource.getId());
										if(updateAPIResponse != null)
										{
											log.info("Update API Call Response -> {}",mapper.writeValueAsString(updateAPIResponse));
											response.setCardNumber(cardNumber);
											response.setPatientId(id);
											response.setStatus(updateAPIResponse.getStatus());
											try {
											response.setDateActive(updateAPIResponse.getMeta().getLastUpdated());
											}catch(Exception exception)
											{
												response.setDateActive(updateAPIResponse.getPeriod().getStart());
											}
										}else
										{
											log.info("Unable to update the concent");
											response.setCardNumber(cardNumber);
											response.setPatientId(id);
											response.setStatus(concentResource.getStatus());
											response.setStatus("Unable to update : Some Internal Error");											
										}
									}else {
										log.info("Concent is already active");
										response.setCardNumber(cardNumber);
										response.setPatientId(id);
										response.setStatus(concentResource.getStatus());
										response.setStatus("Concent is already active");
									}
								}
							}else {
								//create if concent is not available 
								log.info("Concent Not Available, Creating Concent...");
								ConcentCreateRequest requestCreate = new ConcentCreateRequest();
								requestCreate.setResourceType("Concent");
								requestCreate.setStatus("active");
								Extension extension = new Extension();
								extension.setUrl("accessLevel");
								extension.setValueString("everyone");
								List<Extension> finalExtension = new ArrayList<>();
								finalExtension.add(extension);
								requestCreate.setExtension(finalExtension);
								Category category = new Category();
								Coding coding = new Coding();
								coding.setCode("59284-0");
								coding.setDisplay("Patient Concent");
								List<Coding> finalCoding = new ArrayList<>();
								finalCoding.add(coding);
								category.setCoding(finalCoding);
								category.setText("Patient Concent");
								List<Category> finalCategory = new ArrayList<>();
								finalCategory.add(category);
								requestCreate.setCategory(finalCategory);
								Patient patient = new Patient();
								patient.setDisplay("Patient");
								String reference = "Patient/"+id;
								patient.setReference(reference);
								Period period = new Period();
								requestCreate.setPatient(patient);
								period.setStart(out.format(new Date()));
								requestCreate.setPeriod(period);
								ConcentCreateResponse createResponse = this.apiCall.createConcent(new Gson().toJson(requestCreate), id);
								if(createResponse != null)
								{
									response.setCardNumber(cardNumber);
									response.setPatientId(id);
									response.setStatus(createResponse.getStatus());
									response.setDateActive(createResponse.getMeta().getLastUpdated());

								}else
								{
									response.setCardNumber(cardNumber);
									response.setPatientId(id);
									response.setStatus("Unable to Create : Some Internal Error");
								}
							}
						}
					}
				}
			}
			return response;
		} catch (

		Exception ex) {
			log.info("Exception occured in PatientActive_activeService for ActivatePatient method {}", ex);
		}
		return response;
	}

}
