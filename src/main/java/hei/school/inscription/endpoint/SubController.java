package hei.school.inscription.endpoint;

import hei.school.inscription.dto.UserDto;
import hei.school.inscription.endpoint.event.EventProducer;
import hei.school.inscription.endpoint.event.model.SendEmailRequested;
import hei.school.inscription.mail.Email;
import hei.school.inscription.mail.Mailer;
import hei.school.inscription.service.SubService;
import jakarta.mail.internet.InternetAddress;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SubController {
    private final EventProducer<SendEmailRequested> eventProducer;
    private final SubService subService;

    @PostMapping("/sub")
    @SneakyThrows
    public String subscribe(@RequestBody UserDto userDto) {
        subService.postSubscribe(userDto);
        return "You are subscribe";
    }
}
