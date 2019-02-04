package io.github.oliviercailloux.y2018.opendata;

import java.io.File;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public class TestUtils {

	public static WebArchive makeWar() {
		final File[] libs = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeAndTestDependencies().resolve()
				.withTransitivity().asFile();

		final JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
				.addPackages(true, "io.github.oliviercailloux.y2018.opendata").addAsResource("arquillian.xml")
				.addAsResource("META-INF/persistence.xml");

		final WebArchive war = ShrinkWrap.create(WebArchive.class).addAsLibraries(libs).addAsLibrary(jar);

		return war;
	}

}
