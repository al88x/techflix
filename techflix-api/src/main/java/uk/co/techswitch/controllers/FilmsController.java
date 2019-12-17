package uk.co.techswitch.controllers;

import uk.co.techswitch.cache.InMemoryCache;
import uk.co.techswitch.models.FilmDetailsModel;
import uk.co.techswitch.models.FilmModel;
import uk.co.techswitch.services.FilmsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/films")
@Produces(MediaType.APPLICATION_JSON)
public class FilmsController {
    private final FilmsService filmsService;
    private InMemoryCache inMemoryCache;

    public FilmsController(FilmsService filmsService) {
        this.filmsService = filmsService;
        inMemoryCache = new InMemoryCache();
    }

    @GET
    @Path("")
    public List<FilmModel> getFilms(@QueryParam("page") Optional<Integer> page) {
        return filmsService.getFilms(page.orElse(0));
    }

    @GET
    @Path("/{id}")
    public FilmDetailsModel getFilm(@PathParam("id") String id) {
        FilmDetailsModel cachedFilm = inMemoryCache.getById(id);
        if(cachedFilm != null){
            return cachedFilm;
        }
        FilmDetailsModel film = filmsService.getFilm(id);
        inMemoryCache.addFilmToBeCached(id, film);
        return film;
    }
}
