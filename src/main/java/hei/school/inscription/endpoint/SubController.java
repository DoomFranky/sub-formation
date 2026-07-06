package hei.school.inscription.endpoint;

import hei.school.inscription.dto.UserDto;
import hei.school.inscription.endpoint.event.EventProducer;
import hei.school.inscription.endpoint.event.model.SendEmailRequested;
import hei.school.inscription.service.SubService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class SubController {
  private final EventProducer<SendEmailRequested> eventProducer;
  private final SubService subService;

  @PostMapping("/sub")
  @SneakyThrows
  public String subscribeThUser(@RequestBody UserDto userDto) {
    subService.postSubscribe(userDto);
    return "You are subscribe";
  }
}
