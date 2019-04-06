package io.github.oliviercailloux.y2018.opendata.mapper;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import biweekly.ICalendar;
import biweekly.component.VEvent;
import biweekly.io.text.ICalReader;
import io.github.oliviercailloux.y2018.opendata.entity.Course;
import io.github.oliviercailloux.y2018.opendata.entity.Lecture;
import io.github.oliviercailloux.y2018.opendata.entity.Person;
import io.github.oliviercailloux.y2018.opendata.entity.Planning;

public class VCalMapperTest {

	/**
	 * Creates a planning with a few lectures. Then, maps the planning to an
	 * ICalendar object. Finally, it tests that the description of the first event
	 * of the ICalendar object matches the description of the first event of a
	 * pre-created file that corresponds to the ICalendar object being created.
	 *
	 * @throws IOException
	 */
	@Test
	public void testEncodePlanningToICalendar() throws IOException {
		Person olivier = new Person("test-firstname", "test-lastname", true);
		Course course = new Course();
		course.setCourseDescription("test");
		course.setCourseName("Programmation en Java");
		Lecture lecture1 = new Lecture(course, new Date(), 30, "group1");
		lecture1.setTeacher(olivier);
		Lecture lecture2 = new Lecture(course, new Date(), 30, "group2");
		lecture2.setTeacher(olivier);
		List<Lecture> lectures = new ArrayList<>();
		lectures.add(lecture1);
		lectures.add(lecture2);
		Planning planning = new Planning("planning");
		planning.setLectures(lectures);

		VCalMapper iCalendarMapper = new VCalMapper();
		ICalendar ical = iCalendarMapper.encodePlanningToICalendar(planning);
		
		File file = Files.createTempFile(null, null).toFile();
		
		/**
		 * write ICalendar to file
		 */
		ical.write(file);

		/**
		 * Read the expected file and get the summary
		 */

		try (ICalReader reader = new ICalReader(file)) {

			ICalendar ical2;
			ical2 = reader.readNext();
			VEvent event = ical2.getEvents().get(0);

			String summaryEventWritten = ical.getEvents().get(0).getSummary().getValue();
			String summaryEventFile = event.getSummary().getValue();

			assertEquals(summaryEventWritten, summaryEventFile);

		}
	}
}
