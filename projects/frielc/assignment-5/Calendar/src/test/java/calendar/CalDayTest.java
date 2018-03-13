package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
			int startHour=21;
			int startMinute=30;
			int startDay=15;
			int startMonth=01;
			int startYear=2018;
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

		  GregorianCalendar today = new GregorianCalendar(startYear,startMonth,startDay);
			StringBuilder sb = new StringBuilder();
			CalDay temp = new CalDay(today);

			assertEquals(15, temp.getDay());
			assertEquals(2018, temp.getYear());
			assertEquals(01, temp.getMonth());
			LinkedList<Appt> listAppts = new LinkedList<Appt>();
			assertEquals(listAppts, temp.getAppts());
			assertEquals(0, temp.getSizeAppts());

			String test = temp.toString();

			assertEquals(test, temp.toString());

			LinkedList<Appt> beforeAppts = new LinkedList<Appt>();
			LinkedList<Appt> afterAppts = new LinkedList<Appt>();

			temp.addAppt(appt);

			assertTrue(appt.getValid());
	 }
	 @Test
	  public void test02()  throws Throwable  {

	 }
//add more unit tests as you needed
}
