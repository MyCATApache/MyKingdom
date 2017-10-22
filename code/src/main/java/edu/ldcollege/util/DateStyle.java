package edu.ldcollege.util;

/**
 * 
 * @author Raindrops on 2017 10 19
 *
 */
public enum DateStyle {
	
	YYYY_MM_DD_HH_MM("yyyy-MM-dd HH:mm"),  
    YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss"),  
    
    ;
	
	private String pattern;
	
	DateStyle(String pattern) {
		this.pattern = pattern ;
	}

	public String getValue() {
		return pattern;
	}

}
