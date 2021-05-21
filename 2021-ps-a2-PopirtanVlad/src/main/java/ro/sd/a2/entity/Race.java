package ro.sd.a2.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@Table(name="Race")
public class Race {
    @Id
    private String race_id;

    @Column
    private String race_location;

    @Column
    private String race_date;

    @Column
    private String race_name;

    public Race() {
    }

    public Race(String race_location) {
        this.race_id= UUID.randomUUID().toString();
        this.race_location = race_location;
    }

}
