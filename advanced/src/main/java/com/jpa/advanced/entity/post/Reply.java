package com.jpa.advanced.entity.post;

import com.jpa.advanced.auditing.Period;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity @Table(name = "TBL_REPLY")
@Getter @Setter @ToString
public class Reply extends Period {
    @Id @GeneratedValue
    private Long id;
    @NotNull private String replyContent;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "POST_ID")
    private Post post;
}

















