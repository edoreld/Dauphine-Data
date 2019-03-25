package io.github.oliviercailloux.y2018.opendata.mapper;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

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
		Instant startInstant = start.toInstant();
		Instant endInstant = startInstant.plus(Duration.ofMinutes(lecture.getDuration()));
		Date end = Date.from(endInstant);
		event.setDateStart(start);
		event.setDateEnd(end);
		if (!lecture.getRoom().isEmpty())
			event.setLocation(lecture.getRoom());
		event.setOrganizer(getOrganizerFromLecture(lecture));
		event.setDescription(lecture.getCourse().getCourseDescription());
		event.setSummary(lecture.getCourse().getCourseName());
		return event;
	}

	/**
	 * Creates an {@link Organizer} object from a {@link Lecture} object. If the
	 * lecture's teacher has several emails, only the first one is used.
	 *
	 * @param lecture
	 * @return the lecture's organizer
	 */
	private Organizer getOrganizerFromLecture(Lecture lecture) {
		String organizerName = lecture.getTeacher().getFirstName();
		String organizerEmail = new String();
		if (lecture.getTeacher().getDauphineMail().size() > 0)
			organizerEmail = lecture.getTeacher().getDauphineMail().get(0);
		else
			organizerEmail = "";

		return new Organizer(organizerName, organizerEmail);
	}

}
