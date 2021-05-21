package ro.sd.a2.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="UserEntity")
public class UsersEntity {

    @Id
    private String user_id;

    @Column
    @Email
    private String user_name;

    @Column
    @Email
    private String user_password;

    @Column
    private String user_email;

    @Column
    private String user_birthdate;

    @Column
    private char user_type;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Team> teams;

    public UsersEntity() {
    }

    public void addTeam(Team team){
        teams.add(team);
        team.setUser(this);
    }

    public void deleteTeam(Team team){
        teams.remove(team);
        team.setUser(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + user_id + '\'' +
                ", name='" + user_name + '\'' +
                '}';
    }
}
