package com.jpa.expert.entity.inquire.domain;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private Long id;
    private String questionTitle;
    private String questionContent;
    private int answerCount;
}
