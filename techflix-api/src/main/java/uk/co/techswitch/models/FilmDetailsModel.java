package uk.co.techswitch.models;

import uk.co.techswitch.domain.FilmDetails;
import uk.co.techswitch.domain.ReviewComment;
import uk.co.techswitch.domain.ReviewDetails;

import java.util.List;
import java.util.stream.Collectors;

public class FilmDetailsModel extends FilmModel {
    private final List<PersonModel> cast;
    private final ReviewDetails reviews;

    public FilmDetailsModel(FilmDetails film, ReviewDetails reviews) {
        super(film);
        cast = film.getCast().stream().map(PersonModel::new).collect(Collectors.toList());
        this.reviews = reviews;
    }

    public List<PersonModel> getCast() {
        return cast;
    }

    public ReviewDetails getReviews() {
        return reviews;
    }
}
