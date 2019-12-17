package uk.co.techswitch.domain;

import java.util.List;

public class ReviewDetails {
    private Double rating;
    private Integer ratingsCount;
    private List<ReviewComment> reviews;

    public ReviewDetails(){};

    public ReviewDetails(Double rating, Integer ratingsCount, List<ReviewComment> reviews){
        this.rating = rating;
        this.ratingsCount = ratingsCount;
        this.reviews = reviews;
    }


    public List<ReviewComment> getReviews() {
        return reviews;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getRatingsCount() {
        return ratingsCount;
    }

    @Override
    public String toString() {
        return "ReviewDetails{" +
                "reviewCommentList=" + reviews +
                '}';
    }
}
