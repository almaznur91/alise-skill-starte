package ru.maza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AliceMessageIn implements Serializable {

    private AliceRequest request;

    private Session session;

    private String version;
    @Override
    public String toString() {
        return "AliceMessageIn{" +
                "request=" + request +
                ", session=" + session +
                ", version='" + version + '\'' +
                '}';
    }
}
