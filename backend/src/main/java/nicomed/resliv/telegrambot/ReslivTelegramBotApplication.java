package nicomed.resliv.telegrambot;

import nicomed.telegram.botcommandmod.BotCommandMod;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(BotCommandMod.class)
@SpringBootApplication
public class ReslivTelegramBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReslivTelegramBotApplication.class, args);
    }
}
