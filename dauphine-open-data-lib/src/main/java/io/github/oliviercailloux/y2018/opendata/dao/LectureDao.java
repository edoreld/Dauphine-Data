package io.github.oliviercailloux.y2018.opendata.dao;

import java.util.Collections;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import io.github.oliviercailloux.y2018.opendata.entity.Lecture;

@Dependent
public class LectureDao extends AbstractDao<Lecture> {

	@PersistenceContext
	protected EntityManager em;
	public LectureDao() {
		super("Lecture", Lecture.class);
	}

	public List<Lecture> findByCriteria(String llName, String lfName, String gName, String lcroom,String lcName) {

		TypedQuery<Lecture> query = null ;
		
		if (llName.isEmpty() && lfName.isEmpty() && gName.isEmpty()&& lcroom.isEmpty() && lcName.isEmpty()) {

			return Collections.<Lecture>emptyList();
		}
		
		if(!llName.isEmpty() && !lfName.isEmpty() && gName.isEmpty()&& lcroom.isEmpty() && lcName.isEmpty()) {
			query = em.createNamedQuery("FindLectureByTeacherName",Lecture.class);
			query.setParameter("llName", llName);
			query.setParameter("lfName", lfName);
		}
		
		if(llName.isEmpty() && lfName.isEmpty() && !gName.isEmpty()&& lcroom.isEmpty() && lcName.isEmpty()) {
			query = em.createNamedQuery("FindLectureByGroupName",Lecture.class);
			query.setParameter("gName", gName);
		}
		
		if(llName.isEmpty() && lfName.isEmpty() && gName.isEmpty()&& !lcroom.isEmpty() && lcName.isEmpty()) {
			query = em.createNamedQuery("FindLectureByCourseRoom",Lecture.class);
			query.setParameter("lcroom", lcroom);
		}
		
		if(llName.isEmpty() && lfName.isEmpty() && gName.isEmpty()&& lcroom.isEmpty() && !lcName.isEmpty()) {
			query = em.createNamedQuery("FindLectureByCourseName",Lecture.class);
			query.setParameter("lcName", lcName);
		}
		List<Lecture> lectures = query.getResultList();                         
        return lectures;
	}
}