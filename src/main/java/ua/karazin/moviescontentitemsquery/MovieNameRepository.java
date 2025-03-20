package ua.karazin.moviescontentitemsquery;

import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface MovieNameRepository extends ListCrudRepository<MovieName, UUID> {
}
