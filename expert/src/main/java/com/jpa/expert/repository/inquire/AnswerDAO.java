package com.jpa.expert.repository.inquire;

import com.jpa.expert.entity.inquire.Answer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class AnswerDAO {
    @PersistenceContext
    private EntityManager entityManager;

    //    답변 추가
    public Answer save(Answer answer){
        entityManager.persist(answer);
        return answer;
    }

    //    답변 조회
    public Optional<Answer> findById(Long id){
        return Optional.ofNullable(entityManager.find(Answer.class, id));
    }

    //    답변 전체 조회
    public List<Answer> findAll(){
        String query = "select a from Answer a";
        return entityManager.createQuery(query, Answer.class).getResultList();
    }

    //    답변 삭제
    public void delete(Answer answer){
        entityManager.remove(answer);
    }
}
