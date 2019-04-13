package pl.bykowski.springbooti18n;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class TextApi {

    private MessageSource messageSource;

    @Autowired
    public TextApi(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/polski")
    public String getPL() {
        return messageSource.getMessage("hello", null, Locale.forLanguageTag("PL"));
    }

    @GetMapping("/angielski")
    public String getEN() {
        return messageSource.getMessage("hello", null, Locale.ENGLISH);
    }

    @GetMapping("/niemiecki")
    public String getDE() {
        return messageSource.getMessage("hello", null, Locale.GERMAN);
    }


    @GetMapping("/sayHello")
    public String sayHello(@RequestHeader(defaultValue = "PL", required = false) String language,
                           @RequestParam String name,
                           @RequestParam String surname) {
        return messageSource.getMessage("hello", new Object[]{name, surname}, Locale.forLanguageTag(language));
    }

}
