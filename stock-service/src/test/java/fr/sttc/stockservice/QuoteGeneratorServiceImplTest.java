package fr.sttc.stockservice;

import fr.sttc.stockservice.model.Quote;
import fr.sttc.stockservice.service.QuoteGeneratorServiceImpl;
import org.junit.Before;
import org.junit.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

public class QuoteGeneratorServiceImplTest {

    QuoteGeneratorServiceImpl quoteGeneratorService = new QuoteGeneratorServiceImpl();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void fetchQuoteStream() throws Exception {

        //get quoteFlux of quotes
        Flux<Quote> quoteFlux = quoteGeneratorService.fetchQuoteStream(Duration.ofMillis(1L));

        quoteFlux.take(22000)
                .subscribe(System.out::println);

    }

    @Test
    public void fetchQuoteStreamCountDown() throws Exception {


        //set Countdown latch to 1
        CountDownLatch countDownLatch = new CountDownLatch(1);


        quoteGeneratorService
                .fetchQuoteStream(Duration.ofMillis(1L))
                .take(30)
                .subscribe(
                        System.out::println,
                        System.out::println,
                        () -> countDownLatch.countDown());

        countDownLatch.await();
    }
}
