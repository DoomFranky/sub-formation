package hei.school.inscription.endpoint;

import hei.school.inscription.mail.Email;
import hei.school.inscription.mail.Mailer;
import jakarta.mail.internet.InternetAddress;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SubController {
    private final Mailer mailer;

    @GetMapping("/sub")
    @SneakyThrows
    public String helloWorld(@RequestBody String to) {
        var email =
                new Email(new InternetAddress(to), List.of(), List.of(), "Formation subscribe", "You are subscribe", List.of());

        mailer.accept(email);
        return "You are subscribe";
    }
}
