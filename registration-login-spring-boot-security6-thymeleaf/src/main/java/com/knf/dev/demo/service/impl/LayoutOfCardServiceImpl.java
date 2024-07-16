package com.knf.dev.demo.service.impl;

import com.knf.dev.demo.dto.LayoutOfCardCreationDto;
import com.knf.dev.demo.entity.LayoutOfCard;
import com.knf.dev.demo.repository.LayoutOfCardRepository;
import com.knf.dev.demo.service.LayoutOfCardService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LayoutOfCardServiceImpl implements LayoutOfCardService {
    private final LayoutOfCardRepository layoutOfCardRepository;

    public LayoutOfCardServiceImpl(LayoutOfCardRepository layoutOfCardRepository) {
        this.layoutOfCardRepository = layoutOfCardRepository;
    }

    @Override
    public LayoutOfCard save(LayoutOfCardCreationDto layoutOfCardCreationDto) {
        var layoutOfCard = new LayoutOfCard(layoutOfCardCreationDto.getUserId(), layoutOfCardCreationDto.getGameId(),
                layoutOfCardCreationDto.getFirstCard(), layoutOfCardCreationDto.getSecondCard(),
                layoutOfCardCreationDto.getThirdCard(), layoutOfCardCreationDto.getFourthCard(),
                layoutOfCardCreationDto.getFifthCard(), layoutOfCardCreationDto.getSixthCard(),
                layoutOfCardCreationDto.getSeventhCard(), layoutOfCardCreationDto.getEighthCard(),
                layoutOfCardCreationDto.getNinthCard(), layoutOfCardCreationDto.getTenthCard());
        return layoutOfCardRepository.save(layoutOfCard);
    }

    @Override
    public ArrayList<String> getArrayListStringByLOC(LayoutOfCard layoutOfCard) {
        ArrayList<String> list = new ArrayList<>();
        list.add(layoutOfCard.getFirstCard());
        list.add(layoutOfCard.getSecondCard());
        list.add(layoutOfCard.getThirdCard());
        list.add(layoutOfCard.getFourthCard());
        list.add(layoutOfCard.getFifthCard());
        list.add(layoutOfCard.getSixthCard());
        list.add(layoutOfCard.getSeventhCard());
        list.add(layoutOfCard.getEighthCard());
        list.add(layoutOfCard.getNinthCard());
        list.add(layoutOfCard.getTenthCard());
        return list;
    }
}
