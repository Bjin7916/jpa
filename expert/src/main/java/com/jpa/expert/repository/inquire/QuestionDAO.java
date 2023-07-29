package com.jpa.expert.repository.inquire;

import com.jpa.expert.entity.inquire.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class QuestionDAO {
    @PersistenceContext
    private EntityManager entityManager;

//    질문 추가
    public Question save(Question question){
        entityManager.persist(question);
        return question;
    }

//    질문 조회
    public Optional<Question> findById(Long id){
        return Optional.ofNullable(entityManager.find(Question.class, id));
    }

//    질문 전체 조회
    public List<Question> findAll(){
        String query = "select q from Question q";
        return entityManager.createQuery(query, Question.class).getResultList();
    }

//    질문 삭제
    public void delete(Question question){
        entityManager.remove(question);
    }
}


















