package ro.sd.a2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@AllArgsConstructor
@Getter
@Setter
@Table(name="League")
public class League {
    @Id
    private String league_id;

    @Column
    private String league_name;

    @Column
    private String league_image_url;

    @Column
    private String league_cover_url;

    public League() {
    }
}
