package hws.api.service;

import hws.api.model.AliceMessageIn;
import hws.api.model.AliceMessageOut;

public interface AliceSkillMessageListener {

    AliceMessageOut onMessage(AliceMessageIn message);
}
