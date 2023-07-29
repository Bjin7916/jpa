package com.jpa.advanced.entity.hospital;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_PET")
@Getter @Setter @ToString
public class Pet {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String petName;
    @Enumerated(EnumType.STRING)
    @NotNull private GenderType petGender;
    @NotNull private String petDisease;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;
}
