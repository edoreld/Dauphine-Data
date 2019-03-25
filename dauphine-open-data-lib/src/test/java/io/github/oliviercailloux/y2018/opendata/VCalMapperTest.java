package io.github.oliviercailloux.y2018.opendata;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import biweekly.ICalendar;
import biweekly.component.VEvent;
import biweekly.io.text.ICalReader;
import io.github.oliviercailloux.y2018.opendata.entity.Course;
import io.github.oliviercailloux.y2018.opendata.entity.Lecture;
import io.github.oliviercailloux.y2018.opendata.entity.Person;
import io.github.oliviercailloux.y2018.opendata.entity.Planning;
import io.github.oliviercailloux.y2018.opendata.mapper.VCalMapper;

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
		Person olivier = new Person();
		Course course = new Course();
		course.setCourseDescription("test");
		course.setCourseName("Programmation en Java");
		Lecture lecture1 = new Lecture(course, Instant.now(), 0, null, null, olivier);
		Lecture lecture2 = new Lecture(course, Instant.now(), 0, null, null, olivier);
		List<Lecture> lectures = new ArrayList<>();
		lectures.add(lecture1);
		lectures.add(lecture2);
		Planning planning = new Planning("planning", new Person(), lectures);

		VCalMapper iCalendarMapper = new VCalMapper();
		ICalendar ical = iCalendarMapper.encodePlanningToICalendar(planning);
		/**
		 * write ICalendar to file
		 */
//		ical.write(new File("./src/test/resources/example.ics"));

		/**
		 * Read the expected file and get the summary
		 */
		File file = new File("./src/test/resources/example.ics");
		ICalReader reader = null;
		VEvent event;
		try {
			reader = new ICalReader(file);
			ICalendar ical2;
			ical2 = reader.readNext();
			event = ical2.getEvents().get(0);

			String summaryEventWritten = ical.getEvents().get(0).getSummary().getValue();
			String summaryEventFile = event.getSummary().getValue();

			assertEquals(summaryEventWritten, summaryEventFile);

		} finally {
			if (reader != null)
				reader.close();
		}

	}
}
