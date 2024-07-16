package com.knf.dev.demo.service.impl;

import com.knf.dev.demo.controller.GameController;
import com.knf.dev.demo.dto.GameCreatingDto;
import com.knf.dev.demo.entity.Game;
import com.knf.dev.demo.repository.GameRepository;
import com.knf.dev.demo.service.GameService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    @Override
    public Game saveGame(GameCreatingDto gameCreatingDto) {
        var Game = new Game(gameCreatingDto.getId1(), gameCreatingDto.getId2(),gameCreatingDto.isReady1(),
                gameCreatingDto.isReady2(),gameCreatingDto.isEnd(),gameCreatingDto.getUserPrize1(),
                gameCreatingDto.getUserPrize2());
        return gameRepository.save(Game);
    }


//    private ArrayList<String> cards= new ArrayList<>();
    @Override
    public ArrayList<String> getCards() {
        ArrayList<String> cards= new ArrayList<>();
//        cards.add("8-Clubs");
//        cards.add("8-Diamonds");
//        cards.add("8-Hearts");
//        cards.add("8-Spades");
        cards.add("9-Clubs");
        cards.add("9-Diamonds");
        cards.add("9-Hearts");
        cards.add("9-Spades");
        cards.add("10-Clubs");
        cards.add("10-Diamonds");
        cards.add("10-Hearts");
        cards.add("10-Spades");
        cards.add("Jack-Clubs");
        cards.add("Jack-Diamonds");
        cards.add("Jack-Hearts");
        cards.add("Jack-Spades");
        cards.add("Queen-Clubs");
        cards.add("Queen-Diamonds");
        cards.add("Queen-Hearts");
        cards.add("Queen-Spades");
        cards.add("King-Clubs");
        cards.add("King-Diamonds");
        cards.add("King-Hearts");
        cards.add("King-Spades");
        cards.add("Ace-Clubs");
        cards.add("Ace-Diamonds");
        cards.add("Ace-Hearts");
        cards.add("Ace-Spades");
        return cards;
    }

    @Override
    public ArrayList<Integer> getRandomCardOrder() {
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int number = rand.nextInt(999);
        int num=number % 24;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(num);
        while(list.size()!=24) {
            number = rand.nextInt(999);
            num=number % 24;
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        return list;
    }

    @Override
    public boolean isInGame(Long userId) {
        System.out.println(gameRepository.getGameIdByUserId(userId));
        return gameRepository.getGameIdByUserId(userId) != null;
    }


}
