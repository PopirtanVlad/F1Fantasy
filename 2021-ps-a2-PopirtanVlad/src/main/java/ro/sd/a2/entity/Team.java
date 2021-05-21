package ro.sd.a2.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@Table(name="Team")
public class Team {

    @Id
    private String team_id;

    @Column
    private String team_name;

    @Column
    private float team_budget;

    @ManyToOne(fetch = FetchType.LAZY)
    private UsersEntity user;

    @Column
    private int team_points;

    public Team() {
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

}
