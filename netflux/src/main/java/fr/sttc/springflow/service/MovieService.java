package fr.sttc.springflow.service;

import fr.sttc.springflow.domain.Movie;
import fr.sttc.springflow.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    /**
     * All events for a movie
     * @param movieId
     * @return
     */
    Flux<MovieEvent> events(String movieId);

    /**
     * get a movie
     * @param id
     * @return
     */
    Mono<Movie> getMoviebyId(String id);

    /**
     * gotta catch em all
     * @return
     */
    Flux<Movie> getAllMovies();
}
