package nicomed.resliv.telegrambot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
//@PropertySource("classpath:application.properties")
@Configuration
public class BotConfig {

    @Value("${bot.token}")
    private String TOKEN;
    @Value("${bot.name}")
    private String USERNAME;

}
