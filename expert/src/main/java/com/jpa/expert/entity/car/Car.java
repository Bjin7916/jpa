package com.jpa.expert.entity.car;

import com.jpa.expert.auditing.Period;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_CAR")
@Getter @Setter @ToString(callSuper = true, exclude = {"carRegistrations"})
@SQLDelete(sql = "UPDATE TBL_CAR SET DELETED = 1 WHERE ID = ?")
@Where(clause = "DELETED = 0")
public class Car extends Period {
    @Id @GeneratedValue
    private Long id;
    @NotNull private String carName;
    @Enumerated(EnumType.STRING)
    private CarBrand carBrand;
    private Long carPrice;
    private LocalDateTime carReleaseDate;
    private boolean deleted = Boolean.FALSE;

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private List<CarRegistration> carRegistrations = new ArrayList<>();

   public void setCarRegistration(CarRegistration carRegistration) {
       if(carRegistration.getCar() != this){
           carRegistration.setCar(this);
       }
       this.carRegistrations.add(carRegistration);
   }
}


















