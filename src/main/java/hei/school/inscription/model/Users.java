package hei.school.inscription.model;

import hei.school.inscription.Entity.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users {
    private UUID id;
    private String lastname;
    private String firstname;
    private String email;
    private String phoneNumber;
    private String address;
    private List<Course> courses=new ArrayList<>();
}
