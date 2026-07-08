package hei.school.inscription.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserCourseRepository {
    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO users_courses(user_id, course_id) VALUES (:userId, :courseId)",
            nativeQuery = true
    )
    void addUserToCourse(
            @Param("userId") UUID userId,
            @Param("courseId") UUID courseId
    );
}
