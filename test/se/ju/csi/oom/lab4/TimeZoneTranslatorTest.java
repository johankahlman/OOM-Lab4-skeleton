package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDateTime() {
		
		DateTime dateTime = new DateTime(2000, 1, 1, 0, 0);
		DateTime dateTimeString = new DateTime(dateTime.toString());		
		assertEquals(dateTime.toString(), dateTimeString.toString());

		DateTime dateTime2 = new DateTime(999, 10, 10, 0, 0);
		DateTime dateTimeString2 = new DateTime(dateTime2.toString());		
		assertEquals(dateTime2.toString(), dateTimeString2.toString());
		
		DateTime dateTime3 = new DateTime(99, 1, 21, 0, 0);
		DateTime dateTimeString3 = new DateTime(dateTime3.toString());		
		assertEquals(dateTime3.toString(), dateTimeString3.toString());
		
		DateTime dateTime4 = new DateTime(9, 11, 1, 0, 0);
		DateTime dateTimeString4 = new DateTime(dateTime4.toString());		
		assertEquals(dateTime4.toString(), dateTimeString4.toString());
		
	}

	
	
	@Test
	public void testShiftTimeZone() {
		//fail("Not yet implemented");
		DateTime dateTime = new DateTime(2018, 8, 27, 8, 0);
				
		assertEquals(TimeZoneTranslator.shiftTimeZone(dateTime, 1, -5).toString(), "2018-08-27 02:00");
		
		DateTime dateTime2 = new DateTime(2016, 1, 1, 6, 0);
		
		assertEquals(TimeZoneTranslator.shiftTimeZone(dateTime2, 1, -8).toString(), "2015-12-31 21:00");
				
	}
	

	@Test
	public void testShiftEventTimeZone() {
		
		DateTime LectureStart = new DateTime(2018, 8, 27, 8, 0);
		DateTime LectureEnd = new DateTime(2018, 8, 27, 9, 45);
		Person johannes = new Person("Johannes Schmidt");
		Person ragnar = new Person("Ragnar Nohre");
		Place HC218 = new Place("Hc218",57.7785672,14.1614833,20.0);
		
		Event firstOomLecture = new Event("OOM 2018 Lecture 1",
				LectureStart,
				LectureEnd,
				new HashSet<>(Arrays.asList(johannes, ragnar)),
				HC218);
				
		assertEquals(TimeZoneTranslator.shiftEventTimeZone(firstOomLecture, TimeZone.CENTRAL_EUROPEAN_TIME, TimeZone.US_EASTERN).toString(),
				  "Event label:\tOOM 2018 Lecture 1\nStart date:\t2018-08-27 02:00:00\nEnd date:\t2018-08-27 03:45:00\nAttendees:"
							+ "\t[Johannes Schmidt, Ragnar Nohre]\nPlace:\t\tHc218"
	);
	
		/*
		  "Event label:\tOOM 2018 Lecture 1\nStart date:\t2018-08-27 02:00:00\nEnd date:\t2018-08-27 03:45:00\nAttendees:"
	+ "\t[Johannes Schmidt, Ragnar Nohre]\nPlace:\t\tHc218"
		 * 
		 * */	
	}

}
