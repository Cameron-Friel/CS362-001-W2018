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

		 startHour=22;
		 startMinute=30;
		 startDay=15;
		 startMonth=01;
		 startYear=2018;
		 title="Birthday Party";
		 description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt1 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 startHour=2;
		 startMinute=80;
		 startDay=15;
		 startMonth=01;
		 startYear=2018;
		 title="Birthday Party";
		 description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt2 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		  GregorianCalendar today = new GregorianCalendar(startYear,startMonth,startDay);
			StringBuilder sb = new StringBuilder();
			CalDay temp = new CalDay(today);
			CalDay empty = new CalDay();

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
			temp.addAppt(appt1);

			//assertFalse(appt1.getValid());

			temp.addAppt(appt2);

			//assertTrue(appt2.getValid());

			//assertFalse(appt.getValid());

			//assertFalse(temp.isValid());

		 	//assertEquals(temp.getAppts().iterator(), temp.getAppts().iterator());

		 	temp.toString();
		 	empty.toString();

		 	assertEquals(true, appt.getValid());

			temp.valid = false;

			assertEquals(null, temp.iterator());

			assertEquals(temp.toString(), temp.toString());
			//assertEquals(sb.toString())
			//temp.setAppts(new LinkedList<Appt>());
			//assertFalse(null, temp.setAppts(new LinkedList<Appt>()));
	 }
	 @Test
	  public void test02()  throws Throwable  {

	 }
//add more unit tests as you needed
}
