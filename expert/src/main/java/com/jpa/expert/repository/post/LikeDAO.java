package com.jpa.expert.repository.post;

import com.jpa.expert.entity.post.Like;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class LikeDAO {
    @PersistenceContext
    private EntityManager entityManager;

//    좋아요 추가
    public Like save(Like like){
        entityManager.persist(like);
        return like;
    }
//    좋아요 조회
    public Optional<Like> findById(Long id){
        return Optional.ofNullable(entityManager.find(Like.class, id));
    }
//    좋아요 전체 조회
    public List<Like> findAll(){
        String query = "select l from Like l";
        return entityManager.createQuery(query, Like.class).getResultList();
    }
//    좋아요 삭제
    public void delete(Like like){
        entityManager.remove(like);
    }
}


















