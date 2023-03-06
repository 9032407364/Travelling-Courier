package com.travelingcourier.controller;

import com.travelingcourier.model.Rating;
import com.travelingcourier.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable(value = "id") Long ratingId) {
        Rating rating = ratingService.findById(ratingId);
        if (rating == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(rating);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Rating>> getRatingsByUser(@PathVariable(value = "id") Long userId) {
        User user = new User();
        user.setId(userId);
        List<Rating> ratings = ratingService.getRatingsByUser(user);
        if (ratings == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(ratings);
    }

    @GetMapping("/user/{id}/average")
    public ResponseEntity<Double> getAverageRatingByUser(@PathVariable(value = "id") Long userId) {
        User user = new User();
        user.setId(userId);
        Double averageRating = ratingService.getAverageRatingByUser(user);
        if (averageRating == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(averageRating);
    }

    @PostMapping("/")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating savedRating = ratingService.saveRating(rating);
        return ResponseEntity.ok().body(savedRating);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable(value = "id") Long ratingId) {
        ratingService.deleteRating(ratingId);
        return ResponseEntity.noContent().build();
    }

}
