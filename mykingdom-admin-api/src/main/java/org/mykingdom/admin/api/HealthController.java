package org.mykingdom.admin.api;

import org.mykingdom.admin.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class HealthController {
	
	@Autowired
	HealthService healthService;
	
	@GetMapping(value="/admin/health")
	public String health() {
		return healthService.health();
	}
	
}
