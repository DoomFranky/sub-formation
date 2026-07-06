package hei.school.inscription.mapper;

import hei.school.inscription.dto.UserDto;
import hei.school.inscription.entity.Course;
import hei.school.inscription.entity.UserStudent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UserMapper {
    public UserStudent dtoToEntity (UserDto userDto) {
        return new UserStudent(UUID.randomUUID().toString(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getUserName(),
                userDto.getEmail(),
                userDto.getCourses());
    }
    public UserDto entityToDto (UserStudent user) {
        return new UserDto (
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getEmail(),
                user.getCourses());
    }
}
