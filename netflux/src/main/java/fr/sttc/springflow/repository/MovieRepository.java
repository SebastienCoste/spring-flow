package fr.sttc.springflow.repository;

import fr.sttc.springflow.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String>{


}
