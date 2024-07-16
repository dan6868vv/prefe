package com.knf.dev.demo.service;

import com.knf.dev.demo.dto.LayoutOfCardCreationDto;
import com.knf.dev.demo.entity.LayoutOfCard;

import java.util.ArrayList;

public interface LayoutOfCardService {
    LayoutOfCard save(LayoutOfCardCreationDto layoutOfCardCreationDto);
    ArrayList<String> getArrayListStringByLOC(LayoutOfCard layoutOfCard);
    boolean isExistGame(Long gameId);
}
