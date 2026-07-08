package hei.school.inscription.model;

import hei.school.inscription.Entity.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {
    private UUID id_course;
    private String title;
    private String description;
    private Instant startDate;
    private Instant endDate;
    private List<Users> users=new ArrayList<>();
}
