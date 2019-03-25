package io.github.oliviercailloux.y2018.opendata.mapper;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

import org.apache.commons.lang.time.DateUtils;

import biweekly.ICalendar;
import biweekly.component.VEvent;
import biweekly.property.Organizer;
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
		Date end = DateUtils.addMinutes(start, lecture.getDuration());
		event.setDateStart(start);
		event.setDateEnd(end);
		event.setLocation(lecture.getRoom());
		event.setOrganizer(getOrganizerFromLecture(lecture));

		event.setDescription(lecture.getCourse().getCourseDescription());
		return event;
	}

	private Organizer getOrganizerFromLecture(Lecture lecture) {
		String organizerName = lecture.getTeacher().getFirstName();
		String organizerEmail = lecture.getTeacher().getDauphineMail().get(0);
		return new Organizer(organizerName, organizerEmail);
	}

}
