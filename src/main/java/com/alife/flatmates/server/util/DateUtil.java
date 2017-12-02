package com.alife.flatmates.server.util;

import java.util.Date;

/**
 * An util class to manage date related tasks.
 * 
 * @author  santosh sagar
 * @version 0.0.1
 * @since   26 Nov 2017
 *
 */
public class DateUtil {
	
	/**
	 * To find out current system date.
	 * 
	 * @return System current date object.
	 * @see Date
	 * 
	 */
	public static Date getCurrentDate(){
		return new Date();
	}
	
	private DateUtil(){
		// To not allow other to create object
	}

}
