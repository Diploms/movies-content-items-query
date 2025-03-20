package ua.karazin.moviescontentitemsquery.service;

import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import ua.karazin.movieevents.MovieCreatedEvent;
import ua.karazin.movieevents.MovieDeletedEvent;
import ua.karazin.movieevents.MovieUpdatedEvent;
import ua.karazin.moviescontentitemsquery.MovieName;
import ua.karazin.moviescontentitemsquery.MovieNameRepository;

@Component
@RequiredArgsConstructor
@ProcessingGroup("test")
public class MovieNameProjectionHandler {
    private final MovieNameRepository repository;

    @EventHandler
    public void on(MovieCreatedEvent event) {
        var movie = new MovieName(event.movieId(), event.movie().title());
        repository.save(movie);
    }

    @EventHandler
    public void on(MovieUpdatedEvent event) {
        var movie = repository.findById(event.id()).orElseThrow();
        movie.setTitle(event.movie().title());
        repository.save(movie);
    }

    @EventHandler
    public void on(MovieDeletedEvent event) {
        repository.deleteById(event.id());
    }
}
