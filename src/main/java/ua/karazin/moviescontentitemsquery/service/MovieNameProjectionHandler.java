package ua.karazin.moviescontentitemsquery.service;

import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import ua.karazin.moviesbaseevents.movies.revision2.MovieCreatedEvent2;
import ua.karazin.moviesbaseevents.movies.revision2.MovieDeletedEvent2;
import ua.karazin.moviesbaseevents.movies.revision2.MovieUpdatedEvent2;
import ua.karazin.moviescontentitemsquery.MovieMapper;
import ua.karazin.moviescontentitemsquery.MovieNameRepository;

@Component
@RequiredArgsConstructor
public class MovieNameProjectionHandler {
    private final MovieNameRepository repository;
    private final MovieMapper movieMapper;

    @EventHandler
    public void on(MovieCreatedEvent2 event) {
        var movie = movieMapper.fromDto(event.movie());
        movie.setId(event.movieId());
        repository.save(movie);
    }

    @EventHandler
    public void on(MovieUpdatedEvent2 event) {
        var movie = repository.findById(event.movieId()).orElseThrow();
        movie.setTitle(event.movie().title());
        repository.save(movie);
    }

    @EventHandler
    public void on(MovieDeletedEvent2 event) {
        repository.deleteById(event.movieId());
    }
}
