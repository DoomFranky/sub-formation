package hei.school.inscription.service.event;

import hei.school.inscription.endpoint.event.model.SendEmailRequested;
import hei.school.inscription.mail.Email;
import hei.school.inscription.mail.Mailer;
import hei.school.inscription.service.FileUrlService;
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
  private final FileUrlService fileUrlService;

  @SneakyThrows
  @Override
  public void accept(SendEmailRequested sendEmailRequested) {
    try {
      // emailValidator.validEmail(sendEmailRequested.getTo());
      InternetAddress recipientAddress =
          new InternetAddress(sendEmailRequested.getUserDto().getEmail());
      String htmlBody =
          """
          <html>
              <h1>You are subscribed!</h1>
              <p>Check this pdf to see your inscription details.</p>
              <a href="%s">Download PDF</a>
          </html>
          """
              .formatted(fileUrlService.uploadInscriptionFile(sendEmailRequested.getUserDto()));
      mailer.accept(
          new Email(
              recipientAddress, List.of(), List.of(), "Formation subscribe", htmlBody, List.of()));
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}
