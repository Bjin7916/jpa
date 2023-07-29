package com.jpa.intermediate.entity.file;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_MEMBER_FILE")
@Getter @Setter @ToString(callSuper = true)
@PrimaryKeyJoinColumn(name = "MEMBER_FILE_ID")
public class MemberFile extends File {
    private String memberName;
}
