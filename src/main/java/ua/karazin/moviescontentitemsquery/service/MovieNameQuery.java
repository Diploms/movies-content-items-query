package ua.karazin.moviescontentitemsquery.service;

import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import ua.karazin.moviescontentitemsquery.Movie;
import ua.karazin.moviescontentitemsquery.MovieNameRepository;

@Component
@RequiredArgsConstructor
public class MovieNameQuery {
    private final MovieNameRepository repository;

    @QueryHandler(queryName = "findAll")
    private Iterable<Movie> findAll() {
        return repository.findAll();
    }

    @QueryHandler(queryName = "findById")
    private Movie findById(String id) {
        return repository.findById(id).orElse(null);
    }
}
