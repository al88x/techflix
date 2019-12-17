package uk.co.techswitch.services;

import uk.co.techswitch.domain.FilmDetails;
import uk.co.techswitch.domain.ReviewDetails;
import uk.co.techswitch.models.FilmDetailsModel;
import uk.co.techswitch.models.FilmModel;
import uk.co.techswitch.repos.LibraryApiClient;

import java.util.List;
import java.util.stream.Collectors;

public class FilmsService {
    private static final int FILMS_PER_PAGE = 20;

    private final LibraryApiClient libraryApiClient;

    public FilmsService(LibraryApiClient libraryApiClient) {
        this.libraryApiClient = libraryApiClient;
    }

    public List<FilmModel> getFilms(int page) {
        int offset = FILMS_PER_PAGE * (page - 1);
        return libraryApiClient
                .getAllFilms(FILMS_PER_PAGE, offset)
                .stream()
                .map(FilmModel::new)
                .collect(Collectors.toList());
    }

    public FilmDetailsModel getFilm(String id) {
        FilmDetails film = libraryApiClient.getFilm(id);
        ReviewDetails reviews = libraryApiClient.getReviews(film.getTMDbId().toString());
        return new FilmDetailsModel(film, reviews);
    }
}
