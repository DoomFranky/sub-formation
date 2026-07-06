package hei.school.inscription.dto;

import hei.school.inscription.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private List<Course> courses;
}
