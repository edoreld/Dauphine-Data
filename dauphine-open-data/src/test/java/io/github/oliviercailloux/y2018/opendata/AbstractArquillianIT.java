package io.github.oliviercailloux.y2018.opendata;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.ws.rs.client.Client;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import com.google.common.base.Preconditions;

import io.github.oliviercailloux.y2018.opendata.DauphineOpenDataApp;

@ArquillianSuiteDeployment
@RunWith(Arquillian.class)
public abstract class AbstractArquillianIT {

	@ArquillianResource
	protected URL url;
	
	protected URI uri;
	
	protected final Client client;
	
	public AbstractArquillianIT(final Client client) {
		this.client = Preconditions.checkNotNull(client);
	}

	public AbstractArquillianIT() {
		this(ResteasyClientBuilder.newClient());
	}
	
	@Deployment
	public static WebArchive makeWar() {
		final File[] libs = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeAndTestDependencies().resolve()
				.withTransitivity().asFile();

		final JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
				.addPackages(true, "io.github.oliviercailloux.y2018.opendata.provider")
				.addPackages(true, "io.github.oliviercailloux.y2018.opendata.resource")
				.addClass(DauphineOpenDataApp.class).addAsResource("arquillian.xml");

		final WebArchive war = ShrinkWrap.create(WebArchive.class, "app.war").addAsLibraries(libs)
				.addAsLibrary(jar);

		return war;
	}
	
	@Before
	public void before() throws URISyntaxException {
		Preconditions.checkNotNull("url", url);
		this.uri = url.toURI();
	}
	
	@After
	public void after() {
		client.close();
	}
	
}
