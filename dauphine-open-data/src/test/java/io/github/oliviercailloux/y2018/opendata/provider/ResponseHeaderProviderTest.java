package io.github.oliviercailloux.y2018.opendata.provider;

import static org.mockito.BDDMockito.then;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ResponseHeaderProviderTest {

	@Mock
	private HttpServletResponse response;

	@Mock
	private ContainerRequestContext requestContext;

	@Mock
	private ContainerResponseContext responseContext;

	@InjectMocks
	private final ResponseHeaderProvider provider = new ResponseHeaderProvider();

	@Test
	public void test() {
		provider.filter(requestContext, responseContext);
		Mockito.verifyZeroInteractions(requestContext, responseContext);
		then(response).should(Mockito.atLeastOnce()).setLocale(Locale.ENGLISH);
		then(response).should(Mockito.atLeastOnce()).setCharacterEncoding(StandardCharsets.UTF_8.name());
	}

}
