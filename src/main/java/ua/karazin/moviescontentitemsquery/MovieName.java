package ua.karazin.moviescontentitemsquery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@RedisHash("movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieName {
    private UUID id;
    private String title;
}
