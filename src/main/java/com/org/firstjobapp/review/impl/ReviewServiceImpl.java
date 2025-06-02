package com.org.firstjobapp.review.impl;

import com.org.firstjobapp.company.CompanyService;
import com.org.firstjobapp.review.Review;
import com.org.firstjobapp.review.ReviewRepository;
import com.org.firstjobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository , CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public void addReview(Long companyId, Review review) {
        reviewRepository.save()
    }
}
