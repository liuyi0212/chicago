package com.medishare.chicago.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

public class DateUtils {

	/**
	 * 根据出生日期获取年龄
	 * @param birthDay 出生日期
	 * @return
	 * @throws Exception
     */
	public static String getAge(Date birthDay) throws Exception {
		Calendar cal = Calendar.getInstance();

		if (cal.before(birthDay)) {
			throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
		}

		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(birthDay);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				// monthNow==monthBirth
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				// monthNow>monthBirth
				age--;
			}
		}

		return age + "";
	}

	/**
	 * 日期类型转换为字符串
	 * @param date 日期
	 * @param format 字符串格式
     * @return
     */
	public static String format(Date date,String format){
		if(date==null){
			return null;
		}
		if(StringUtils.isEmpty(format)){
			format = "yyyy-MM-dd";
		}
		return new SimpleDateFormat(format).format(date);
	}
	
	/**
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param startFormat 开始时间字符串格式
	 * @param endFormat 结束时间字符串格式
	 * @param associativeSymbol 连接符号
	 * @return 示例默认:2017年08月28日15时-16时
	 */
	public static String formatTimeSection(Date startTime,Date endTime,String startFormat,String endFormat,String associativeSymbol){
	    if (startTime == null || endTime == null) {
	        return null;
	    }
	    if(StringUtils.isEmpty(startFormat)){
	      startFormat = "yyyy年MM月dd日HH时";
	    }
	    if(StringUtils.isEmpty(endFormat)){
	      endFormat = "HH时";
	    }
	    if(StringUtils.isEmpty(associativeSymbol)){
	      associativeSymbol = "-";
	    }
	    String start = new SimpleDateFormat(startFormat).format(startTime);
	    String end = new SimpleDateFormat(endFormat).format(endTime);
	    return start + associativeSymbol + end;
	}

	/**
	 * 字符串转换日期类型
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
     */
	public static Date toDate(String date,String format) throws ParseException{
		if(date==null){
			return null;
		}
		if(StringUtils.isEmpty(format)){
			format = "yyyy-MM-dd";
		}
		return new SimpleDateFormat(format).parse(date);
	}

	/**
	 * 获取两个日期相差的天数
	 * @param date 日期
	 * @param otherDate 另一个日期
	 * @return 相差天数
	 */
	public static int getIntervalDays(Date date, Date otherDate) {
		long time = Math.abs(date.getTime() - otherDate.getTime());
		return (int)(time/(24 * 60 * 60 * 1000));
	}
	
	/**
	 * 发现getIntervalDays方法计算的月末和下个月初时间之间的天数有误所以新写一个
     * 获取两个日期相差的天数 2017-07-31 
     * @param date 日期
     * @param otherDate 另一个日期
     * @return 相差天数
     */
    public static int getIntervalDays1(Date date, Date otherDate) {
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(date);
        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
        aCalendar.setTime(otherDate);
        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
        return day1 - day2;
    }

	/**
	 * 获取日期对应的星期
	 * @param date 日期
	 * @return 星期
	 */
	public static String getWeek(Date date) {
		String week = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekNumber = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		switch (weekNumber) {
			case 0:
				week = "星期日";
				break;
			case 1:
				week = "星期一";
				break;
			case 2:
				week = "星期二";
				break;
			case 3:
				week = "星期三";
				break;
			case 4:
				week = "星期四";
				break;
			case 5:
				week = "星期五";
				break;
			case 6:
				week = "星期六";
				break;
		}
		return week;
	}

	/**
     * 获取日期对应的星期(0:星期日  1:星期一  2:星期二 3:星期三--> 6:星期六)
     * @param date 日期
     * @return 星期
     */
    public static int getWeekNumber(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekNumber = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return weekNumber;
    }
	
	/**
	 * 获取相隔天的日期
	 * @param date
	 * @param count 正数代表取将来时间，负数为过去时间
     * @return
     */
	public static Date getPrefixDate(Date date,int count){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE,count);   // int amount   代表天数
		return cal.getTime();
	}

	/**
	 *  返回年份
	 *  @param  date 日期
	 *  @return  返回年份
	 */
	public  static  int  getYear(Date  date)  {
		Calendar  c  =  Calendar.getInstance();
		c.setTime(date);
		return  c.get(Calendar.YEAR);
	}

	/**
	 *  返回月份
	 *  @param  date 日期
	 *  @return  返回月份
	 */
	public  static  int  getMonth(Date  date)  {
		Calendar  c  =  Calendar.getInstance();
		c.setTime(date);
		return  c.get(Calendar.MONTH)  +  1;
	}

	/**
	 *  返回日份
	 *  @param  date 日期
	 *  @return  返回日份
	 */
	public  static  int  getDay(Date  date)  {
		Calendar  c  =  Calendar.getInstance();
		c.setTime(date);
		return  c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 *  返回小时
	 *  @param  date 日期
	 *  @return  返回小时
	 */
	public  static  int  getHour(Date  date)  {
		Calendar  c  =  Calendar.getInstance();
		c.setTime(date);
		return  c.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 *  返回分钟
	 *  @param  date 日期
	 *  @return  返回分钟
	 */
	public  static  int  getMinute(Date  date)  {
		Calendar  c  =  Calendar.getInstance();
		c.setTime(date);
		return  c.get(Calendar.MINUTE);
	}

	/**
	 *  返回秒钟
	 *  @param  date 日期
	 *  @return  返回秒钟
	 */
	public  static  int  getSecond(Date  date)  {
		Calendar  c  =  Calendar.getInstance();
		c.setTime(date);
		return  c.get(Calendar.SECOND);
	}

	/**
	 * 获取两个日期相差的天数
	 * @param date 日期
	 * @param otherDate 另一个日期
	 * @return 相差天数
	 */
	public static int getIntervalMinutes(Date date, Date otherDate) {
		long time = Math.abs(date.getTime() - otherDate.getTime());
		return (int)(time/(60 * 1000));
	}
	
	/**
	 * 获取2个时间相差的天数    getIntervalMinutes方法测试有问题 故新加一个
	 * @param date
	 * @param otherDate
	 * @return
	 */
	public static int getDisparityTime(Date date, Date otherDate) {
	  long nd = 1000 * 24 * 60 * 60;
      // 获得两个时间的毫秒时间差异
      long diff = date.getTime() - otherDate.getTime();
      // 计算差多少天
      long day = diff / nd;
      return (int)Math.abs(day);
	}
	
	/** 获取两个月份之间的月份
	   * 
	   * @param minDate
	   * @param maxDate
	   * @return
	   * @throws ParseException */
	public static List<Map<String, String>> getMonthBetween(String minDate, String maxDate, String format ,boolean flag)
	    throws ParseException {
	    ArrayList<Map<String, String>> result = new ArrayList<Map<String, String>>();
	    if (StringUtils.isEmpty(minDate) || StringUtils.isEmpty(maxDate)) {
	      return result;
	    }
	    if (StringUtils.isEmpty(format)) {
	      format = "yyyy-MM";
	    }
	    SimpleDateFormat sdf = new SimpleDateFormat(format);// 格式化为年月

	    Calendar min = Calendar.getInstance();
	    Calendar max = Calendar.getInstance();

	    min.setTime(sdf.parse(minDate));
	    min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

	    max.setTime(sdf.parse(maxDate));
	    max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

	    Calendar curr = min;
	    int count = 0;// 适配机型处理时间格式 尽量将时间展示简化
	    while (curr.before(max)) {
	      count ++;
	      String month = sdf.format(curr.getTime());
	      Map<String, String> map = new HashMap<>();
	      if (flag) {
	        if (count == 1) {
	          map.put("month", month);
	          map.put("showMonth", month.replaceAll("-", "/"));
	        } else {
	          map.put("month", month);
              map.put("showMonth", month.substring(5));
	        }
	      } else {
	        map.put("month", month);
            map.put("showMonth", month);
	      }
	      result.add(map);
	      curr.add(Calendar.MONTH, 1);
	    }
	    return result;
	}

	public static Date getIncreaseDay(Date date,int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, amount);//+1今天的时间加一天
        date = calendar.getTime();
        return date;
    }

	/**
	 * 获取未来日期
	 * @param str：字符串日期格式必须为yyyy-MM-dd past
	 * @param past：相隔天数
	 * @return
	 */
    public static List<String> getFutureDateCollection(String str, int past) throws ParseException {
		Date date = toDate(str, null);
		List<String> dateCollection = new ArrayList<>();
		SimpleDateFormat format;
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		for(int i = 1; i<past; i++){
			now.set(Calendar.DATE, now.get(Calendar.DATE) + 1);
			format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
			dateCollection.add(format.format(now.getTime()));
		}
		return dateCollection;
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println(getIntervalDays(new Date(),toDate("20170320 10:16","yyyyMMdd HH:mm")));
	}
}
