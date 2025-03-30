package at.hochschule.umzug;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UmzugController {

    @PostMapping("/umzug")
    public String createRequest(@RequestBody MovingRequest movingRequest) {
        return "";
    }
}
