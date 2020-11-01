package ru.maza.controller;

import ru.maza.system.AliceSession;
import ru.maza.system.State;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("/ping")
@RequiredArgsConstructor
public class HealthController {

    private final AliceSession session;

    @GetMapping
    public String pong() {
        return "pong";
    }

    @PostMapping
    public State pong(@RequestBody PingRequest req) {
        final String next = req.getNext();
        final String sid = req.getSid();
        State state = session.get(sid);
        if (state == null) {
            state = new State();
        }
        state.command(next);
        session.save(sid, state);
        return state;
    }

    @Data
    @NoArgsConstructor
    public static class PingRequest implements Serializable {

        private String next;

        private String sid;

    }
}