package ua.karazin.moviescontentitemsquery;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.karazin.moviesbaseevents.movies.revision2.MovieDto2;

@Mapper
public interface MovieMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "releaseYear", target = "releaseYear")
    @Mapping(source = "price", target = "price")
    Movie fromDto(MovieDto2 dto2);
}
