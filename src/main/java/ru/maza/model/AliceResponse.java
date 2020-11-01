package ru.maza.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AliceResponse implements Serializable {

    private String text;

    private String tts;

    @JsonProperty("end_session")
    private boolean endSession;

    @Override
    public String toString() {
        return "AliceResponse{" +
                "text='" + text + '\'' +
                ", tts='" + tts + '\'' +
                ", endSession=" + endSession +
                '}';
    }
}
