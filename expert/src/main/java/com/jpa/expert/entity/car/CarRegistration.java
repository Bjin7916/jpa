package com.jpa.expert.entity.car;

import com.jpa.expert.auditing.Period;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CAR_REGISTRATION")
@Getter @Setter @ToString(callSuper = true)
@SQLDelete(sql = "UPDATE TBL_CAR_REGISTRATION SET DELETED = 1 WHERE ID = ?")
@Where(clause = "DELETED = 0")
public class CarRegistration extends Period {
    @Id @GeneratedValue
    private Long id;
    private boolean deleted = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    private CarOwner carOwner;

}



















