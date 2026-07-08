package hei.school.inscription.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "course")
public class Course {
    @Id
    private UUID id_course;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
     private String description;
    @Column(nullable = false)
     private Instant startDate;
    @Column(nullable = false)
     private Instant endDate;

    @ManyToMany(mappedBy = "courses")
    private List<Users> users = new ArrayList<>();
}
