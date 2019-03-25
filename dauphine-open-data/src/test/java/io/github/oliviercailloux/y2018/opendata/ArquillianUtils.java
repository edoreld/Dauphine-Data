package io.github.oliviercailloux.y2018.opendata;

import java.io.File;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public class ArquillianUtils {

	public static String makeWarName(final String warName) {
		return warName + ".war";
	}

	public static WebArchive makeWar(final String warName) {
		final File[] libs = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeAndTestDependencies().resolve()
				.withTransitivity().asFile();

		final JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
				.addPackages(true, "io.github.oliviercailloux.y2018.opendata.resource")
				.addPackages(true, "io.github.oliviercailloux.y2018.opendata.provider")
				.addClass(DauphineOpenDataApp.class).addAsResource("arquillian.xml");

		final WebArchive war = ShrinkWrap.create(WebArchive.class, makeWarName(warName)).addAsLibraries(libs)
				.addAsLibrary(jar);

		return war;
	}

}
