package com.knf.dev.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="layout_of_card")
public class LayoutOfCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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


    private String stockCardOne;
    private String stockCardTwo;
    public LayoutOfCard(Long userId,Long gameId, String firstCard, String secondCard, String thirdCard,
                        String fourthCard, String fifthCard, String sixthCard, String seventhCard,
                        String eighthCard, String ninthCard, String tenthCard,String stockCardOne,String stockCardTwo) {
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
        this.stockCardOne = stockCardOne;
        this.stockCardTwo = stockCardTwo;
    }

    public LayoutOfCard() {}

    public String getStockCardOne() {
        return stockCardOne;
    }

    public void setStockCardOne(String stockCardOne) {
        this.stockCardOne = stockCardOne;
    }

    public String getStockCardTwo() {
        return stockCardTwo;
    }

    public void setStockCardTwo(String stockCardTwo) {
        this.stockCardTwo = stockCardTwo;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
