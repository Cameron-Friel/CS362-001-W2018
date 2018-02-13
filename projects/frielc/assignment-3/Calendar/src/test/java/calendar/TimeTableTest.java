package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
			TimeTable timeTable=new TimeTable();

			LinkedList<Appt> listAppts = new LinkedList<Appt>();

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

			//listAppts.add(0, appt);

			GregorianCalendar today = new GregorianCalendar(startYear,startMonth,startDay);
			GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
			tomorrow.add(Calendar.DAY_OF_MONTH,1);

			LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 	LinkedList<CalDay> calDays1 = new LinkedList<CalDay>();

			calDays = new LinkedList<CalDay>();
			calDays1 = null;

			calDays = timeTable.getApptRange(listAppts, today, tomorrow);
			calDays1 = timeTable.getApptRange(listAppts, today, tomorrow);

			//assertEquals(calDays, timeTable.getApptRange(listAppts, today, tomorrow));
	 }
	 @Test
	  public void test02()  throws Throwable  {
				TimeTable timeTable=new TimeTable();

				LinkedList<Appt> listAppts = new LinkedList<Appt>();

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

				listAppts.add(0, appt);

				GregorianCalendar today = new GregorianCalendar(startYear,startMonth,startDay);
				GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
				tomorrow.add(Calendar.DAY_OF_MONTH,1);

				LinkedList<CalDay> calDays = new LinkedList<CalDay>();

				calDays = timeTable.getApptRange(listAppts, today, tomorrow);

				//assertEquals(calDays, timeTable.getApptRange(listAppts, today, tomorrow));
	 }
//add more unit tests as you needed
@Test
 public void test03()  throws Throwable  {
		 TimeTable timeTable=new TimeTable();

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
	     LinkedList<Appt> listApptsEmpty = new LinkedList<Appt>();

	     listApptsEmpty = null;

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

		 listAppts.add(appt);
		 listAppts.add(appt2);

		 GregorianCalendar today = new GregorianCalendar(startYear,startMonth,startDay);
		 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		 tomorrow.add(Calendar.DAY_OF_MONTH,1);

		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();

		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);

		 //assertEquals(calDays, timeTable.getApptRange(listAppts, today, tomorrow));

		 assertEquals(null, timeTable.deleteAppt(listAppts, appt));

		 appt = null;

		 assertEquals(null, timeTable.deleteAppt(listApptsEmpty, appt));
	 }

	 @Test
	  public void test04()  throws Throwable  {
	 		 TimeTable timeTable=new TimeTable();

	 		 LinkedList<Appt> listAppts = new LinkedList<Appt>();

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

	 		 listAppts.add(appt);
	 		 listAppts.add(appt2);

	 		 GregorianCalendar today = new GregorianCalendar(startYear,startMonth,startDay);
	 		 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
	 		 tomorrow.add(Calendar.DAY_OF_MONTH,1);

	 		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();

	 		 calDays = timeTable.getApptRange(listAppts, today, tomorrow);

	 		 //assertEquals(calDays, timeTable.getApptRange(listAppts, today, tomorrow));

	 		 assertEquals(null, timeTable.deleteAppt(listAppts, null));

			 //assertEquals(today, getNextApptOccurence(appt, today)); can't call private methods from within test class
	 	 }

		 @Test
			public void test05()  throws Throwable  {
				 TimeTable timeTable=new TimeTable();

				 LinkedList<Appt> listAppts = new LinkedList<Appt>();

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

								 startHour = 30;
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

				 listAppts.add(appt);
				 listAppts.add(appt2);

				 GregorianCalendar today = new GregorianCalendar(startYear,startMonth,startDay);
				 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
				 tomorrow.add(Calendar.DAY_OF_MONTH,1);

				 LinkedList<CalDay> calDays = new LinkedList<CalDay>();

				 calDays = timeTable.getApptRange(listAppts, today, tomorrow);

				 //assertEquals(calDays, timeTable.getApptRange(listAppts, today, tomorrow));

				 assertEquals(null, timeTable.deleteAppt(listAppts, appt2));
			 }

			 @Test
				public void test06()  throws Throwable  {
					 TimeTable timeTable=new TimeTable();

					 LinkedList<Appt> listAppts = new LinkedList<Appt>();

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

									 startHour = 10;
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

														startHour = 10;
										 			 startMinute = 24;
										 			 startDay = 10;
										 			 startMonth = 02;
										 			 startYear = 2019;
										 			 title = "Meeting";
										 			 description = "Company meeting.";

										 			 Appt appt3 = new Appt(startHour,
										 								 startMinute ,
										 								 startDay ,
										 								 startMonth ,
										 								 startYear ,
										 								 title,
										 								description);
																		startHour = 10;
														 			 startMinute = 24;
														 			 startDay = 10;
														 			 startMonth = 02;
														 			 startYear = 2019;
														 			 title = "Meeting";
														 			 description = "Company meeting.";

														 			 Appt appt4 = new Appt(startHour,
														 								 startMinute ,
														 								 startDay ,
														 								 startMonth ,
														 								 startYear ,
														 								 title,
														 								description);

					 listAppts.add(appt);
					 listAppts.add(appt2);
					 listAppts.add(appt3);
					 listAppts.add(appt4);

					 GregorianCalendar today = new GregorianCalendar(startYear,startMonth,startDay);
					 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
					 tomorrow.add(Calendar.DAY_OF_MONTH,1);

					 LinkedList<CalDay> calDays = new LinkedList<CalDay>();

					 calDays = timeTable.getApptRange(listAppts, today, tomorrow);

					 //assertEquals(calDays, timeTable.getApptRange(listAppts, today, tomorrow));

					 LinkedList<Appt> test = new LinkedList<Appt>();

					 test = timeTable.deleteAppt(listAppts, appt2);

					 //assertEquals(test, timeTable.deleteAppt(listAppts, appt2));
				 }

				 @Test
					public void test07()  throws Throwable  {
						 TimeTable timeTable=new TimeTable();

						 LinkedList<Appt> listAppts = new LinkedList<Appt>();

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

										 startHour = 10;
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

															startHour = 10;
														 startMinute = 24;
														 startDay = 10;
														 startMonth = 02;
														 startYear = 2019;
														 title = "Meeting";
														 description = "Company meeting.";

														 Appt appt3 = new Appt(startHour,
																			 startMinute ,
																			 startDay ,
																			 startMonth ,
																			 startYear ,
																			 title,
																			description);
																			startHour = 10;
																		 startMinute = 24;
																		 startDay = 10;
																		 startMonth = 02;
																		 startYear = 2019;
																		 title = "Meeting";
																		 description = "Company meeting.";

																		 Appt appt4 = new Appt(startHour,
																							 startMinute ,
																							 startDay ,
																							 startMonth ,
																							 startYear ,
																							 title,
																							description);

						 listAppts.add(appt);
						 listAppts.add(appt2);
						 listAppts.add(appt3);
						 listAppts.add(appt4);

						 GregorianCalendar today = new GregorianCalendar(startYear,startMonth,startDay);
						 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
						 tomorrow.add(Calendar.DAY_OF_MONTH,1);

						 LinkedList<CalDay> calDays = new LinkedList<CalDay>();

						 calDays = timeTable.getApptRange(listAppts, today, tomorrow);

						 //assertEquals(calDays, timeTable.getApptRange(listAppts, today, tomorrow));

						 LinkedList<Appt> test = new LinkedList<Appt>();

						 test = timeTable.deleteAppt(listAppts, appt2);

						 //assertEquals(test, timeTable.deleteAppt(listAppts, appt2));

						 int[] intList = new int[listAppts.size()];

						 test = timeTable.permute(listAppts, intList);

						 assertEquals(test, timeTable.permute(listAppts, intList));
					 }
}
