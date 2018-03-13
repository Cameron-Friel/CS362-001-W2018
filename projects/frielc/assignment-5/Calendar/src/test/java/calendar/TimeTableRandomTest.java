package calendar;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

//import jdk.vm.ci.meta.Value;
import org.junit.Test;
//import sun.java2d.loops.GeneralRenderer;
//import sun.awt.image.ImageWatched;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"deleteAppt", "getApptRange"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
	public static int RandomSelectRecur(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n] ; // return the value of the  appointments to recur
	}
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
	public static int RandomSelectRecurForEverNever(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n] ; // return appointments to recur forever or Never recur
	}
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		 try{
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 long randomseed =System.currentTimeMillis(); //10
				 //			System.out.println(" Seed:"+randomseed );
				 Random random = new Random(randomseed);

				 int startHour=ValuesGenerator.RandInt(random);
				 int startMinute=ValuesGenerator.RandInt(random);
				 int startDay=ValuesGenerator.RandInt(random);;
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.RandInt(random);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 //Construct a new Appointment object with the initial data
				 Appt appt = new Appt(startHour,
						 startMinute ,
						 startDay ,
						 startMonth ,
						 startYear ,
						 title,
						 description);
				 if(!appt.getValid())continue;
				 for (int i = 0; i < NUM_TESTS; i++) {
					 String methodName = TimeTableRandomTest.RandomSelectMethod(random);
					 if (methodName.equals("deleteAppt")){
					 	TimeTable test = new TimeTable();
					 	int length = ValuesGenerator.getRandomIntBetween(random, 1, 11); //max length of 10, 11 means null

						 LinkedList<Appt> list = new LinkedList<Appt>();
						 LinkedList<Appt> empty = null;

						 for (int j = 0; j < length; j++) {
						 	int hour = (ValuesGenerator.getRandomIntBetween(random, -5, 30));
						 	int minute = (ValuesGenerator.getRandomIntBetween(random, -5, 65));
							int day = (ValuesGenerator.getRandomIntBetween(random, -5, 35));
							int month = (ValuesGenerator.getRandomIntBetween(random, 1, 12));
						 	Appt tempAppt = new Appt(hour, minute, day, month, startYear,title, description);
							 //appt.setStartHour(ValuesGenerator.getRandomIntBetween(random, -5, 30));
							 //appt.setStartMinute(ValuesGenerator.getRandomIntBetween(random, -5, 65));
							 //appt.setStartDay(ValuesGenerator.getRandomIntBetween(random, -5, 35));
							 //appt.setStartMonth(ValuesGenerator.getRandomIntBetween(random, 1, 12));

							 list.add(tempAppt);
						 }
						 int value = ValuesGenerator.getRandomIntBetween(random, 0, 10);

						 if (value == 8) {
							 Appt emptyAppt = null;
							 test.deleteAppt(empty, emptyAppt);
						 }
						 else if (value == 7) {
							 test.deleteAppt(empty, appt);
						 }
						 else if (value == 6) {
							 Appt emptyAppt = null;
							 test.deleteAppt(list, emptyAppt);
						 }
						 else if (value == 5) {
							 Appt emptyAppt = null;
							 test.deleteAppt(list, emptyAppt);
						 }
						 else {
						 	int max = (ValuesGenerator.getRandomIntBetween(random, 0, length - 1));
						 	if (max == length ) {
						 		length -= 1;
						 		if (length < 0) {
						 			max = 0;
								}
							}
							 test.deleteAppt(list, list.get(max));
							 //test.deleteAppt(list, appt);
						 }
					 }
					 else if (methodName.equals("getApptRange")){
						 /*TimeTable test = new TimeTable();
						 Calendar rightnow = Calendar.getInstance();
						 int thisMonth = rightnow.get(Calendar.MONTH)+1;
						 int thisYear = rightnow.get(Calendar.YEAR);
						 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

						 LinkedList<Appt> list = new LinkedList<Appt>();

						 int [] recurDaysArr = new int[]{3};
						 int [] recurDaysArr1 = new int[]{3};
						 int [] recurDaysArr2 = new int[]{3};

						 GregorianCalendar today = new GregorianCalendar(2002,01,01);
						 GregorianCalendar tomorrow = new GregorianCalendar(2000,01,01);

						 int h = ValuesGenerator.getRandomIntBetween(random, 1, 24);
						 int m = ValuesGenerator.getRandomIntBetween(random, 1, 60);
						 int d = ValuesGenerator.getRandomIntBetween(random, 1, 32);
						 int mo = ValuesGenerator.getRandomIntBetween(random, 1, 12);

						 Appt appointment1 = new Appt(h, 01, d, 01, 2000, title, description);
						 Appt appointment2 = new Appt(h, 01, d, 01, 2000, title, description);
						 Appt appointment3 = new Appt(h, 01, d, 01, 2000, title, description);

						 appointment1.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
						 appointment2.setRecurrence(recurDaysArr1, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
						 appointment3.setRecurrence(recurDaysArr2, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);

						 list.add(appointment1);
						 list.add(appointment2);
						 list.add(appointment3);

						 test.getApptRange(list, tomorrow, today);*/
						 try {
							 TimeTable test = new TimeTable();
							 Calendar rightnow = Calendar.getInstance();
							 int thisMonth = rightnow.get(Calendar.MONTH) + 1;
							 int thisYear = rightnow.get(Calendar.YEAR);
							 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
							 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
							 GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
							 //GregorianCalendar tomorrow = new GregorianCalendar(12, 27, 2019);
							 tomorrow.add(Calendar.DAY_OF_MONTH, 1);
							 LinkedList<Appt> list = new LinkedList<Appt>();
							 int length = ValuesGenerator.getRandomIntBetween(random, 0, 11); //max length of 10, 11 means null

							 for (int j = 0; j < length; j++) {
								 int h = ValuesGenerator.getRandomIntBetween(random, 1, 24);
								 int m = ValuesGenerator.getRandomIntBetween(random, 1, 60);
								 int d = ValuesGenerator.getRandomIntBetween(random, 1, 32);
								 int mo = ValuesGenerator.getRandomIntBetween(random, 1, 12);

								 Appt appointment1 = new Appt(h, m, d, mo, startYear, title, description);

								 if (ValuesGenerator.getRandomIntBetween(random, 0, 1) == 1) {
									 int[] recurDaysArr = {2, 3, 4};
									 appointment1.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
								 } else {
									 int[] recurDaysArr = {3};
									 appointment1.setRecurrence(recurDaysArr, 4, 1, 0);
								 }

								 list.add(appointment1);
								 //test.getApptRange(list, tomorrow, today);
							 }

							 //test.getApptRange(list, tomorrow, today);

							 int value = ValuesGenerator.getRandomIntBetween(random, 0, 1);

							 if (value == 1) { //throws exception since days are out of order, CAN'T USE
								 test.getApptRange(list, tomorrow, today);
							 } else {
								 test.getApptRange(list, today, tomorrow);
							 }
						 } catch (DateOutOfRangeException e) {
						 	continue;
						 }

						 /*try{
							 test.getApptRange(list, today, tomorrow);

						 }catch(DateOutOfRangeException e){
							 continue;
						 }*/
					 }
				 }

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if((iteration%10000)==0 && iteration!=0 )
					 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			 }
		 }catch(NullPointerException e){

		 }

		 System.out.println("Done testing...");
	 }
}
