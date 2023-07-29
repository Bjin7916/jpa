package com.jpa.advanced.entity.member;

import com.jpa.advanced.auditing.Period;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_FILE")
@Getter @Setter @ToString
public class File extends Period {
    @Id @GeneratedValue
    private Long id;
    @NotNull private String fileName;
    @NotNull private String filePath;
    @NotNull private String fileUuid;
    @NotNull private Long fileSize;

//    1:1관계에서는 추후 유지보수 시 N이 될 수 있는 객체를 연관관계의 주인으로 설정한다.
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
}
