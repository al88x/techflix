package uk.co.techswitch.cache;

import uk.co.techswitch.models.FilmDetailsModel;

public class LocalCache {

    private FilmDetailsModel film;
    private Long timestamp;


    public LocalCache(FilmDetailsModel film, Long timestamp) {
        this.film = film;
        this.timestamp = timestamp;
    }


    public FilmDetailsModel getFilm() {
        return film;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
