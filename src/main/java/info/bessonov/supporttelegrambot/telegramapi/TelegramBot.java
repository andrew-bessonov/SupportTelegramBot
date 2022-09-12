package info.bessonov.supporttelegrambot.telegramapi;

import info.bessonov.supporttelegrambot.utils.PropertyValues;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {
    private final PropertyValues propertyValues;

    @Override
    public String getBotUsername() {
        return propertyValues.getBotName();
    }

    @Override
    public String getBotToken() {
        return propertyValues.getBotToken();
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            innerMessage(update.getMessage());
        }
    }

    @SneakyThrows
    private void innerMessage(Message message) {
        if ("/start".equals(message.getText())) {
            execute(SendMessage.builder()
                    .chatId(message.getChatId())
                    .text("Здравствуйте, какой у вас вопрос?")
                    .build());
        }
    }
}
