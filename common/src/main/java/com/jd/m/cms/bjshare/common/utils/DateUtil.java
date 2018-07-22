package com.jd.m.cms.bjshare.common.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {


	public static SimpleDateFormat YYMMDDHHMM = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public static SimpleDateFormat YYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static Date formatStringToDate(String date, SimpleDateFormat sdf) {
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static String formatDateToString(Date date, SimpleDateFormat sdf) {
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
	 * 比较date2比date1多的秒
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getSecondsDifferDate(String date1,String date2){
		long second = 0;
		try {
			Date d1 = YYMMDDHHMMSS.parse(date1);
			Date d2 = YYMMDDHHMMSS.parse(date2);
			long time1 = d1.getTime();
			long time2 = d2.getTime();
			second = (time2-time1)/1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return second;
	}

	/**
	 * 时间戳转换成日期格式字符串
	 * @param mil 精确到秒的字符串
	 * @param format
	 * @return
	 */
	public static String timeStamp2Date(String mil,String format) {
		if(mil == null || mil.isEmpty() || mil.equals("null")){
			return "";
		}
		if(format == null || format.isEmpty()){
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(Long.valueOf(mil)));
	}

	public static void main(String[] args) throws ParseException{
		Date date = new Date();
		String sTime = DateUtil.formatDateToString(date, DateUtil.YYMMDDHHMMSS);
		long second = DateUtil.getSecondsDifferDate(sTime,"2018-04-28 00:00:00");
		System.out.println(second);
	}
}
