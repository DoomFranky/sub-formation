package hei.school.inscription.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "course")
public class Course {
  @Id private String id;
  private String title;
  private Instant startDate;
  private Instant endDate;

  @ManyToMany(mappedBy = "courses")
  private List<UserStudent> users;
}
