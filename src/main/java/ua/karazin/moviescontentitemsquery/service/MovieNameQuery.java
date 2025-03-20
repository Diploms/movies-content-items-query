package ua.karazin.moviescontentitemsquery.service;

import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import ua.karazin.moviescontentitemsquery.MovieName;
import ua.karazin.moviescontentitemsquery.MovieNameRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MovieNameQuery {
    private final MovieNameRepository repository;

    @QueryHandler(queryName = "findAll")
    private Iterable<MovieName> findAll() {
        return repository.findAll();
    }

    @QueryHandler(queryName = "findById")
    private MovieName findById(UUID id) {
        return repository.findById(id).orElse(null);
    }
}
