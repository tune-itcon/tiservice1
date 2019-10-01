/**
 * 
 */
package com.ti.tiservice1.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ti.tiservice1.ServiceRepository;

/**
 * @author duansubramaniam
 *
 */
public class BusServiceTest {
	
	@Mock
	ServiceRepository serviceRepository;

	@InjectMocks
	BusService busService;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(serviceRepository.findById(1l)).thenReturn(Optional.of("service1"));
	}

	@Test
	public void test() {
		Long id = 1l;
		String serviceName = busService.getServiceName(id);
		
		assertEquals(serviceName, "service1");
		
		Hashmap map = new Hashmap();
		
		
		map.
	}

}
