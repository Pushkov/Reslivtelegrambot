package nicomed.resliv.telegrambot.bot.flag;

public interface CommandFlagService {


    boolean isFlag();

    CommandFlag getFlag();

    void setFlag(CommandFlag flag);

    void clearFlag();

    String process(String text);

}
