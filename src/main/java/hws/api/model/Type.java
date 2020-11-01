package hws.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Type {
    @JsonProperty("SimpleUtterance")
    SIMPLE_UTTERANCE,
    @JsonProperty("ButtonPressed")
    BUTTON_PRESSED
}
