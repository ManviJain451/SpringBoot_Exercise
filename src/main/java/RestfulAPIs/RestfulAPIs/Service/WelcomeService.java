package RestfulAPIs.RestfulAPIs.Service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

    public String getMessage(){
        return "Welcome to spring boot";
    }
}
