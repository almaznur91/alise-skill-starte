package ru.maza.service.impl;

import ru.maza.model.AliceMessageIn;
import ru.maza.model.AliceMessageOut;
import ru.maza.model.AliceResponse;
import ru.maza.service.AliceSkillMessageListener;
import ru.maza.system.AliceSession;
import ru.maza.system.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class AliceSkillMessageListenerBean implements AliceSkillMessageListener {

    private final AliceSession session;

    private static final String[] DAYS = new String[]{
            "Понедельник",
            "Вторник",
            "Среда",
            "Четверг",
            "Пятница",
            "Суббота",
            "Воскресенье"
    };

    @Override
    public AliceMessageOut onMessage(AliceMessageIn message) {
        final String answer = handle(message);
        AliceMessageOut dto = new AliceMessageOut();
        dto.setSession(message.getSession());
        dto.setVersion(message.getVersion());
        AliceResponse response = new AliceResponse();
        dto.setResponse(response);
        response.setEndSession(true);
        response.setText(answer);
        return dto;
    }

    private String handle(AliceMessageIn message) {
        final String sid = message.getSession().getSessionId();
        State state = session.get(sid);
        if (state == null) {
            state = new State();
        }
        final String command = message.getRequest().getCommand();
        state.command(command);
        session.save(sid, state);
        if (command.equalsIgnoreCase("история")) {
            return String.join("; ", state.getHistory());
        }
        return String.format(
                "Астрологи объявили, что на этот раз днём узбечки будет %s!",
                getRandomDayOfWorkWeek()
        );
    }

    private String getRandomDayOfWorkWeek() {
        return DAYS[new Random().nextInt(5)];
    }
}
