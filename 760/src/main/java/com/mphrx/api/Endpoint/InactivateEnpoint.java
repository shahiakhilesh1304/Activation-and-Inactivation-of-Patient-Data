package com.mphrx.api.Endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mphrx.api._760.CardNumberRequest;
import com.mphrx.api._760.InactivateResponse;
import com.mphrx.api.service.InActiveate760Service;

@Endpoint
public class InactivateEnpoint {
	  public static final Logger log = LoggerFactory.getLogger(InactivateEnpoint.class);
	    private static final String NAMESPACE_URL = "http://www.mphrx.com/api/_760";
	    
	    @Autowired
	    private InActiveate760Service service;
	    
	    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "CardNumberRequest")
	    @ResponsePayload
	    public InactivateResponse inActivate(@RequestPayload CardNumberRequest request)
	    {
	    	InactivateResponse response = new InactivateResponse();
	        try{
	        	//log.info("Namespace Uri is -> {}",NAMESPACE_URL);
	        	log.info("request received");
	        	response = this.service.inActivatePatient(request);
	            return response;
	            
	        }catch (Exception e)
	        {
	            log.info("Exception Occured at Endpoint {}",e);
	        }
	        return response;
	    }

}
