package hei.school.inscription.service.event;

import hei.school.inscription.endpoint.event.model.SendEmailRequested;
import hei.school.inscription.mail.Email;
import hei.school.inscription.mail.Mailer;
import jakarta.mail.internet.InternetAddress;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.ws.rs.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SendEmailRequestedService implements Consumer<SendEmailRequested> {
    private final Mailer mailer;

    @SneakyThrows
    @Override
    public void accept(SendEmailRequested sendEmailRequested) {
        String email = sendEmailRequested.getUserDto().getEmail();
        Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");
        Matcher m = p.matcher(email);


        if (!m.find()) {
            throw new BadRequestException("email format is not respected");
        }
        InternetAddress recipientAddress = new InternetAddress();
        mailer.accept(new Email(recipientAddress, List.of(), List.of(), "Formation subscribe", "You are subscribe", List.of()));
    }
}