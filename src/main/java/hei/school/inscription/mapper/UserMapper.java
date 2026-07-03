package hei.school.inscription.mapper;

import hei.school.inscription.dto.UserDto;
import hei.school.inscription.entity.User;

import java.util.UUID;

public class UserMapper {
    public User dtoToEntity (UserDto userDto) {
        return new User(UUID.randomUUID().toString(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getUserName(),
                userDto.getEmail());
    }
    public UserDto entityToDto (User user) {
        return new UserDto (
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getEmail());
    }
}
