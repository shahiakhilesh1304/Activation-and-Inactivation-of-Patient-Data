package com.mphrx.api.Endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.mphrx.api._790.CardNumberRequest;
import com.mphrx.api._790.ActivateResponse;
import com.mphrx.api.service.InActiveate790Service;

@Endpoint
public class ActivateEnpoint {
	  public static final Logger log = LoggerFactory.getLogger(ActivateEnpoint.class);
	    private static final String NAMESPACE_URL = "http://www.mphrx.com/api/_790";
	    
	    @Autowired
	    private InActiveate790Service service;
	    
	    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "CardNumberRequest")
	    @ResponsePayload
	    public ActivateResponse inActivate(@RequestPayload CardNumberRequest request)
	    {
	    	ActivateResponse response = new ActivateResponse();
	        try{
	        	//log.info("Namespace Uri is -> {}",NAMESPACE_URL);
	        	log.info("request received");
	        	response = this.service.activatePatient(request);
	            return response;
	            
	        }catch (Exception e)
	        {
	            log.info("Exception Occured at Endpoint {}",e);
	        }
	        return response;
	    }

}
