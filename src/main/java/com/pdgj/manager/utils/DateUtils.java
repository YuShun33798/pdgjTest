package com.pdgj.manager.utils;

import org.springframework.util.StringUtils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    /**
     * 格式化日期
     * @param date 日期
     * @param pattern 日期格式
     * @return String
     */
    public static String date2Str(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
    /**
     * 将long类型的秒数，转换为日期
     * @param startTime 秒
     * @return Date
     */
    public static Date sec2Date(long startTime) {
        return new Date(startTime*1000);
    }

    /**
     * 将long类型的秒数，转换为日期
     * @param startTime 毫秒数
     * @return Date
     */
    public static Date ms2Date(long startTime) {
        return new Date(startTime);
    }
    /**
     * 日期转为秒数
     * @param date
     * @return
     */
    public static long date2Second(Date date) {
        if(date==null){
            return 0;
        }
        return date2mil(date)/1000;
    }
    /**
     * 日期转为毫秒数
     * @param date
     * @return
     */
    public static long date2mil(Date date) {
        if(date==null){
            return 0;
        }
        return date.getTime();
    }
    /**
     * 获取指定日期前几天/时/分/秒的日期
     * @param time 指定日期
     * @param count 间隔
     * @param type  间隔类型  1-天  2-时 3-分  -4秒
     * @param pattern 日期格式
     * @return
     */
    public static Date before(String time, int count, int type,String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(str2Date(time, pattern));
        switch (type) {
            case 1:
                cal.add(Calendar.DAY_OF_MONTH, count);break;
            case 2:
                cal.add(Calendar.HOUR_OF_DAY, count);break;
            case 3:
                cal.add(Calendar.MINUTE, count);break;
            case 4:
                cal.add(Calendar.SECOND, count);break;
            default:break;
        }
        return cal.getTime();
    }

    /**
     * 获取指定日期前几天/时/分/秒的日期
     * @param time 指定日期
     * @param count 间隔
     * @param type  间隔类型  1-天  2-时 3-分  4-秒
     * @return Date
     */
    public static Date before(Date time, int count, int type) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        switch (type) {
            case 1:
                cal.add(Calendar.DAY_OF_MONTH, count);break;
            case 2:
                cal.add(Calendar.HOUR_OF_DAY, count);break;
            case 3:
                cal.add(Calendar.MINUTE, count);break;
            case 4:
                cal.add(Calendar.SECOND, count);break;
            default:break;
        }
        return cal.getTime();
    }

    /**
     * 字符串日期转日期
     * @param source 字符串日期
     * @param pattern 日期格式
     * @return
     */
    public static Date str2Date(String source,String pattern){
        try {
            if(StringUtils.isEmpty(source)){
                return new Date();
            }
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到该时间的月份天数
     * @param time
     * @param pattern
     * @return
     */
    public static Integer getMaxDay(String time, String pattern){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(str2Date(time, pattern));
        Integer maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return maxDay;
    }

    /**
     * 得到当前时间的上一个月
     *
     * @return
     */
    public static Date getLastMonthDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月      +为后一个月  0 为本月
        return calendar.getTime();
    }

    /**
     * 得到昨天的时间
     *
     * @return
     */
    public static Date getLastDayDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // 设置为当前时间
        calendar.add(Calendar.DATE, -1); // 设置为上一个月      +为后一个月  0 为本月
        return calendar.getTime();
    }
    
    /**
     * 比较两个时间大小
     * @param time1 2020-08-30 16:11:16
     * @param time2 2020-08-30 16:18:18
     * @return time2>time1 true time2<=time1 false
     * @throws ParseException
     */
    public static boolean compare(String time1,String time2) throws ParseException{
		//如果想比较日期则写成"yyyy-MM-dd"就可以了
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//将字符串形式的时间转化为Date类型的时间
		Date a=sdf.parse(time1);
		Date b=sdf.parse(time2);
		//Date类的一个方法，如果a早于b返回true，否则返回false
		if(a.before(b)) {
			return true;
		}else {
			return false;
		}
	}
    
    public static void getLujing() throws Exception{
        //当前项目下路径
        File file = new File("");
        String filePath = file.getCanonicalPath();
        System.out.println(filePath);
 
        //当前项目下xml文件夹
        File file1 = new File("");
        String filePath1 = file1.getCanonicalPath()+File.separator+"xml\\";
        System.out.println(filePath1);
 
        //获取所有的类路径 包括jar包的路径
        System.out.println(System.getProperty("java.class.path"));
    }

    //获得今天是星期几
    public static String getWhatDay(){
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar=Calendar.getInstance();
        return weekDays[calendar.get(Calendar.DAY_OF_WEEK)-1];
    }
    
    //获取当前时间 当前时间:2020-11-11 09:53:30
    public static String getDateNow() {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    	String dateNow=df.format(new Date());
    	return dateNow;
    }

    //获取当前时间 当前时间:2020-11-11
    public static String getDateNumNow() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        Calendar calendar = Calendar.getInstance();
        String dateName = df.format(calendar.getTime());
        return dateName;
    }
    
    public static void main(String[] args) throws Exception{
//    	System.out.println("字符串日期转日期>"+DateUtils.str2Date("20191125", "yyyymmdd"));
//    	Date date=new Date();
//    	String dataTimeNow=DateUtils.date2Str(date, "yyyyMMdd");
//    	String dataTimeNow1=DateUtils.date2Str(date, "yyyy-MM-dd");
//    	String dataTimeNow2=DateUtils.date2Str(DateUtils.before(date, -1,1),"yyyy-MM-dd");
//    	System.out.println("当前时间：>"+"dataTimeNow:"+dataTimeNow+",dataTimeNow1:"+dataTimeNow1);
//    	System.out.println("当前时间前一天:>"+"dataTimeNow2:"+dataTimeNow2);
//    	System.out.println(DateUtils.date2Str(new Date(),"yyyyMMdd"));
//    	System.out.println(DateUtils.date2Str(new Date(),"yyyyMMdd HH:mm:ss"));
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        //System.out.println(dateFormat.format(DateUtils.getLastDayDate()));
    	/*try {
			System.out.println(DateUtils.compare("2020-08-30 16:11:16", "2020-08-30 16:11:16"));
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
    	
//    	String str="CHG_SEG_20200914163001";
//		str=str.substring(8,20);
//		str=DateUtils.str2Date(str,"yyyy-MM-dd hh:mm:ss").toString();
//		String str2="20200914163001";
//		str2=str2.substring(0,12); //202009141725  2020-09-14 17:25
//		str2=str2.substring(0,4)+"-"+str2.substring(4,6)+"-"+str2.substring(6,8)+" "+str2.substring(8,10)+":"+str2.substring(10,12)+":"+str2.substring(12,14); 
//		str2=DateUtils.str2Date(str2,"yyyyMMddhh:mm").toString();
//		System.out.println(str);
//		System.out.println(DateUtils.compare(str,str2));
//		System.out.println(str2);
//		SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        SimpleDateFormat formatter2  = new SimpleDateFormat("yyyyMMddHH:mm");
//        Date  date = formatter2.parse(str2);
//        String  dString = formatter.format(date);
//        System.out.println(date);
		
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = simpleDateFormat.parse(str2);
//        long ts = date.getTime();
//        str2 = String.valueOf(ts);
//        System.out.println(str2);
//        System.out.println(DateUtils.compare("2020-09-15 15:10:01", str2)); // false 
//        System.out.println(DateUtils.compare("2020-09-13 15:10:01", str2)); //  true
//        System.out.println(DateUtils.compare("", str2)); //  true
//        System.out.println(DateUtils.compare(null, str2)); //  true
    	
    	//当前项目下路径
//        File file = new File("");
//        String filePath = file.getCanonicalPath();
//        System.out.println(filePath);
//        
//      //当前项目下xml文件夹
//        File file1 = new File("");
//        String filePath1 = file1.getCanonicalPath()+File.separator+"xml\\";
//        System.out.println(filePath1);
// 
//        //获取所有的类路径 包括jar包的路径
//        System.out.println(System.getProperty("java.class.path"));
    	
//    	String sliceTime="20201111061000";
//    	String sliceTime="20201111161000";
//    	String time1=sliceTime.substring(0,4)+"-"+sliceTime.substring(4,6)+"-"+sliceTime.substring(6,8)+" "
//				+sliceTime.substring(8,10)+":"+sliceTime.substring(10,12)+":"+sliceTime.substring(12,14);
//    	System.err.println("换乘客流时间:"+time1);
//    	String time2=DateUtils.getDateNow();
//        System.out.println("当前时间:"+time2);// new Date()为获取当前系统时间
        //time1 换乘客流时间:2020-11-11 06:10:00;
        //time2 当前时间:2020-11-11 09:50:36 
        //time1<time2 当前时间在换乘客流时间之后
//		boolean flag= DateUtils.compare(time1,time2); 
        
        
        //time1 换乘客流时间:2020-11-11 16:10:00
        //time2 当前时间:2020-11-11 09:53:30
        //time1>time2 当前时间在换乘客流时间之前
//        boolean flag= DateUtils.compare(time1,time2); 
//		System.out.println(flag);
	}
    
}
