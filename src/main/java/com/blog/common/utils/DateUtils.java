package com.blog.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 日期工具类
 * @author sfit0254
 * @date 2014-4-9
 */
public class DateUtils {
	
	/**
	 * 根据时间字符串获取日期
	 * @param dataStr	时间字符串
	 * @return			日期
	 */
	public static Date tranStrToDate(String dataStr) {
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.parse(dataStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据传入时间转换为毫秒值，附加纳秒后六位
	 * @param dateTime
	 * @return
	 * @throws ParseException
	 */
	public static String getTimeToNanos(String dateTime) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime));
		Long curNanos = Math.abs(System.nanoTime());
		String nanos = curNanos.toString();
		return c.getTimeInMillis() + nanos.substring(nanos.length() - 6);
	}
	
	/**
	 * 获取当前日期
	 * @return		当前日期，格式：yyyy-MM-dd
	 */
	public static String getCurDate() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date());
	}
	
	/**
	 * 获取当前时间
	 * @return		当前时间，格式：yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurTime() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}
	
	/**
	 * 获取系统当前默认时区与指定时区的时间差.(单位:毫秒)
	 * @param timeZoneId 时区Id
	 * @return 系统当前默认时区与指定时区的时间差.(单位:毫秒)
	 */
	public static long getDiffTimeZoneRawOffset(String timeZoneId, long time) {
		long diffTime = TimeZone.getDefault().getRawOffset()
				- TimeZone.getTimeZone(timeZoneId).getRawOffset();
		long curTime = System.currentTimeMillis();
		return time - curTime + diffTime;
	}
	
	/**
	 * 
	 * @return
	 */
	public static String getSeqGenerator(){
		// 日期对象
		Calendar nowtime = new GregorianCalendar();
		// 年份
		String year = String.format("%04d", nowtime.get(Calendar.YEAR));
		// 月份
		String moth = String.format("%02d", nowtime.get(Calendar.MONTH));
		// 日份
		String date = String.format("%02d", nowtime.get(Calendar.DATE));
		// 时
		String hour = String.format("%02d", nowtime.get(Calendar.HOUR_OF_DAY));
		// 分
		String min = String.format("%02d", nowtime.get(Calendar.MINUTE));
		// 秒
		String sec = String.format("%02d", nowtime.get(Calendar.SECOND));
		// 毫秒
		String mil = String.format("%03d", nowtime.get(Calendar.MILLISECOND));
		StringBuffer sbstr = new StringBuffer();
		sbstr.append(year).append(moth).append(date).append(hour).append(min).append(sec).append(mil);
		return sbstr.toString();
	}
	/**
	 * 返回商家编号
	 * @return
	 */
	public static String getBusinessSid(){
		// 日期对象
		Calendar nowtime = new GregorianCalendar();
		// 年份
		String year = String.format("%04d", nowtime.get(Calendar.YEAR));
		// 月份
		String moth = String.format("%02d", nowtime.get(Calendar.MONTH));
		// 日份
		String date = String.format("%02d", nowtime.get(Calendar.DATE));
		// 时
		String hour = String.format("%02d", nowtime.get(Calendar.HOUR_OF_DAY));
		// 分
		String min = String.format("%02d", nowtime.get(Calendar.MINUTE));
		// 秒
		String sec = String.format("%02d", nowtime.get(Calendar.SECOND));
		// 毫秒
		String mil = String.format("%03d", nowtime.get(Calendar.MILLISECOND));
		String beg = "SJ";
		StringBuffer sbstr = new StringBuffer();
		sbstr.append(beg).append(year).append(moth).append(date).append(hour).append(min).append(sec).append(mil);
		return sbstr.toString();
	}
	
}
