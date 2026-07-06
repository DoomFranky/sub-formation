package hei.school.inscription.service.validator;

import jakarta.ws.rs.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailValidator {
    public void validEmail(String email) {
        Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");
        Matcher m = p.matcher(email);
        if (!m.find()) {
            throw new BadRequestException("email format is not respected");
        }
    }
}
