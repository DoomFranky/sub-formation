package hei.school.inscription.service;

import hei.school.inscription.dto.UserDto;
import hei.school.inscription.endpoint.event.EventProducer;
import hei.school.inscription.endpoint.event.model.SendEmailRequested;
import hei.school.inscription.mapper.UserMapper;
import hei.school.inscription.repository.UserRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubService {
  private final EventProducer<SendEmailRequested> eventProducer;
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public void postSubscribe(UserDto userDto) {

    var event = SendEmailRequested.builder().userDto(userDto).build();
    eventProducer.accept(List.of(event));

    // userRepository.save(userMapper.dtoToEntity(userDto));
  }
}
