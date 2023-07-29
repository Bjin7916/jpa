package com.jpa.expert.entity.inquire;

import com.jpa.expert.repository.inquire.AnswerDAO;
import com.jpa.expert.repository.inquire.QuestionDAO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class InquireTests {
    @Autowired
    private QuestionDAO questionDAO;
    @Autowired
    private AnswerDAO answerDAO;

    @Test
    public void saveTest(){
//        1. Question(1) -> Answer(N), 연관관계 주인은 아니지만, 목적에 맞는 로직
//        Question question = new Question();
//        question.setQuestionTitle("전철역");
//        question.setQuestionContent("전철역 어디가 좋아요?");
//        questionDAO.save(question);

//        final Optional<Question> foundQuestion = questionDAO.findById(18L);
//        Answer answer1 = new Answer();
//        Answer answer2 = new Answer();
//
//        answer1.setAnswerContent("역삼역 추천합니다.");
//        answer2.setAnswerContent("위워크 추천합니다.");
//
//        foundQuestion.ifPresent(question -> {
//            answer1.setQuestion(question);
//            answer2.setQuestion(question);
//            question.getAnswers().add(answer1);
//            question.getAnswers().add(answer2);
//        });

//        2.  Answer(N) -> Question(1), 연관관계 주인이지만, 목적에 맞지 않는 로직
//        Answer answer = answerDAO.findById(19L).get();
//
//        Question question = new Question();
//        question.setQuestionTitle("첫 데이트 어디가 좋을까요?");
//        question.setQuestionContent("빨리 알려주세요!");
//
//        questionDAO.save(question);
//
//        answer.setQuestion(question);

//        연관관계의 주인이 아닌 question.answers는 조회 목적으로만 사용한다.
//        질문에 답변을 추가하고 싶다면, answer.setQuestion()를 사용하여 직접 질문을 지정해야 한다.
//        만약 매번 setQuestion()을 사용하기 불편하다면, 편의 메소드를 제작한다.

//        3. Question(1) -> Answer(N), 편의 메소드 사용, 목적도 맞고 연관관계도 성립
        final Optional<Question> foundQuestion = questionDAO.findById(23L);
        Answer answer = new Answer();

        answer.setAnswerContent("성수동 가세요.");
        foundQuestion.ifPresent(question -> question.setAnswer(answer));
    }

    @Test
    public void findByIdTest(){
        final Optional<Question> foundQuestion = questionDAO.findById(23L);
        foundQuestion.ifPresent(question -> question.getAnswers().forEach(answer -> log.info(answer.getAnswerContent())));
    }

    @Test
    public void findAllTest(){
        assertThat(questionDAO.findAll()).hasSize(2);
    }

    @Test
    public void updateTest(){
        Question question = questionDAO.findById(23L).get();
        question.getAnswers().get(0).setAnswerContent("수정된 답변");
    }

    @Test
    public void deleteTest(){
        Question question = questionDAO.findById(23L).get();
        question.getAnswers().remove(0);
    }
}



















