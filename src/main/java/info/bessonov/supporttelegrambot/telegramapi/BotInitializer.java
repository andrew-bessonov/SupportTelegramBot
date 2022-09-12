package info.bessonov.supporttelegrambot.telegramapi;

import info.bessonov.supporttelegrambot.utils.PropertyValues;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Slf4j
@Component
@RequiredArgsConstructor
public class BotInitializer {
    private final TelegramBot bot;
    private final PropertyValues propertyValues;

    @EventListener({ContextRefreshedEvent.class})
    public void init() throws TelegramApiException {
        if (!StringUtils.hasText(propertyValues.getBotName()) || !StringUtils.hasText(propertyValues.getBotToken())) {
            throw new IllegalArgumentException("Не заполнен BotName или BotToken");
        }

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            telegramBotsApi.registerBot(bot);
            log.info("Бот проинициализирован");
        } catch (TelegramApiRequestException e) {
            log.error(e.getMessage());
        }
    }
}
