package dev.vshr.movies.ServiceInterfaces;

import dev.vshr.movies.Entity.Movie;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    public List<Movie> allMovies();

    public Optional<Movie> getSingleMovie(String imdbId);

}
