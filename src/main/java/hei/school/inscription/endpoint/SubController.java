package hei.school.inscription.endpoint;

import hei.school.inscription.dto.UserDto;
import hei.school.inscription.endpoint.event.EventProducer;
import hei.school.inscription.endpoint.event.model.SendEmailRequested;
import hei.school.inscription.mail.Email;
import hei.school.inscription.mail.Mailer;
import jakarta.mail.internet.InternetAddress;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SubController {
    private final EventProducer<SendEmailRequested> eventProducer;

    @PostMapping("/sub")
    @SneakyThrows
    public String subscribe(@RequestBody UserDto userDto) {
        var event = SendEmailRequested.builder().userDto(userDto).build();
        eventProducer.accept(List.of(event));
        return "You are subscribe";
    }
}
