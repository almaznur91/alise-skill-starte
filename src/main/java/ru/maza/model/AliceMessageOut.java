package ru.maza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AliceMessageOut implements Serializable {

    private AliceResponse response;

    private Session session;

    private String version;


    @Override
    public String toString() {
        return "AliceMessageOut{" +
                "response=" + response +
                ", session=" + session +
                ", version='" + version + '\'' +
                '}';
    }
}
