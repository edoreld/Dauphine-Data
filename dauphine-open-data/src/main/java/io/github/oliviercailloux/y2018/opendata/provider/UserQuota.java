package io.github.oliviercailloux.y2018.opendata.provider;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor(staticName = "make")
@ToString(exclude = { "monitor" })
public class UserQuota {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserQuota.class);

	@NonNull
	private final String user;
	
	private final long rate;
	
	private final long limit;
	
	@Getter(value = AccessLevel.NONE)
	private final ConcurrentHashMap<String, AtomicInteger> monitor = new ConcurrentHashMap<>();
	
	public void clearPath(String path) {
		LOGGER.info("clearing quota of route [{}] for user [{}]", path, user);
		monitor.remove(path);
	}
	
	public void clearAll() {
		LOGGER.info("clearing quota of all routes for user [{}]", user);
		monitor.clear();
	}
	
	public boolean visit(String path) {
		final AtomicInteger currentCount = monitor.computeIfAbsent(path, s -> new AtomicInteger(0));
		if(currentCount.intValue() >= limit) {
			LOGGER.info("user [{}] has execeed the limit [{}] for path [{}]", user, limit, path);
			return false;
		}
		currentCount.incrementAndGet();
		return true;
	}
}
