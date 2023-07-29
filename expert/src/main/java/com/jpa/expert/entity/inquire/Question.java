package com.jpa.expert.entity.inquire;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_QUESTION")
@Getter @Setter @ToString
public class Question {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String questionTitle;
    @NotNull private String questionContent;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "question", orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    public void setAnswer(Answer answer){
        if(answer.getQuestion() != this){
            answer.setQuestion(this);
        }
        this.answers.add(answer);
    }
}

























