package ua.karazin.moviescontentitemsquery;

import org.springframework.data.repository.ListCrudRepository;

public interface MovieNameRepository extends ListCrudRepository<Movie, String> {
}
