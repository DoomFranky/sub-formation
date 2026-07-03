package hei.school.inscription.endpoint.event.model;
import java.time.Duration;

import hei.school.inscription.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class SendEmailRequested extends PojaEvent {
    private UserDto userDto;

    @Override
    public Duration maxConsumerDuration() {
        return Duration.ofSeconds(45);
    }

    @Override
    public Duration maxConsumerBackoffBetweenRetries() {
        return Duration.ofSeconds(30);
    }
}