package uk.co.techswitch.models;

import uk.co.techswitch.domain.Film;


public class FilmModel {
    private Film film;

    public FilmModel(Film film) {
        this.film = film;
    }

    public String getId() {
        return film.getId();
    }

    public String getTitle() {
        return film.getTitle();
    }

    public String getSummary() {
        return film.getSummary();
    }

    public String getReleaseDate() {
        return film.getReleaseDate();
    }

    public String getBannerImage() {
        return film.getBannerImage();
    }

    public String getPosterImage() {
        return film.getPosterImage();
    }

    public String getVideo() {
        return film.getVideo();
    }

    public String getImdbLink() {
        return film.getImdbLink();
    }


}
