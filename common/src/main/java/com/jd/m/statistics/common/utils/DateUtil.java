package com.jd.m.statistics.common.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {


	public static SimpleDateFormat YYMMDDHHMM = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public static SimpleDateFormat YYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static SimpleDateFormat YYMMDD = new SimpleDateFormat("yyyyMMdd");

	public static SimpleDateFormat YY_MM_DD = new SimpleDateFormat("yyyy.MM.dd");

	public static final String YYMMDDHHMMSS_STR="yyyy-MM-dd HH:mm:ss";
	public static final String YYMMDD_STR="yyyyMMdd";

	public static Date formatStringToDate(String date, SimpleDateFormat sdf) {
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			System.out.println("date:" + date + " format error");
			return null;
		}
	}

	public static Date formatStringToDate(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			System.out.println("date:" + date + " format error");
			return null;
		}
	}

	public static String formatDateToString(Date date, SimpleDateFormat sdf) {
		return sdf.format(date);
	}

	public static String formatDateToString(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 获取当前时间时间戳精确到分
	 * @return
	 */
	public static long getNowMinuteTime(){
		long time = System.currentTimeMillis();
		return time / 60000 * 60000;
	}

	/**
	 * 在一个时间上 加几天
	 * @param date
	 * @param num
	 * @return
	 */
	public static Date datePlusDays(Date date,int num){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, num);
		return calendar.getTime();
	}

	public static  int calTimeSeconds(Date endDate, Date startDate) {
		long a = endDate.getTime();
		long b = startDate.getTime();
		int c = (int)((a - b) / 1000);
		return c;
	}

	public static void main(String[] args) throws ParseException{
		System.out.println(formatStringToDate("2013-04-03 10:00", YYMMDDHHMM));
		System.out.println(formatDateToString(new Date(),YYMMDD));
		System.out.println(formatDateToString(datePlusDays(new Date(),-1),YYMMDD));
		System.out.println(calTimeSeconds(datePlusDays(new Date(),-1),new Date()));
	}
}
