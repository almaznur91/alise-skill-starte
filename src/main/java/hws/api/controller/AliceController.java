package hws.api.controller;

import hws.api.model.AliceMessageIn;
import hws.api.model.AliceMessageOut;
import hws.api.service.AliceSkillMessageListener;
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
