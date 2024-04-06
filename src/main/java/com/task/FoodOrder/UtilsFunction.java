package com.task.FoodOrder;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class UtilsFunction {
	public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
		System.out.println(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()));
	    return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
}
