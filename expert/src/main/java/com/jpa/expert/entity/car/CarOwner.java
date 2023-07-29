package com.jpa.expert.entity.car;

import com.jpa.expert.auditing.Period;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_CAR_OWNER")
@Getter @Setter @ToString(callSuper = true, exclude = {"carRegistrations"})
@SQLDelete(sql = "UPDATE TBL_CAR_OWNER SET DELETED = 1 WHERE ID = ?")
@Where(clause = "DELETED = 0")
public class CarOwner extends Period {
    @Id @GeneratedValue
    private Long id;
    @NotNull private String carOwnerName;
    @NotNull private int carOwnerAge;
    @Embedded private CarOwnerAddress carOwnerAddress;
    private boolean deleted = Boolean.FALSE;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carOwner")
    private List<CarRegistration> carRegistrations = new ArrayList<>();

    public void setCarRegistration(CarRegistration carRegistration) {
        if(carRegistration.getCarOwner() != this){
            carRegistration.setCarOwner(this);
        }
        this.carRegistrations.add(carRegistration);
    }
}






















