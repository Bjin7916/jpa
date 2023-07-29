package com.jpa.expert.entity.post;

import com.jpa.expert.auditing.Period;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_LIKE")
@Getter @Setter @ToString(exclude = "post")
public class Like extends Period {
//    좋아요 번호
    @Id @GeneratedValue
    private Long id;
//    연관 객체
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
}




















