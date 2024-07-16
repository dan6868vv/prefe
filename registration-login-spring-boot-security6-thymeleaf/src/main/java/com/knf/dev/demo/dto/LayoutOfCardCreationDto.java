package com.knf.dev.demo.dto;

import java.util.ArrayList;

public class LayoutOfCardCreationDto {
    private Long userId;
    private Long gameId;
    private String firstCard;
    private String secondCard;
    private String thirdCard;
    private String fourthCard;
    private String fifthCard;
    private String sixthCard;
    private String seventhCard;
    private String eighthCard;
    private String ninthCard;
    private String tenthCard;

    public LayoutOfCardCreationDto(Long userId, Long gameId, String firstCard, String secondCard,
                                   String thirdCard, String fourthCard, String fifthCard,
                                   String sixthCard, String seventhCard, String eighthCard,
                                   String ninthCard, String tenthCard) {
        this.userId = userId;
        this.gameId = gameId;
        this.firstCard = firstCard;
        this.secondCard = secondCard;
        this.thirdCard = thirdCard;
        this.fourthCard = fourthCard;
        this.fifthCard = fifthCard;
        this.sixthCard = sixthCard;
        this.seventhCard = seventhCard;
        this.eighthCard = eighthCard;
        this.ninthCard = ninthCard;
        this.tenthCard = tenthCard;
    }
    public LayoutOfCardCreationDto(Long userId,Long gameId, ArrayList<String> cardList){
        this.userId = userId;
        this.gameId = gameId;
        this.firstCard = cardList.get(0);
        this.secondCard = cardList.get(1);
        this.thirdCard = cardList.get(2);
        this.fourthCard = cardList.get(3);
        this.fifthCard = cardList.get(4);
        this.sixthCard = cardList.get(5);
        this.seventhCard = cardList.get(6);
        this.eighthCard = cardList.get(7);
        this.ninthCard = cardList.get(8);
        this.tenthCard = cardList.get(9);

    }
    public LayoutOfCardCreationDto() {}
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getFirstCard() {
        return firstCard;
    }

    public void setFirstCard(String firstCard) {
        this.firstCard = firstCard;
    }

    public String getSecondCard() {
        return secondCard;
    }

    public void setSecondCard(String secondCard) {
        this.secondCard = secondCard;
    }

    public String getThirdCard() {
        return thirdCard;
    }

    public void setThirdCard(String thirdCard) {
        this.thirdCard = thirdCard;
    }

    public String getFourthCard() {
        return fourthCard;
    }

    public void setFourthCard(String fourthCard) {
        this.fourthCard = fourthCard;
    }

    public String getFifthCard() {
        return fifthCard;
    }

    public void setFifthCard(String fifthCard) {
        this.fifthCard = fifthCard;
    }

    public String getSixthCard() {
        return sixthCard;
    }

    public void setSixthCard(String sixthCard) {
        this.sixthCard = sixthCard;
    }

    public String getSeventhCard() {
        return seventhCard;
    }

    public void setSeventhCard(String seventhCard) {
        this.seventhCard = seventhCard;
    }

    public String getEighthCard() {
        return eighthCard;
    }

    public void setEighthCard(String eighthCard) {
        this.eighthCard = eighthCard;
    }

    public String getNinthCard() {
        return ninthCard;
    }

    public void setNinthCard(String ninthCard) {
        this.ninthCard = ninthCard;
    }

    public String getTenthCard() {
        return tenthCard;
    }

    public void setTenthCard(String tenthCard) {
        this.tenthCard = tenthCard;
    }
}
