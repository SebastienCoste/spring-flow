package fr.sttc.mongo.repository;


import fr.sttc.mongo.domain.Quote;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface QuoteRepository extends ReactiveMongoRepository<Quote, String>{

}
