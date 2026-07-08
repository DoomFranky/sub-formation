package hei.school.inscription.service.event;

import hei.school.inscription.endpoint.event.model.SendEmailRequested;
import hei.school.inscription.mail.Email;
import hei.school.inscription.mail.Mailer;
import hei.school.inscription.service.validator.EmailValidator;
import jakarta.mail.internet.InternetAddress;
import java.util.List;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SendEmailRequestedService implements Consumer<SendEmailRequested> {
  private final Mailer mailer;
  private final EmailValidator emailValidator;

  @SneakyThrows
  @Override
  public void accept(SendEmailRequested sendEmailRequested) {
    try {
      // emailValidator.validEmail(sendEmailRequested.getTo());
      InternetAddress recipientAddress = new InternetAddress();
      mailer.accept(
          new Email(
              recipientAddress,
              List.of(),
              List.of(),
              "Formation subscribe",
              "You are subscribe",
              List.of()));
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}
