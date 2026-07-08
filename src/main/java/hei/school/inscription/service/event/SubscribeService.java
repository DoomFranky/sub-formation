package hei.school.inscription.service.event;

import hei.school.inscription.endpoint.event.EventProducer;
import hei.school.inscription.endpoint.event.model.SendEmailRequested;
import hei.school.inscription.repository.UserCourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SubscribeService {
        private final UserCourseRepository subscribeRepository;
        private final EventProducer<SendEmailRequested> emailProducer;
        private final PdfService pdfService;
        private final S3Service s3Service;


        public void addUserToCourse(UUID userId, UUID courseId, String email) {

            // 1. Inscription dans la base
            subscribeRepository.addUserToCourse(userId, courseId);


            // 2. Génération du PDF
            byte[] pdf = pdfService.generateConfirmation(userId, courseId);


            // 3. Upload dans S3
            String pdfUrl = s3Service.upload(pdf);


            // 4. Envoi événement email
            SendEmailRequested event = SendEmailRequested.builder()
                    .to(email)
                    .subject("Confirmation d'inscription")
                    .body("""
                    <html>
                    <body>
                    <h1>Inscription confirmée</h1>

                    <p>
                    Votre inscription au cours est validée.
                    </p>

                    <a href="%s">
                    Télécharger votre confirmation PDF
                    </a>

                    </body>
                    </html>
                    """.formatted(pdfUrl))
                    .build();


            emailProducer.accept(List.of(event));
        }
    }
