package io.github.oliviercailloux.y2018.opendata.provider;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(exclude = { "monitor" })
public class UserQuota {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserQuota.class);

	private final String user;
	
	private final long rate;
	
	private final long limit;
	
	@Getter(value = AccessLevel.NONE)
	private final Cache<String, AtomicInteger> monitor;
	
	public UserQuota(String user, long rate, long limit) {
		this.user = checkNotNull(user);
		this.rate = rate;
		this.limit = limit;
		monitor = CacheBuilder
			.newBuilder()
			.expireAfterAccess(rate, TimeUnit.SECONDS)
			.build();
	}
	
	public boolean visit(String path) {
		try {
			final AtomicInteger currentCount = monitor.get(path, () -> new AtomicInteger(0));
			if(currentCount.intValue() >= limit) {
				LOGGER.info("user [{}] has execeed the limit [{}] for path [{}]", user, limit, path);
				return false;
			}
			currentCount.incrementAndGet();
			return true;
		} catch (ExecutionException e) {
			LOGGER.error("an error occured while querying the cache", e);
			return false;
		}
	}
}
