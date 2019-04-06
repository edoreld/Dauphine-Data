package io.github.oliviercailloux.y2018.opendata.dao;

import java.util.Collections;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import io.github.oliviercailloux.y2018.opendata.entity.Lecture;

@RequestScoped
public class LectureDao extends AbstractDao<Lecture> {

	public LectureDao() {
		super("Lecture", Lecture.class);
	}
	public List<Lecture> findByCriteria(String llName, String lfName, String gName, String lcroom, String lcName) {

		if (llName.isEmpty() && lfName.isEmpty() && gName.isEmpty() && lcroom.isEmpty() && lcName.isEmpty()) {

			return Collections.<Lecture>emptyList();
		}
		CriteriaBuilder criteriabuilder = em.getCriteriaBuilder();
		CriteriaQuery<Lecture> querybuild = criteriabuilder.createQuery(Lecture.class);
		Root<Lecture> root = querybuild.from(Lecture.class);

		if (!lfName.isEmpty()) {
			querybuild.where(criteriabuilder.like(root.get("teacher").get("firstName"), "%" + lfName + "%"));
		}
		if (!llName.isEmpty()) {
			querybuild.where(criteriabuilder.like(root.get("teacher").get("lastName"), "%" + llName + "%"));
		}
		if (!lcroom.isEmpty()) {
			querybuild.where(criteriabuilder.like(root.get("room"), "%" + lcroom + "%"));
		}

		if (!!gName.isEmpty()) {
			querybuild.where(criteriabuilder.like(root.get("groupName"), "%" + gName + "%"));

		}
		if (!lcName.isEmpty()) {
			querybuild.where(criteriabuilder.like(root.get("course").get("name"), "%" + lcName + "%"));
		}
		TypedQuery<Lecture> queryTyped = em.createQuery(querybuild);
		return queryTyped.getResultList();

	}
	 
}