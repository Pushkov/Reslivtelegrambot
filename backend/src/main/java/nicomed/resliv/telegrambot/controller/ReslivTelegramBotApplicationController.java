package nicomed.resliv.telegrambot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ReslivTelegramBotApplicationController {

    @GetMapping({"/", "/cities", "/about"})
    public String getIndexPage() {
        return "index";
    }
}
