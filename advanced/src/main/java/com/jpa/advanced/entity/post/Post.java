package com.jpa.advanced.entity.post;

import com.jpa.advanced.auditing.Period;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_POST")
@Getter @Setter @ToString
public class Post extends Period {
    @Id @GeneratedValue
    private Long id;
    @NotNull private String postTitle;
    @NotNull private String postContent;

//    1:N 단방향
//    fetch(DEFAULT: LAZY)
//    연관관계를 맺고 있는 경우,
//    조회 시 객체를 가져오는 방법을 기술하는 옵션이다.
//    - EAGER : 모든 연관관계 객체를 JOIN하여 한 방 쿼리로 가져온다.
//    - LAZY : 첫 객체만 SELECT한 뒤 연관 객체에 접근할 때 쿼리가 발생한다.
//    복잡한 연관관계 속에서 EAGER를 사용하면 불필요한 JOIN이 발생하기 때문에
//    성능이 저하될 수 있다. 따라서 LAZY를 기본으로 설정한 뒤
//    한 방 쿼리가 필요할 경우 직접 JOIN 쿼리를 작성해서 사용해야 한다.

//    cascade(영속성 전이)
//    엔티티가 영속상태로 전환될 때 참조 엔티티도 영속상태로 같이 전환되고,
//    삭제 상태로 전환될 때에도 참조 엔티티까지 삭제 상태로 전환된다.
//    즉, 연관 객체에도 영속 상태를 전이하고 싶을 때 사용하는 옵션이다.
//    ※ CascadeType.REMOVE 사용 시, 자식 정보의 FK를 null로 변경해야 JPA가 삭제로 감지한다.
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "POST_ID") //FK 설정
    private List<Reply> replies = new ArrayList<>();

}

























