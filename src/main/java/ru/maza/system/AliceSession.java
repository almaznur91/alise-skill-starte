package ru.maza.system;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.Factory;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.ExpiryPolicy;
import javax.cache.expiry.ModifiedExpiryPolicy;


@Scope("singleton")
@Component
public class AliceSession {

    private Cache<String, State> cache;

    @PostConstruct
    public void setup() {
        CacheManager cacheManager = Caching.getCachingProvider().getCacheManager();
        MutableConfiguration<String, State> conf = new MutableConfiguration<>();
        Factory<ExpiryPolicy> oneMinuteExpired = ModifiedExpiryPolicy.factoryOf(Duration.ONE_MINUTE);
        conf.setExpiryPolicyFactory(oneMinuteExpired);
        cache = cacheManager.createCache("alice-session", conf);
    }

    public State get(String sid) {
        return cache.get(sid);
    }

    public void save(String sid, State state) {
        cache.put(sid, state);
    }
}
