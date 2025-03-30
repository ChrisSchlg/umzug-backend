package at.hochschule.umzug;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovingRequest {
    @JsonProperty("name")
    String name;

    @JsonProperty("time")
    String time;

    @JsonProperty("origin")
    String origin;

    @JsonProperty("destination")
    String destination;

    @JsonProperty("item")
    String item;

    @JsonProperty("amount")
    String amount;
}
