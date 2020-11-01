package ru.maza.system;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;

@Data
@NoArgsConstructor
public class State implements Serializable {

    private List<String> history = new ArrayList<>();

    public void command(String s) {
        history.add(s);
    }
}
