package ro.sd.a2.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="Constructor")
public class Constructor {

    @Id
    private String constructor_id;

    @Column
    private String constructor_name;

    @Column
    private float constructor_price;

    @Column
    private int constructor_points;

    @OneToMany(mappedBy="constructor", orphanRemoval = false)
    private Set<Driver> drivers;

    public void addDrivers(Driver driver){
        drivers.add(driver);
        driver.setConstructor(this);
    }

    public void removeDriver(Driver driver){
        drivers.remove(driver);
        driver.setConstructor(null);
    }


    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }
}
