package com.worktrim.healthcare.webservices.util;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service("timeStamp")
public class TimeStamp {
	

	
	
	/**
	 * Calculate date for 2 weeks ago
	 * */
	
	public String getDateFor2WeeksAgo(){
		
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -14); 

		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd"); 
		
		String thedate = sdate.format(new Date(cal.getTimeInMillis())).toString();
		
		return thedate;
	}
	
	/**
	 * Calculate date for 2 weeks in the future
	 * @return the date two weeks in future in the format  "yyyy-MM-dd"
	 * @author kingsley Mbah
	 * */
	
	public String getDateFor2WeeksInFuture(){
		
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +14); 

		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd"); 
		
		String thedate = sdate.format(new Date(cal.getTimeInMillis())).toString();
		
		return thedate;
	}
	
	 /**
	  * Calculate the difference between two times in hrs. The minutes and neeed nto be converted to corresponding Hours
	  * @param dateStarts The start time in 
	  * */
	
	public  double getDifferenceBetweenDateTimeInHrs(String dateStart, String dateStop){


		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date d1 = null;
		Date d2 = null;
		
		long diffHours = 0 ;

		try {
			
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);

			long diff = d2.getTime() - d1.getTime();

			diffHours= TimeUnit.MILLISECONDS.toMinutes(diff);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
			
		
		return   diffHours;
		
		
		
	}
	
	/**
	 * 
	 * @return the date in yyyy-MM-dd HH:mm:ss
	 */
	public String getcurrentDateTime (){

			   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			  
			   Date date = new Date();
			   
			   return dateFormat.format(date);

			
	}
	
	
	/**
	 * 
	 * @return the date in yyyy.MM.dd_HH.mm.ss
	 */
	public String getcurrentDateTimeFormat (){

			   DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");
			  
			   Date date = new Date();
			   
			   return dateFormat.format(date);

			
	}
	
	
	
	/**
	 * 
	 * @return the date in yyyy-MM-dd
	 */
	public String getcurrentDate (){

			   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			  
			   Date date = new Date();
			   
			   return dateFormat.format(date);

			
	}
	
	
	/**
	 * 
	 * @return the time in format HH:MM:SS
	 */
	public String getcurrentTime (){

		LocalTime currenttime = LocalTime.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ISO_TIME; 
		
		String formattedTime = currenttime.format(formatter);
		
		return formattedTime;

			
	}
	
	
	
	/**
	 * 
	 * @param startDate : The start date of your date range
	 * @param endDate : The end date of your date range
	 * @return: A list of the dates within your range in format yyyy-mm-dd
	 */
	
	public  List<LocalDate> getDatesBetweenTwoDates(LocalDate startDate, LocalDate endDate) { 
		
			     long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
			    
			     return IntStream.iterate(0, i -> i + 1).limit(numOfDaysBetween).mapToObj(i -> startDate.plusDays(i)).collect(Collectors.toList()); 
	 }
	
	/**
	 * Get the current year
	 */
	
	public int getCurrentYear () {
		
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year  = localDate.getYear();
		

		return year;
		 
	}
	
	/**
	 * 
	 * @param string The date in question
	 * @return the month, in mumber format(3 for 03).
	 */
	
	
	public int getMonthNumberFromDate(String date) {

		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate newlocalDate = LocalDate.parse(date, formatter);
			
			int month = newlocalDate.getMonthValue();
		
			return month;
		
	}
	
	/**
	 * 
	 * @param string The date in question
	 * @return The month name(String) corresponding to this date as a string.(ex. March)
	 */
	
	public String getMonthNameFromDate(String date) {
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate newlocalDate = LocalDate.parse(date, formatter);
		
		Month month = newlocalDate.getMonth();
	
		return month.toString();
		
	}
	
	/**
	 * 
	 * @param date The date in question
	 * @return The day of the week for this date, ex: Tuesday
	 */
	
	public String getTheDayOfWeekFromDate(String date) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate newlocalDate = LocalDate.parse(date, formatter);
		
		DayOfWeek dayOfWeek =  newlocalDate.getDayOfWeek();
		
		return dayOfWeek.toString();
		
	}
	
	/**
	 * Calculate datetime for  for 4 weeks ago
	 * @return : Date time for 4 weeks ago in the format yyyy-MM-dd HH:mm:ss
	 * */
	
	public String getDateTimeFor4WeeksAgo(){
		
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -27); 

		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		String thedate = sdate.format(new Date(cal.getTimeInMillis())).toString();
		
		return thedate;
	}
	
	/**
	 * 
	 * @param theirDOB The date of birth as a string
	 * @return boolean, true if the age is valid and false if it is not valid
	 * @throws ParseException Likely a date parse exception, If the date cannot be parsed.
	 */
	public boolean isUser16YearsOrOlder(String theirDOB) throws ParseException {
		
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		 String dateInString  = theirDOB;
		 
		 Date usersDate = formatter.parse(dateInString);
		 
		 
		 // Date for 16 years ago
		    Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, -16); 

			String thedate = formatter.format(new Date(cal.getTimeInMillis())).toString();
		    Date yrsAgo = formatter.parse(thedate);
			
			if(usersDate.before(yrsAgo)) {
				return true;
			}
			
		
	   return false;
	}
	
	/**
	 * This checks to see if the date occurs before today's Date.
	 * @param theDate : The Date you are trying to test
	 * @return boolean
	 * @throws ParseException 
	 */
	
	public boolean isDateOlderThanToday(String theDate){
		
		 String today = getcurrentDate();
		
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		 Date testDate = null;
		 Date todaysDate = null;
		try {
			testDate = formatter.parse(theDate);
			todaysDate =  formatter.parse(today);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(testDate != null &&  todaysDate != null) {
		  if(testDate.before(todaysDate)) {
			 return true;
		   }
		}
		return false;
		
	}
	
	/**
	 * 
	 * @return the date one ago from today!
	 */
	
	public String getDateFor1WeekAgo(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7); 

		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd"); 
		
		String thedate = sdate.format(new Date(cal.getTimeInMillis())).toString();
		
		return thedate;
	}
	
	
	/**
	 * 
	 * @return the date three weeks ago from today!
	 */
	
	public String getDateFor3WeeksAgo(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -21); 

		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd"); 
		
		String thedate = sdate.format(new Date(cal.getTimeInMillis())).toString();
		
		return thedate;
	}
	
	
  /**
   * 	
   * @return the current month name ex: January
   */
public String getcurrentMonthName() {
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate newlocalDate = LocalDate.parse( getcurrentDate(), formatter);
		
		Month month = newlocalDate.getMonth();
	
		return month.toString();
		
	}
	

/**
 * Calculate datetime for  for 6 months ago
 * @return : Date time for 6 months ago in the format yyyy-MM-dd
 * */

public String getDateFor6MonthsAgo(){
	
	
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DATE, -180); 

	SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd"); 
	
	String thedate = sdate.format(new Date(cal.getTimeInMillis())).toString();
	
	return thedate;
}

/**
 * 
 * @return the start date of current year in format yyyy-MM-dd
 */
public String getFirstDateOfCurrentYear() {
	
	String currentYear = String.valueOf(getCurrentYear());
	
	String theDate = currentYear + "-01-"+"01";
			
	return theDate;		
}

/**
 * 
 * @return The last date in yyyy-MM-dd format for current year
 */

public String getLastDateOfCurrentYear() {
	
  String currentYear = String.valueOf(getCurrentYear());
	
	String theDate = currentYear + "-12-"+"31";
			
	return theDate;	
}



/**
 * Converts a long date into date format 
 */

  public String convertLongTodate(long theDate) {
	  
	  
	  String pattern = "yyyy-MM-dd HH:mm:ss";
	  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	  String date = simpleDateFormat.format(theDate);
	 
	  
	  return date;
	  
  }
  
  /**
   * 
   * @param dateFrom Target start Date
   * @param dateTo Target End date
   * @return true if the start date occurs before the target end date
   * @throws ParseException
   */
  
	public boolean isDateFromBeforeDateTo(String dateFrom, String dateTo) throws ParseException {
		
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		 Date from = formatter.parse(dateFrom);
		 Date to =  formatter.parse(dateTo);
		 
		 if(from.before(to)) {
			 return true;
		 }

		return false;
		
	}
  
	/**
	 *  
	 * @param targetDate the target date
	 * @param todayDate current date
	 * @return true if this test date is today.
	 * @throws ParseException
	 */
	
   public boolean isDateToday(String targetDate, String todayDate) throws ParseException {
			
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 
			 Date todayDateFormat = formatter.parse(todayDate);
			 Date targetDateFormat =  formatter.parse(targetDate);
			 
			 if(targetDateFormat.before(todayDateFormat)) {
				return false;
			 }

			return true;
			
		}
   
   

public String getDateforNumberOfMonthsInFuture(int numberOfMonths){

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, numberOfMonths); 
	
		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd"); 
		
		String thedate = sdate.format(new Date(cal.getTimeInMillis())).toString();
		
		return thedate;
}
	  



public int getNumberOfMonthsBetweenTwoDates(String startDate, String endDate) {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    Date firstDate = null;
    Date secondDate = null;
	try {
		firstDate = sdf.parse(startDate);
	   secondDate = sdf.parse(endDate);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  
    
    

    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	
    int  diffMonths  = (int) (diff/30);
    
	return  diffMonths;
}
  


public String getTomorrowDateTime(){
	

	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DATE, +1); 

	SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"); 
	
	String thedate = sdate.format(new Date(cal.getTimeInMillis())).toString();
	sdate.setTimeZone(TimeZone.getTimeZone("CST"));
	return thedate;

}
  

/**
 * 
 * @param date The date in question
 * @return The day of the week for this date, ex: 6
 */

public int  getTheDayOfWeekNumberFromDate(String date) {
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate newlocalDate = LocalDate.parse(date, formatter);
	DayOfWeek dayOfWeek =  newlocalDate.getDayOfWeek();
	
	String dayString = dayOfWeek.toString();
	int dayNum;
	
	switch(dayString) {
		case "Monday" :
			dayNum = 1;
		 break;
		case "Tuesday" :
			dayNum = 2;
			 break;
		case "Wednesday" :
			dayNum = 3;
			 break;
		case "Thursday" :
			dayNum = 4;
			 break;
		case "Friday" :
			dayNum = 5;
			 break;
		case "Saturday" :
			dayNum = 6;
			 break;
		default :
			dayNum = 7;

	   }
	
	
	return dayNum;
	
   }



public int getNumberOfDaysBetweenTwoDates(String startDate, String endDate) {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    Date firstDate = null;
    Date secondDate = null;
	try {
		firstDate = sdf.parse(startDate);
	   secondDate = sdf.parse(endDate);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  
    
    

    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	
    int  diffDays  = (int) (diff);
    
	return   diffDays;
}
  
/**
 * 
 * @param targetDate The date we are looking to convert to the new format
 * @param theNewFormat The new output format
 * @return the new date with the new specified format as indicated by @param theNewFormat.
 */

public String convertDateToTargetFormat (String targetDate, String theNewFormat) {

  Date date = null;
	  
	try {
		date = new SimpleDateFormat("yyyy-MM-dd").parse(targetDate);
	} catch (ParseException e) {
		e.printStackTrace();
		return targetDate;
	}  
	
  DateFormat dateFormat = new SimpleDateFormat(theNewFormat);  
 
  String strDate = dateFormat.format(date);  
	
  return strDate;
	
}
	
}
