package info.bessonov.supporttelegrambot.utils;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PropertyValues {
    @Value("${telegrambot.name}")
    private String botName;
    @Value("${telegrambot.token}")
    private String botToken;
}
