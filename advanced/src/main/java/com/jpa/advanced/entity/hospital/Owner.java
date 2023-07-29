package com.jpa.advanced.entity.hospital;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_OWNER")
@Getter @Setter @ToString
public class Owner {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String ownerName;
    @Column(unique = true)
    @NotNull private String ownerPhone;

//    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//    @JoinColumn(name = "OWNER_ID")
//    private List<Pet> pets = new ArrayList<>();
}
