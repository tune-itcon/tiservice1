/**
 * 
 */
package com.ti.tiservice1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ti.tiservice1.ServiceRepository;

/**
 * @author duansubramaniam
 *
 */

@Service
public class BusService {
	
	@Autowired
	ServiceRepository serviceRepository;
	
	public String getServiceName(Long id) {
		Optional<String> serviceName = serviceRepository.findById(id);
		return serviceName.get();
	}

}
