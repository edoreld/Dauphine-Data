package io.github.oliviercailloux.y2018.opendata.mapper;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

import biweekly.ICalendar;
import biweekly.component.VEvent;
import io.github.oliviercailloux.y2018.opendata.entity.Lecture;
import io.github.oliviercailloux.y2018.opendata.entity.Planning;

/**
 * Class used to convert Planning entities to ICalendar objects
 *
 * @author Javier Martínez
 *
 */
@ApplicationScoped
public class VCalMapper {

	/**
	 * Maps a {@link Planning} entity into an {@link ICalendar} Object
	 */
	public VCalMapper() {
	}

	public ICalendar encodePlanningToICalendar(Planning planning) {

		ICalendar ical = new ICalendar();

		planning.getLectures().forEach((lecture) -> {
			ical.addEvent(this.transformLectureToEvent(lecture));
		});

		return ical;
	}

	/**
	 * Convert a {@link Lecture} entity into a {@link VEvent} object
	 *
	 * @param lecture the lecture entity to encode, cannot be null
	 * @return the lecture encoded as an Event entity
	 */
	public VEvent transformLectureToEvent(Lecture lecture) {
		VEvent event = new VEvent();
		Date start = Date.from(lecture.getDate());
		event.setDateStart(start);
		event.setLocation(lecture.getRoom());
		event.setDescription(lecture.getCourse().getCourseDescription());
		return event;
	}

}
