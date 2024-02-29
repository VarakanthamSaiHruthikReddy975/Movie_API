package dev.vshr.movies.Service;

import dev.vshr.movies.Entity.Movie;
import dev.vshr.movies.Repository.MovieRepository;
import dev.vshr.movies.ServiceInterfaces.MovieService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getSingleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
