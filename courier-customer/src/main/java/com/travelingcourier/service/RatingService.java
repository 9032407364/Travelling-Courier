package com.travelingcourier.service;

import com.travelingcourier.model.Rating;
import com.travelingcourier.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Double getAverageRatingByUser(User user) {
        return ratingRepository.getAverageRatingByUser(user);
    }

    public List<Rating> getRatingsByUser(User user) {
        return ratingRepository.findByUser(user);
    }

    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }

}

