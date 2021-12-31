package nicomed.resliv.telegrambot.bot.command;

import nicomed.telegram.botcommandmod.annotation.BotModCommand;
import nicomed.telegram.botcommandmod.command.BaseBotCommand;

@BotModCommand
public class CityCommand extends BaseBotCommand {

    public CityCommand() {
        super("command", "description");
    }

    @Override
    public String getMessageText() {
        return null;
    }

    @Override
    public String getMessageText(String text) {
        return null;
    }
}
