package ro.sd.a2.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@Getter
@Setter
@Table(name="Driver")
public class Driver {

    @Id
    private String driver_id;


    @Column
    private String driver_name;

    @Column
    private int driver_nr;

    @Column
    private int driver_age;

    @Column
    private String driver_nationality;

    @Column
    private float driver_price;

    @Column
    private int driver_points;

    @Column
    private  int driver_standing;

    @ManyToOne(fetch=FetchType.LAZY)
    private Constructor constructor;

    public Driver() {
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

}

