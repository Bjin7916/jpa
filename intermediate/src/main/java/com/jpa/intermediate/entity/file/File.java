package com.jpa.intermediate.entity.file;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_FILE")
@Inheritance(strategy = InheritanceType.JOINED)
public class File {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String fileName;
    private String uuid;
    private String filePath;
    private Long fileSize;
}
