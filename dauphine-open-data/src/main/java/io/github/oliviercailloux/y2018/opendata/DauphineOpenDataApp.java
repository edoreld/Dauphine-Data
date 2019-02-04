package io.github.oliviercailloux.y2018.opendata;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.google.common.collect.ImmutableSet;

import io.github.oliviercailloux.y2018.opendata.provider.ResponseHeaderProvider;

/**
 * Defines the base path, resource classes and providers for JAX-RS.
 *
 * @author Dauphine - CLAUDEL Arnaud
 *
 */
@ApplicationPath("resource")
public class DauphineOpenDataApp extends Application {

	final ImmutableSet<Class<?>> classes = ImmutableSet.of(ResponseHeaderProvider.class);

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

}
