package io.github.oliviercailloux.y2018.opendata;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import biweekly.ICalendar;
import io.github.oliviercailloux.y2018.opendata.entity.Course;
import io.github.oliviercailloux.y2018.opendata.entity.Lecture;
import io.github.oliviercailloux.y2018.opendata.entity.Person;
import io.github.oliviercailloux.y2018.opendata.entity.Planning;
import io.github.oliviercailloux.y2018.opendata.mapper.VCalMapper;

public class VCalMapperTest {

	@Test
	public void testEncodePlanningToICalendar() {
		Person olivier = new Person();
		Course course = new Course();
		course.setCourseDescription("test");
		Lecture lecture1 = new Lecture(course, Instant.now(), 0, null, null, olivier);
		Lecture lecture2 = new Lecture(course, Instant.now(), 0, null, null, olivier);
		List<Lecture> lectures = new ArrayList<>();
		lectures.add(lecture1);
		lectures.add(lecture2);
		Planning planning = new Planning("planning", new Person(), lectures);

		VCalMapper iCalendarMapper = new VCalMapper();

		ICalendar ical = iCalendarMapper.encodePlanningToICalendar(planning);

		assertEquals("test", ical.getEvents().get(0).getDescription().getValue());

	}
}
