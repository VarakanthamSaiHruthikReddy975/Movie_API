package dev.vshr.movies.ServiceInterfaces;

import dev.vshr.movies.Entity.Review;

public interface ReviewService {
    public Review createReview(String reviewBody, String imdbId);
}
