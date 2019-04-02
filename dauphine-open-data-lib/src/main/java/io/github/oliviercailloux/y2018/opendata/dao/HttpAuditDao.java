package io.github.oliviercailloux.y2018.opendata.dao;

import javax.enterprise.context.RequestScoped;

import io.github.oliviercailloux.y2018.opendata.entity.HttpAudit;

@RequestScoped
public class HttpAuditDao extends AbstractDao<HttpAudit> {

	public HttpAuditDao() {
		super("HttpAudit", HttpAudit.class);
	}

}