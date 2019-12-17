package uk.co.techswitch.cache;

import uk.co.techswitch.models.FilmDetailsModel;

import java.time.Clock;
import java.util.LinkedHashMap;
import java.util.Map;

import static uk.co.techswitch.cache.CacheState.*;
import static uk.co.techswitch.cache.CacheState.FRESH;
import static uk.co.techswitch.cache.CacheState.STALE;

public class InMemoryCache extends LinkedHashMap<String, LocalCache> {

    private static final int FIVE_MIN = 300_000;
    private static final int ONE_HOUR = 3_600_000;
    private LinkedHashMap<String, LocalCache> cachingList;

    public InMemoryCache() {
        cachingList = new LinkedHashMap<>();
    }

    public FilmDetailsModel getById(String id) {
        LocalCache cachedFilm = cachingList.get(id);
        if(cachedFilm != null && getState(cachedFilm) == FRESH){
            return cachedFilm.getFilm();
        }
        return null;
    }

    private CacheState getState(LocalCache cachedFilm) {
        long now = Clock.systemDefaultZone().millis();
        if(now - cachedFilm.getTimestamp() < FIVE_MIN){
            return FRESH;
        }
        if(now - cachedFilm.getTimestamp() < ONE_HOUR){
            return STALE;
        }
        return EXPIRED;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, LocalCache> eldest) {

        if(getState(eldest.getValue()) != FRESH){
            cachingList.remove(eldest);
            return true;
        }
        return false;
    }

    public void addFilmToBeCached(String id, FilmDetailsModel film) {
        cachingList.put(id, new LocalCache(film, Clock.systemDefaultZone().millis()));
    }
}
