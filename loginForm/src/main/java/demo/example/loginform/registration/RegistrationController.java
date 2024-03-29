package demo.example.loginform.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/c1/registration")
@AllArgsConstructor
public class RegistrationController {
    /**
     *
     */
    private final ThreadLocal<RegistrationService> registrationService = new ThreadLocal<RegistrationService>();
    public String register(@RequestBody RegistrationRequest request ){
        return registrationService.get().register(request);
    }
}
