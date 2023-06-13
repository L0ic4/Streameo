package com.stream.streameo.Service;

import com.stream.streameo.Entity.LikeEntity;
import com.stream.streameo.Repository.LikeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    public void like(LikeEntity likeEntity){
        likeRepository.save(likeEntity);
    }
    public void unlike(LikeEntity likeEntity){
        likeRepository.deleteById(likeEntity.getLikeId());
    }

    public int getLikeNumber(int movieId){
        return likeRepository.countByMovieEntityMovieId(movieId);
    }

}
