package at.hochschule.umzug;

import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UmzugController {
    @Getter
    static List<MovingRequest> movingRequests = new ArrayList<>();

    @PostMapping("/umzug")
    public ResponseEntity<Map<String, String>> createRequest(@RequestBody MovingRequest movingRequest) {
        if (movingRequest == null ||
                isEmpty(movingRequest.getName()) ||
                isEmpty(movingRequest.getTime()) ||
                isEmpty(movingRequest.getOrigin()) ||
                isEmpty(movingRequest.getDestination()) ||
                isEmpty(movingRequest.getItem()) ||
                isEmpty(movingRequest.getAmount())) {

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "All fields are required");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        movingRequests.add(movingRequest);
        Map<String, String> successResponse = new HashMap<>();
        successResponse.put("message", "Request saved successfully");
        return ResponseEntity.ok(successResponse);
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
