package ua.karazin.moviescontentitemsquery;

import lombok.RequiredArgsConstructor;
import org.axonframework.config.EventProcessingConfiguration;
import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventhandling.TrackingEventProcessor;
import org.axonframework.eventhandling.TrackingEventProcessorConfiguration;
import org.axonframework.messaging.StreamableMessageSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class MoviesContentItemsQueryApplication implements CommandLineRunner {
    private final EventProcessingConfigurer configurer;
    private final EventProcessingConfiguration processingConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(MoviesContentItemsQueryApplication.class, args);
    }

    @Override
    public void run(String... args) {
        TrackingEventProcessorConfiguration tepConfig =
                TrackingEventProcessorConfiguration.forSingleThreadedProcessing()
                        .andInitialTrackingToken(StreamableMessageSource::createHeadToken);

        configurer.registerTrackingEventProcessorConfiguration("test", config -> tepConfig);

        processingConfiguration.eventProcessor("test", TrackingEventProcessor.class)
                .ifPresent(streamingProcessor -> {
                    streamingProcessor.shutDown();
                    streamingProcessor.resetTokens();
                    streamingProcessor.start();
                });
    }
}
