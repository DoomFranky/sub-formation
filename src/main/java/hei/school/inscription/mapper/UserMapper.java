package hei.school.inscription.mapper;

import hei.school.inscription.dto.UserDto;
import hei.school.inscription.entity.Course;
import hei.school.inscription.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UserMapper {
    public User dtoToEntity (UserDto userDto, List<Course> courses) {
        return new User(UUID.randomUUID().toString(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getUserName(),
                userDto.getEmail(),
                courses);
    }
    public UserDto entityToDto (User user) {
        return new UserDto (
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getEmail());
    }
}
