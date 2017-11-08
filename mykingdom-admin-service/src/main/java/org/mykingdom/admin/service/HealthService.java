package org.mykingdom.admin.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class HealthService {
	
	public String health() {
		return String.format("hello admin service now at %s", new SimpleDateFormat("yyyy-MM-dd HH:ss").format(new Date()));
	}
	
}
