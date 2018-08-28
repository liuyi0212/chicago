package com.medishare.chicago.view;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: liuy
 * @date: 2018/8/16
 * @time: 下午7:03
 * @descripttion: com.medishare.chicago.view
 */
public class test {

    public static void main(String[] args) {
//        int randomNum = new Random().nextInt(2);
//        List list = Arrays.asList("tuwen","dianhua","zhenhou");
//        for (int i = 0; i<100; i++){
//            Collections.shuffle(list);
//            System.out.println(list);
//        }
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));


//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        java.util.Date date=new java.util.Date();
//        java.util.Date date=randomDate("2018-08-20 10:00:00","2018-08-26 23:00:00");
//        String str=sdf.format(randomDateBetweenMinAndMax());
//        int randNumber =new Random().nextInt(22 - 10 + 1) + 22;


//        System.out.println(str);
        for(int i=0;i<100;i++){
            System.out.println(new Random().nextInt(22 - 10 + 1) + 10);
        }

    }

//    public static Date randomDateBetweenMinAndMax(){
//        Calendar calendar = Calendar.getInstance();
//        //注意月份要减去1
//        calendar.set(2018,8,20);
//        calendar.getTime().getTime();
//        //根据需求，这里要将时分秒设置为0
//        calendar.set(Calendar.HOUR_OF_DAY, new Random().nextInt(22 - 10 + 1) + 22);
//        calendar.set(Calendar.MINUTE, new Random().nextInt(60));
//        calendar.set(Calendar.SECOND,new Random().nextInt(60));
//        long min = calendar.getTime().getTime();
//        calendar.set(2018,8,26);
//        calendar.set(Calendar.HOUR_OF_DAY,new Random().nextInt(22 - 10 + 1) + 22);
//        calendar.set(Calendar.MINUTE,new Random().nextInt(60));
//        calendar.set(Calendar.SECOND,new Random().nextInt(60));
//        calendar.getTime().getTime();
//        long max = calendar.getTime().getTime();
//        //得到大于等于min小于max的double值
//        double randomDate = Math.random()*(max-min)+min;
//        //将double值舍入为整数，转化成long类型
//        calendar.setTimeInMillis(Math.round(randomDate));
//        return calendar.getTime();
//    }

//    private static Date randomDate(String beginDate, String endDate){
//        try {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date start = format.parse(beginDate);  // 构造开始日期
//            Date end = format.parse(endDate);  // 构造结束日期
//            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
//            if(start.getTime() >= end.getTime()){
//                return null;
//            }
//
//            long date = random(start.getTime(),end.getTime());
//
//            return new Date(date);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    private static long random(long begin,long end){
//        long rtn = begin + (long)(Math.random() * (end - begin));
//        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
//        if(rtn == begin || rtn == end){
//            return random(begin,end);
//        }
//        return rtn;
//    }
}
