package hei.school.inscription.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "userStudent")
public class UserStudent {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    @ManyToMany
    private List<Course> courses;
}