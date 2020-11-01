package hws.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session implements Serializable {

    @JsonProperty("new")
    private Boolean isNew;

    @JsonProperty("session_id")
    private String sessionId;

    @JsonProperty("message_id")
    private Long messageId;

    @JsonProperty("skill_id")
    private String skillId;

    @JsonProperty("user_id")
    private String userId;

    @Override
    public String toString() {
        return "Session{" +
                "isNew=" + isNew +
                ", sessionId='" + sessionId + '\'' +
                ", messageId=" + messageId +
                ", skillId='" + skillId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
