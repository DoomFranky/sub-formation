package hei.school.inscription.endpoint.rest.controller.health;

import hei.school.inscription.Entity.Users;
import hei.school.inscription.endpoint.event.EventProducer;
import hei.school.inscription.endpoint.event.model.SendEmailRequested;
import hei.school.inscription.mail.Email;
import hei.school.inscription.mail.Mailer;
import hei.school.inscription.service.event.SubscribeService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/subscribe")
public class SubscribeController {
    private final SubscribeService subscribeService;
    private final EventProducer<SendEmailRequested> subscribeEventProducer;
@PostMapping("/")
@SneakyThrows
    public String subscribe(@RequestParam String to, @RequestParam UUID idUser,@RequestParam UUID idCourse) {
    subscribeService.addUserToCourse(idUser, idCourse);
    var event = SendEmailRequested.builder().to(to).build();
    subscribeEventProducer.accept(List.of(event));

    return """
            <html>
            <body>
            
            <h1>Confirmation d'inscription</h1>
            
            <p>Bonjour,</p>
            
            <p>
                Votre inscription au cours a bien été enregistrée.
            </p>
            
            <p>
                Vous pouvez télécharger votre attestation de confirmation ici :
            </p>
            
            <p>
                <a href="https://ton-bucket.s3.amazonaws.com/confirmation.pdf">
                    Télécharger la confirmation d'inscription (PDF)
                </a>
            </p>
            
            <p>
                Merci pour votre confiance.
            </p>
            
            <p>
                L'équipe de formation
            </p>
            
            </body>
            </html>
            """;
}
}
