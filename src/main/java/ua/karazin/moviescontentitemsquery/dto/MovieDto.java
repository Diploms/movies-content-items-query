package ua.karazin.moviescontentitemsquery.dto;

import java.util.UUID;

public record MovieDto(UUID id,
                       String title,
                       Integer releaseYear) {
}
