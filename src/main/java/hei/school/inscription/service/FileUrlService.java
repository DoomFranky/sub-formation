package hei.school.inscription.service;

import static java.io.File.createTempFile;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import hei.school.inscription.dto.UserDto;
import hei.school.inscription.file.bucket.BucketComponent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.Duration;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FileUrlService {
  private final BucketComponent bucketComponent;

  @SneakyThrows
  public String uploadInscriptionFile(UserDto user) {
    var fileSuffix = ".pdf";
    String filePrefix = "inscription-" + user.getFirstName() + "-" + user.getLastName() + "-";
    var bucketKey = filePrefix + fileSuffix;
    File fileToUpload = createTempFile(filePrefix, fileSuffix);
    String message =
        """
        <html>
            <h1>Your inscription has been successfully completed.</h1>
            <p>FirstName: %s</p>
            <p>LastName: %s</p>
            <p>UserName: %s</p>
            <p>Email: %s</p>
        </html>
        """
            .formatted(
                user.getFirstName(), user.getLastName(), user.getUserName(), user.getEmail());
    try (OutputStream os = new FileOutputStream(fileToUpload)) {
      PdfRendererBuilder builder = new PdfRendererBuilder();
      builder.withHtmlContent(message, null).toStream(os).run();
    } catch (Exception e) {
      throw new RuntimeException("Failed to generate PDF", e);
    }
    bucketComponent.upload(fileToUpload, bucketKey);
    return bucketComponent.presign(bucketKey, Duration.ofMinutes(5)).toString();
  }
}
