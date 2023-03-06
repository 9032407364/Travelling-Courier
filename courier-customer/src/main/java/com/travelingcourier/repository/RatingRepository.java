package com.travelingcourier.repository;

import com.travelingcourier.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT AVG(r.rating) FROM Rating r WHERE r.user = :user")
    Double getAverageRatingByUser(@Param("user") User user);

    List<Rating> findByUser(User user);

}

