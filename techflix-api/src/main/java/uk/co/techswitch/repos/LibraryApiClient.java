package uk.co.techswitch.repos;

import uk.co.techswitch.domain.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class LibraryApiClient {
    private final Client client;

    public LibraryApiClient(Client client) {
        this.client = client;
    }

    public List<Film> getAllFilms(int limit, int offset) {
        return client
                .target("http://localhost:8000/films")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<>() {
                });
    }

    public List<Person> getAllPeople(int limit, int offset) {
        return client
                .target("http://localhost:8000/people")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<>() {
                });
    }

    public FilmDetails getFilm(String id) {
        return client
                .target("http://localhost:8000/films/" + id)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(FilmDetails.class);

    }

    public PersonDetails getPerson(String id) {
        return client
                .target("http://localhost:8000/people/" + id)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(PersonDetails.class);
    }

    public ReviewDetails getReviews(String id) {
        return client
                .target("http://localhost:3000/reviews/" + id)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(ReviewDetails.class);
    }


}
