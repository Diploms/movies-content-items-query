package ua.karazin.moviescontentitemsquery.service;

import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import ua.karazin.moviescontentitemsquery.Movie;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class MovieNameQueryService {
    private final MovieNameQuery movieNameQuery;
    private final QueryGateway queryGateway;

    public CompletableFuture<List<Movie>> findAll() {
        return queryGateway.query(
                "findAll",
                null,
                ResponseTypes.multipleInstancesOf(Movie.class)
        );
    }

    public CompletableFuture<Movie> findById(UUID id) {
        return queryGateway.query(
                "findById",
                id,
                ResponseTypes.instanceOf(Movie.class));
    }
}
