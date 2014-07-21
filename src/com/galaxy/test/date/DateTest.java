package com.galaxy.test.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest
{
	private static final int LOGIN_GIFT_DURATION = 0x7;
	private static final int SIGN_GIFT_DURATION = 0x12;
	
	private static final String LOGIN_GIFT_START_DATE = "2014-01-31 00:00:00";
	private static final String SIGN_GIFT_START_DATE = "2014-01-20 00:00:00";
	
	public static void main(String[] args)
	{
		int days = daysBetween("2014-01-10 00:00:00");
		int result = LOGIN_GIFT_DURATION & days;
		System.out.println(Integer.toBinaryString(result));
		
		days = daysBetween("2014-01-06 00:00:00");
		result = LOGIN_GIFT_DURATION & days;
		System.out.println(Integer.toBinaryString(result));
		
	}
	
	public static int daysBetween(String beforeDate)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			Calendar cal = Calendar.getInstance();
			
			cal.setTime(sdf.parse(beforeDate));
			long stime = cal.getTimeInMillis();
			cal.setTime(sdf.parse(sdf.format(new Date())));
			long btime = cal.getTimeInMillis();
			
			long between_days = (btime - stime) / (1000 * 60 * 60 * 24);
			
			return Integer.parseInt(String.valueOf(between_days));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

		return -1;
	}
}
