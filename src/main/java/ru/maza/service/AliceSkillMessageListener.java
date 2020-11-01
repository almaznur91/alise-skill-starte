package ru.maza.service;

import ru.maza.model.AliceMessageIn;
import ru.maza.model.AliceMessageOut;

public interface AliceSkillMessageListener {

    AliceMessageOut onMessage(AliceMessageIn message);
}
