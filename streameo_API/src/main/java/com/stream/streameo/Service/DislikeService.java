package com.stream.streameo.Service;

import com.stream.streameo.Entity.DislikeEntity;
import com.stream.streameo.Repository.DislikeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DislikeService {
    private final DislikeRepository dislikeRepository;

    public void dislike(DislikeEntity dislike){
        dislikeRepository.save(dislike);
    }
    public void unDisLike(DislikeEntity dislike){
        dislikeRepository.deleteById(dislike.getDisLikeId());
    }
    public int getDislikeNumber(int movieId){
        return dislikeRepository.countByMovieEntityMovieId(movieId);
    }

}
