package com.tgi.sms.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ApplicationUtils {

	public static Date getEnd(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(date.getTime()));
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	public static Date clearTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(date.getTime()));
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	public static Timestamp stringtoDate(String DateTime) throws ParseException {

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm");
			Date parsedDate = dateFormat.parse(DateTime);
			return new java.sql.Timestamp(parsedDate.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date getExpiryDate(Timestamp dateinTS) {
		Date date = dateinTS;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 30);
		Date finaldate = cal.getTime();
		return finaldate;
	}

}
