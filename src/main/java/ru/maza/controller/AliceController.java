package ru.maza.controller;

import ru.maza.model.AliceMessageIn;
import ru.maza.model.AliceMessageOut;
import ru.maza.service.AliceSkillMessageListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/alice")
@RequiredArgsConstructor
@Slf4j
public class AliceController {

    private final AliceSkillMessageListener alice;

    @PostMapping
    public AliceMessageOut onMessage(@RequestBody AliceMessageIn message) {
        log.info(message.toString());
        return alice.onMessage(message);
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

}
