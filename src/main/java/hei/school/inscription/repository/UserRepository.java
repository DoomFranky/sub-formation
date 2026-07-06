package hei.school.inscription.repository;

import hei.school.inscription.entity.UserStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserStudent, String> {}
