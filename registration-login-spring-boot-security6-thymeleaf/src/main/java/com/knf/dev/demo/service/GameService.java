package com.knf.dev.demo.service;

import com.knf.dev.demo.dto.GameCreatingDto;
import com.knf.dev.demo.entity.Game;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface GameService {
    Game saveGame(GameCreatingDto gameCreatingDto);
    ArrayList<String> getCards();
    ArrayList<Integer> getRandomCardOrder();
//    Long getGameIdByUserId(Long userId);
    boolean isInGame(Long userId);
}
