package dev.vshr.movies.Service;

import dev.vshr.movies.Entity.Movie;
import dev.vshr.movies.Entity.Review;
import dev.vshr.movies.Repository.ReviewRepository;
import dev.vshr.movies.ServiceInterfaces.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){
        Review review = new Review(reviewBody);

        reviewRepository.insert(review);

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }


}
