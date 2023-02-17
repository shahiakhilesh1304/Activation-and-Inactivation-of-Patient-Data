package com.mphrx.api.utility;

import com.mphrx.api.config.ApiPropertiesConfig;
import com.mphrx.api.reqres.Concent;
import com.mphrx.api.reqres.ConcentCreateResponse;
import com.mphrx.api.reqres.ConcentUpdateResponse;
import com.mphrx.api.reqres.PatientIdResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;

@Service
public class APICaller {
    public static final Logger log = LoggerFactory.getLogger(APICaller.class);
    ObjectMapper mapper = new ObjectMapper();
  
    
    
    //Search APIS EXECUTION

//  Caliing second search api which search the patient with identifier
    PatientIdResponse result = null;
    public PatientIdResponse patient_Demographic_Fetch_With_Identifier(String identifier)
    {
        result = new PatientIdResponse();
        try{
        	String apiUrl= ApiPropertiesConfig.env.getProperty("API_URL_2")+identifier;
            String authToken = ConstantVariables.API_AUTH_TOKEN;
            String apiInfo = ConstantVariables.API_INFO;
            String apiType = ConstantVariables.API_TYPE_2;
            String apiContent = ConstantVariables.API_CONTENT_TYPE;
            URL url = new URL(apiUrl);
            log.info("The url is {}->{}",apiUrl,url.getHost());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(apiType);
            con.setRequestProperty("x-auth-token",authToken);
            con.setRequestProperty("api-info",apiInfo);
            con.setRequestProperty("Content-Type", apiContent);
            con.setRequestProperty("Cookie","x-auth-token=");
            con.setDoOutput(true);
            int responseCode = con.getResponseCode();
            log.info("Response Code for API calling is -> {}",responseCode);
            log.info("Sending "+apiType+" Request to URL :: " + url.getQuery()+" :: Response Code :: "+responseCode);
            //log.info("Sending 'POST' Request to URL {}");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output="";
            StringBuffer response = new StringBuffer();
            while ((output = in.readLine()) != null)
                response.append(output);
            in.close();
            //log.info("Sent data to Response={}", response);
            String data = response.toString();
            //log.info("Sent data to data={}", data);
            result = new Gson().fromJson(data, PatientIdResponse.class);
            return result;
        }catch(Exception ex)
        {
            log.warn("Exception Occured while calling an Minerva API at patient_Demographic_Fetch_With_Identifier in APICaller service {}",ex);
        }
        return result;
    }
    
    
    //calling concent Search API
    Concent result_2 = null;
    public Concent searchConcent(String id)
    {
    	result_2 = new Concent();
        try{
        	String apiUrl= ApiPropertiesConfig.env.getProperty("API_URL_3")+id;
            String authToken = ConstantVariables.API_AUTH_TOKEN;
            String apiType = ConstantVariables.API_TYPE_3;
            String apiContent = ConstantVariables.API_CONTENT_TYPE;
            URL url = new URL(apiUrl);
            log.info("The url is {}->{}",apiUrl,url.getHost());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(apiType);
            con.setRequestProperty("x-auth-token",authToken);
            con.setRequestProperty("Content-Type", apiContent);
            con.setRequestProperty("Cookie","x-auth-token=");
            con.setDoOutput(true);
            int responseCode = con.getResponseCode();
            log.info("Response Code for API calling is -> {}",responseCode);
            log.info("Sending "+apiType+" Request to URL :: " + url.getQuery()+" :: Response Code :: "+responseCode);
            log.info("Sending 'POST' Request to URL {}");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output="";
            StringBuffer response = new StringBuffer();
            while ((output = in.readLine()) != null)
                response.append(output);
            in.close();
            log.info("Sent data to Response={}", response);
            String data = response.toString();
            log.info("Sent data to data={}", data);
            result_2 = new Gson().fromJson(data, Concent.class);
            return result_2;
        }catch(Exception ex)
        {
            log.warn("Exception Occured while calling an Minerva API at patient_Demographic_Fetch in APICaller service {}",ex);
        }
        return result_2;
    }
    
    
    
    
    //Calling Concent Update API
    ConcentUpdateResponse result_3= null;
    public ConcentUpdateResponse updateConcent(String request,String id)
    {
    	result_3 = new ConcentUpdateResponse();
        try{
        	String apiUrl= ApiPropertiesConfig.env.getProperty("API_URL_5")+id;
            String authToken = ConstantVariables.API_AUTH_TOKEN;
            String apiType = ConstantVariables.API_TYPE_5;
            String apiContent = ConstantVariables.API_CONTENT_TYPE;
            URL url = new URL(apiUrl);
            log.info("The url is {}->{}",apiUrl,url.getHost());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(apiType);
            con.setRequestProperty("x-auth-token",authToken);
            con.setRequestProperty("Content-Type", apiContent);
            con.setRequestProperty("Cookie","x-auth-token=");
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(request);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            log.info("Response Code for API calling is -> {}",responseCode);
            log.info("Sending "+apiType+" Request to URL :: " + url.getQuery()+" :: Response Code :: "+responseCode);
            log.info("Sending 'POST' Request to URL {}");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output="";
            StringBuffer response = new StringBuffer();
            while ((output = in.readLine()) != null)
                response.append(output);
            in.close();
            log.info("Sent data to Response={}", response);
            String data = response.toString();
            log.info("Sent data to data={}", data);
            result_3 = new Gson().fromJson(data, ConcentUpdateResponse.class);
            return result_3;
        }catch(Exception ex)
        {
            log.warn("Exception Occured while calling an Minerva API at patient_Demographic_Fetch in APICaller service {}",ex);
        }
        return result_3;
    }
    
    
    
    
//    Calling Concent Create API
    ConcentCreateResponse result_4= null;
    public ConcentCreateResponse createConcent(String request,String id)
    {
    	result_4 = new ConcentCreateResponse();
        try{
        	String apiUrl= ApiPropertiesConfig.env.getProperty("API_URL_5")+id;
            String authToken = ConstantVariables.API_AUTH_TOKEN;
            String apiType = ConstantVariables.API_TYPE_5;
            String apiContent = ConstantVariables.API_CONTENT_TYPE;
            URL url = new URL(apiUrl);
            log.info("The url is {}->{}",apiUrl,url.getHost());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(apiType);
            con.setRequestProperty("x-auth-token",authToken);
            con.setRequestProperty("Content-Type", apiContent);
            con.setRequestProperty("Cookie","x-auth-token=");
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(request);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            log.info("Response Code for API calling is -> {}",responseCode);
            log.info("Sending "+apiType+" Request to URL :: " + url.getQuery()+" :: Response Code :: "+responseCode);
            log.info("Sending 'POST' Request to URL {}");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output="";
            StringBuffer response = new StringBuffer();
            while ((output = in.readLine()) != null)
                response.append(output);
            in.close();
            log.info("Sent data to Response={}", response);
            String data = response.toString();
            log.info("Sent data to data={}", data);
            result_4 = new Gson().fromJson(data, ConcentCreateResponse.class);
            return result_4;
        }catch(Exception ex)
        {
            log.warn("Exception Occured while calling an Minerva API at patient_Demographic_Fetch in APICaller service {}",ex);
        }
        return result_4;
    }
    
}
