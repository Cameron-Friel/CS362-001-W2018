package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
		 assertEquals(2, appt.getRecurBy());
		 assertEquals(0, appt.getRecurNumber());
		 assertEquals(0, appt.getRecurIncrement());
		 //int[] recurringDays = new int[0];
		 //assertEquals(recurDays, appt.getRecurDays());
		 assertFalse(appt.isRecurring());
		 //assertEquals(2184, appt.compareTo(Appt compareAppt));
		 //String date = "9:30am";
		 //assertEquals(date, appt.represntationApp());

	 }

	 @Test
	  public void test02()  throws Throwable  {
		 int startHour=22;
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

		 startHour = 15;
		 startMinute = 24;
		 startDay = 10;
		 startMonth = 02;
		 startYear = 2019;
		 title = "Meeting";
		 description = "Company meeting.";

		 Appt appt2 = new Appt(startHour,
							 startMinute ,
							 startDay ,
							 startMonth ,
							 startYear ,
							 title,
							description);
 	// assertions
 		 assertTrue(appt.getValid());
 		 assertEquals(22, appt.getStartHour());
 		 assertEquals(30, appt.getStartMinute());
 		 assertEquals(15, appt.getStartDay());
 		 assertEquals(01, appt.getStartMonth());
 		 assertEquals(2018, appt.getStartYear());
 		 assertEquals("Birthday Party", appt.getTitle());
 		 assertEquals("This is my birthday party.", appt.getDescription());
		 assertEquals(16, appt.compareTo(appt2));
		 String day= appt.getStartMonth()+"/"+appt.getStartDay()+"/"+appt.getStartYear() + " at ";
		 //assertEquals("01/15/2018 at", appt.toString())
	 }
//add more unit tests as you needed
@Test
 public void test03()  throws Throwable  {
	int startHour=23;
	int startMinute=59;
	int startDay=28;
	int startMonth=1;
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
// assertions
	assertEquals(true, appt.getValid());
	appt.setStartHour(-1);
	assertEquals(false, appt.getValid());
	appt.setStartHour(28);
	assertEquals(false, appt.getValid());
	appt.setStartHour(0);
	assertEquals(true, appt.getValid());

	assertEquals(true, appt.getValid());
	appt.setStartMinute(0);
	assertEquals(true, appt.getValid());
	appt.setStartMinute(56);
	assertEquals(true, appt.getValid());
	appt.setStartMinute(-5);
	assertEquals(false, appt.getValid());
	appt.setStartMinute(64);
	assertEquals(false, appt.getValid());

	appt.setStartMinute(40);
	assertEquals(true, appt.getValid());
	appt.setStartDay(21);
	assertEquals(true, appt.getValid());
	appt.setStartDay(31);
	assertEquals(true, appt.getValid());
	appt.setStartDay(0);
	assertEquals(false, appt.getValid());
	appt.setStartDay(1);
	assertEquals(true, appt.getValid());
	/*appt.setStartDay(-4);
	assertEquals(false, appt.getValid());*/

	appt.setStartDay(5);
	appt.setStartMonth(1);
	assertEquals(true, appt.getValid());
	/*appt.setStartMonth(0);
	assertEquals(true, appt.getValid());*/
/*	appt.setStartMonth(-4);
	assertEquals(false, appt.getValid());
	appt.setStartMonth(13);
	assertEquals(false, appt.getValid());*/

	appt.setStartYear(2018);
	assertEquals(true, appt.getValid());

	appt.setRecurrence(null, 0, 0, 0);
	assertEquals(0, appt.getRecurBy());
	appt.setRecurrence(null, 1, 0, 0);
	assertEquals(1, appt.getRecurBy());

	appt.setRecurrence(null, 0, 0, 0);
	assertEquals(0, appt.getRecurIncrement());
	appt.setRecurrence(null, 0, 1, 0);
	assertEquals(1, appt.getRecurIncrement());

	appt.setRecurrence(null, 0, 0, 0);
	assertEquals(0, appt.getRecurNumber());
	appt.setRecurrence(null, 0, 0 ,1);
	assertEquals(1, appt.getRecurNumber());

	//int [] testArr = new int[0];
	appt.setRecurrence(null, 0, 0, 0);
	//assertEquals(new int[0], appt.getRecurDays());
	int [] arr = {69, 420, 0};
	appt.setRecurrence(arr, 0, 0, 0);
	assertEquals(arr, appt.getRecurDays());

	appt.setStartHour(10);
	assertEquals("\t1/5/2018 at 10:40am ,Birthday Party, This is my birthday party.\n", appt.toString());
	appt.setStartHour(0);
	assertEquals("\t1/5/2018 at 12:40am ,Birthday Party, This is my birthday party.\n", appt.toString());
	appt.setStartHour(12);
	assertEquals("\t1/5/2018 at 12:40pm ,Birthday Party, This is my birthday party.\n", appt.toString());
	/*assertFalse(appt.getValid());
	assertEquals(23, appt.getStartHour());
	assertEquals(59, appt.getStartMinute());
	assertEquals(28, appt.getStartDay());
	assertEquals(11, appt.getStartMonth());
	assertEquals(2018, appt.getStartYear());
	assertEquals("Birthday Party", appt.getTitle());
	assertEquals("This is my birthday party.", appt.getDescription());
	assertEquals(2, appt.getRecurBy());
	assertEquals(0, appt.getRecurNumber());
	assertEquals(0, appt.getRecurIncrement());
	//int[] recurringDays = new int[0];
	//assertEquals(recurDays, appt.getRecurDays());
	assertFalse(appt.isRecurring());
	assertEquals(null, appt.toString());*/
}

}
