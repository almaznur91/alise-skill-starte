package hws.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AliceRequest implements Serializable {

    private Type type;

    private String command;

    @JsonProperty("original_utterance")
    private String originalUtterance;

    @Override
    public String toString() {
        return "AliceRequest{" +
                "type=" + type +
                ", command='" + command + '\'' +
                ", originalUtterance='" + originalUtterance + '\'' +
                '}';
    }
}
