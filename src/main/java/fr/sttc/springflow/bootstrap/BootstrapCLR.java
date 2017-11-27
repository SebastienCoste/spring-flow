package fr.sttc.springflow.bootstrap;

import fr.sttc.springflow.domain.Movie;
import fr.sttc.springflow.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class BootstrapCLR implements CommandLineRunner{

    private final MovieRepository movieRepository;

    public BootstrapCLR(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        movieRepository.deleteAll()
                .thenMany(
                Flux.just("Silence of the lambdas",
                        "aEon Flux",
                        "Enter the Mono<Void>",
                        "The fluxinator",
                        "Back to the Future Compleatable",
                        "Meet the fluxes", "Lord of the fluxes")
                        .map(t -> new Movie(t))
                        .flatMap(movieRepository::save)

        ).subscribe(null,
                null,
                () -> movieRepository.findAll().subscribe(System.out::println))  ;


    }
}
