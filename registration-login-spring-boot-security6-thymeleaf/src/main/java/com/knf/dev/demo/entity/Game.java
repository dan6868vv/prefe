package com.knf.dev.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long id1;
    private long id2;

    private boolean isReady1;
    private boolean isReady2;

    private boolean isEnd=false;

    private int userPrize1=0;
    private int userPrize2=0;

    public Game(long id1, long id2, boolean isReady1, boolean isReady2, boolean isEnd, int userPrize1, int userPrize2) {
        this.id1 = id1;
        this.id2 = id2;
        this.isReady1 = isReady1;
        this.isReady2 = isReady2;
        this.isEnd = isEnd;
        this.userPrize1 = userPrize1;
        this.userPrize2 = userPrize2;
    }
    public Game() {}

    public long getId1() {
        return id1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setId1(long id1) {
        this.id1 = id1;
    }

    public long getId2() {
        return id2;
    }

    public void setId2(long id2) {
        this.id2 = id2;
    }

    public boolean isReady1() {
        return isReady1;
    }

    public void setReady1(boolean ready1) {
        isReady1 = ready1;
    }

    public boolean isReady2() {
        return isReady2;
    }

    public void setReady2(boolean ready2) {
        isReady2 = ready2;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public int getUserPrize1() {
        return userPrize1;
    }

    public void setUserPrize1(int userPrize1) {
        this.userPrize1 = userPrize1;
    }

    public int getUserPrize2() {
        return userPrize2;
    }

    public void setUserPrize2(int userPrize2) {
        this.userPrize2 = userPrize2;
    }
}
