package io.github.oliviercailloux.y2018.opendata.entity;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class EntityIT {

	@Deployment
	public static WebArchive makeWar() {
		return ShrinkWrap.create(WebArchive.class)
				.addPackages(true, "io.github.oliviercailloux.y2018.opendata.entity")
				.addAsResource("META-INF/persistence.xml")
				.addAsResource("arquillian.xml");
	}
	
	@Test
	public void validateJPA() {
		// if the method is invoked, then the deployment (and JPA validation) is successful
	}
	
}
