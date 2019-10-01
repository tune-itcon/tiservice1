/**
 * 
 */
package com.ti.tiservice1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ti.tiservice1.model.ServiceResponse;
import com.ti.tiservice1.service.BusService;

/**
 * @author duansubramaniam
 *
 */
@RestController
public class ServiceController {
	
	@Autowired
	BusService busService;

	@RequestMapping(value = "/getServiceName",  method = RequestMethod.GET)
	public ServiceResponse getServiceName(@RequestParam Long id) {
		String serviceName = busService.getServiceName(id);
		ServiceResponse response = new ServiceResponse(serviceName);
		return response;
	}
		
	
}
