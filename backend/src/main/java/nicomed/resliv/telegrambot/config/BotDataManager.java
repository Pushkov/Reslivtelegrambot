package nicomed.resliv.telegrambot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Service
@ConditionalOnProperty(name = "bot.manager.enable", havingValue = "true", matchIfMissing = false)
public @interface BotDataManager {
}
