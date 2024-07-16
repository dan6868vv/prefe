package com.knf.dev.demo.controller;

import com.knf.dev.demo.dto.GameCreatingDto;
import com.knf.dev.demo.dto.LayoutOfCardCreationDto;
import com.knf.dev.demo.repository.GameRepository;
import com.knf.dev.demo.repository.LayoutOfCardRepository;
import com.knf.dev.demo.service.GameService;
import com.knf.dev.demo.service.LayoutOfCardService;
import com.knf.dev.demo.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

@Controller
@RequestMapping("/game")
public class GameController {
    private static ArrayList<Long> playersId = new ArrayList<>();
    private final UserService userService;
    private final GameService gameService;
    private final GameRepository gameRepository;
    private final LayoutOfCardService layoutOfCardService;
    private final LayoutOfCardRepository layoutOfCardRepository;

    public GameController(UserService userService, GameService gameService, GameRepository gameRepository, LayoutOfCardService layoutOfCardService, LayoutOfCardRepository layoutOfCardRepository) {
        this.userService = userService;
        this.gameService = gameService;
        this.gameRepository = gameRepository;
        this.layoutOfCardService = layoutOfCardService;
        this.layoutOfCardRepository = layoutOfCardRepository;
    }
    public static boolean addPlayer(Long playerId) {
        if(playersId.contains(playerId)) {
            return false;
        }
        else {
            playersId.add(playerId);
            return true;
        }
    }
    @GetMapping("/find")
    public String find() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long userId = userService.findUserByEmail(auth.getName()).getId();
        GameController.addPlayer(userService.findUserByEmail(auth.getName()).getId());
//        playersId.add(userService.findUserByEmail(auth.getName()).getId());
        if(gameService.isInGame(userId)){
            Long userId1 = gameRepository.gameByUserId(userId).getId1();
            Long userId2 = gameRepository.gameByUserId(userId).getId2();
            return "redirect:/game/play-"+userId1+"-"+userId2;
        }
        if(playersId.size() % 2 == 0 && !gameService.isInGame(userService.findUserByEmail(auth.getName()).getId())) {
            GameCreatingDto gameCreatingDto = new GameCreatingDto(playersId.get(playersId.size()-1) ,
                    playersId.get(playersId.size()-2) ,true,true,false,0,0);
            System.out.println("Users ID " + gameCreatingDto.getId1()+" "+gameCreatingDto.getId2());
            gameService.saveGame(gameCreatingDto);
            return "redirect:/game/play-"+playersId.get(playersId.size()-1) + "-" + playersId.get(playersId.size()-2);//game/play-id1-id2
        } else if ((  playersId.size() % 2 == 0 && gameService.isInGame(userService.findUserByEmail(auth.getName()).getId()) &&
                layoutOfCardRepository.getLOCByUserGameId(userService.findUserByEmail(auth.getName()).getId(),
                        gameRepository.getGameIdByUserId(userService.findUserByEmail(auth.getName()).getId()))==null)) {
            return "redirect:/game/play-"+playersId.get(playersId.size()-1) + "-" + playersId.get(playersId.size()-2);

        }
        System.out.println(playersId);
        return "game/find";
    }
//(  playersId.size() % 2 == 0 && gameService.isInGame(userService.findUserByEmail(auth.getName()).getId()) &&
//            layoutOfCardRepository.getLOCByUserGameId(userService.findUserByEmail(auth.getName()).getId(),
//                                gameRepository.getGameIdByUserId(userService.findUserByEmail(auth.getName()).getId()))==null)
    @GetMapping("/play-{id1}-{id2}")
    public String playId1Id2(@PathVariable Long id1, @PathVariable Long id2, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long userId = userService.findUserByEmail(auth.getName()).getId();

        model.addAttribute("userId",userService.findUserByEmail(auth.getName()).getId());
        model.addAttribute("cars",gameService.getCards());
        if(gameRepository.getGameIdByUsersId(id1,id2)!=null) {
            if (gameService.isInGame(userId) &&
                    layoutOfCardRepository.getLOCByUserGameId(userId, gameRepository.getGameIdByUserId(userId)) == null) {

                LayoutOfCardCreationDto layoutOfCardCreationDto = new LayoutOfCardCreationDto(
                        userService.findUserByEmail(auth.getName()).getId(),
                        gameRepository.getGameIdByUserId(userService.findUserByEmail(auth.getName()).getId()),
                        copyToArrayListString(shuffleCard(gameService.getCards()), 0, 10));

                layoutOfCardService.save(layoutOfCardCreationDto);
            }
            model.addAttribute("cardsUser1", layoutOfCardService.getArrayListStringByLOC(layoutOfCardRepository.getLOCByUserGameId(
                    userId, gameRepository.getGameIdByUserId(userId))
            ));
//        model.addAttribute("cardsUser1",copyToArrayListString(shuffleCard(gameService.getCards()),
//                0,10));
            model.addAttribute("cardsUser2", copyToArrayListString(shuffleCard(gameService.getCards()),
                    10, 10));
            model.addAttribute("talonUser1", copyToArrayListString(shuffleCard(gameService.getCards()),
                    20, 2));
            model.addAttribute("talonUser2", copyToArrayListString(shuffleCard(gameService.getCards()),
                    22, 2));
            model.addAttribute("shuffledCard", shuffleCard(gameService.getCards()));
            System.out.println(gameService.getRandomCardOrder());
            System.out.println(shuffleCard(gameService.getCards()));
            System.out.println("Количество карт" + copyToArrayListString(shuffleCard(gameService.getCards()),
                    0, 10).size() + "First user cards: " + copyToArrayListString(shuffleCard(gameService.getCards()),
                    0, 10));
            System.out.println("Second user cards: " + copyToArrayListString(shuffleCard(gameService.getCards()),
                    10, 10));
            System.out.println("Talon first user: " + copyToArrayListString(shuffleCard(gameService.getCards()),
                    20, 2));

            return "game/playUsers";
//        }
//        else{
////            return "redirect:/game/play-"+id1+"-"+id2;
//            return "game/playUsers";
//        }
        }
        else{
            return "redirect:/";
        }
    }

    private ArrayList<Integer> copyToArrayListInteger(ArrayList<Integer> oldList,int startOld,
                                               int amountOfNumber ) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=startOld;i<amountOfNumber+1;i++) {
            list.add(oldList.get(i));
        }
        return list;
    }  private ArrayList<String> copyToArrayListString(ArrayList<String> oldList,int startOld,
                                               int amountOfNumber ) {

        ArrayList<String> list = new ArrayList<>();

        for(int i=startOld;i<amountOfNumber+startOld;i++) {
            list.add(oldList.get(i));
        }
        return list;
    }

    private ArrayList<String> shuffleCard(ArrayList<String> list) {
        Random rand = new Random();
        ArrayList<String> shuffledList = new ArrayList<>();
        shuffledList = list;
        for(int i=0;i<10000;i++){
            int number1 = rand.nextInt(999);
            int num1=number1 % 24;
            int number2 = rand.nextInt(999);
            int num2 = number2 % 24;
            Collections.swap(shuffledList,num1,num2);
        }
        return shuffledList;
    }
}
