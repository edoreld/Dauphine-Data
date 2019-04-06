package io.github.oliviercailloux.y2018.opendata.resource;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.oliviercailloux.y2018.opendata.dao.LectureDao;
import io.github.oliviercailloux.y2018.opendata.entity.Lecture;

/**
 * @author Gandi Taric <br>
 *         <br>
 * 
 *         This class provide additional methods to search a list of Lecture
 *         according to some criteria <br>
 *         fields course, person as teacher and groupName and room are fields most pertinent
 *         considered for requests
 */
@Path("lecture")
public class LectureResource extends AbstractResource<Lecture, LectureDao> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractResource.class);

	public LectureResource() {
		super("Lecture", "lecture");
	}

	/**
	 * @param llName is {@link Lecture#teacher.lastName}
	 * @param lfName is {@link Lecture#teacher.firstName}
	 * @param gName  is {@link Lecture#groupName}
	 * @param lcroom is {@link Lecture#room}
	 * @param lcName is {@link Lecture#course.courseName}
	 * @return list of lecture according to criteria set.
	 */
	@GET
	@Path("lecturefilter")
	public Response filterby(@DefaultValue("") @QueryParam("llName") String llName, @DefaultValue("") @QueryParam("lfName") String lfName ,
			@DefaultValue("") @QueryParam("gName") String gName,@DefaultValue("") @QueryParam("lcroom") String lcroom,
			@DefaultValue("") @QueryParam("lcName") String lcName) {

		LOGGER.info("[{}] - finding entities by Enseignant nom [{}],Enseignant prenom [{}] and groupe [{}] ..", resourceName, llName,
				lfName, gName);
		List<Lecture> lectures = dao.findByCriteria(llName,  lfName,  gName, lcroom, lcName);
		return Response.ok(lectures).build();

	}
}
