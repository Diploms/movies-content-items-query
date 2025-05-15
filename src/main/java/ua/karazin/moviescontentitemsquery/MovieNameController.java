package ua.karazin.moviescontentitemsquery;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.karazin.moviescontentitemsquery.service.MovieNameQueryService;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieNameController {
    private final MovieNameQueryService movieNameQueryService;

    @GetMapping
    public CompletableFuture<List<Movie>> findAll() {
        return movieNameQueryService.findAll();
    }

    @GetMapping("/{id}")
    public CompletableFuture<Movie> findById(@PathVariable UUID id) {
        return movieNameQueryService.findById(id);
    }
}
