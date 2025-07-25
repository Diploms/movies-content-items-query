package ua.karazin.moviescontentitemsquery.configuration;

import org.axonframework.config.ConfigurerModule;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfiguration {
    @Bean
    public ConfigurerModule processorDefaultConfigurerModule() {
        return configurer -> configurer
                .eventProcessing(EventProcessingConfigurer::usingTrackingEventProcessors);
    }
}
