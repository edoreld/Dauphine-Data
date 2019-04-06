package io.github.oliviercailloux.y2018.opendata.provider;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserQuotaTest {
	
	private static final String USER = "aclaudel";
	private static final String PATH = "/test";
	private static final String PATH_1 = "/test/1";
	private static final String PATH_2 = "/test/2";
	
	@Test
	public void testLimit0() {
		final UserQuota userquota = UserQuota.make(USER, 1, 0);
		assertFalse("quota not exceeded", userquota.visit(PATH));
	}
	
	@Test
	public void testLimit1SamePath() {
		final UserQuota userquota = UserQuota.make(USER, 1, 1);
		assertTrue("quota exceeded", userquota.visit(PATH));
		assertFalse("quota not exceeded", userquota.visit(PATH));
	}
	
	@Test
	public void testLimit1DifferentPath() {
		final UserQuota userquota = UserQuota.make(USER, 1, 1);
		assertTrue("quota exceeded", userquota.visit(PATH_1));
		assertTrue("quota exceeded", userquota.visit(PATH_2));
		assertFalse("quota not exceeded", userquota.visit(PATH_1));
		assertFalse("quota not exceeded", userquota.visit(PATH_2));
	}
	
}
