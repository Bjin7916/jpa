package com.jpa.expert.entity.inquire;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_ANSWER")
@Getter @Setter @ToString(exclude = "question")
public class Answer {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String answerContent;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;
}





















