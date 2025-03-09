package ResfulAPIsPart2.Controller;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class UserNameController {
    private MessageSource messageSource;

    public UserNameController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @GetMapping("/user-internationalize")
        public String getUserNameInternationalized(@RequestParam String name){
        Locale locale = LocaleContextHolder.getLocale();
            return messageSource.getMessage("hello.message", new Object[] {name}, "Default Message", locale);
//            return "Hello " + userNameService.getUserName(name);
        }
}
