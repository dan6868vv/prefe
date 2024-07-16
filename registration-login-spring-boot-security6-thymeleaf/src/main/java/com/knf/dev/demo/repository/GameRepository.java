package com.knf.dev.demo.repository;

import com.knf.dev.demo.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
//    @Query("SELECT g.id FROM Game g WHERE (g.id1 =:userId OR g.id2 =:userId ) AND g.isEnd=:false")
//    Long getGameIdByUserId(Long userId);
    @Query("SELECT g.id FROM Game g WHERE (g.id1 = :userId OR g.id2 = :userId) AND g.isEnd = false")
    Long getGameIdByUserId(Long userId);
    @Query("SELECT g.id FROM Game g WHERE (g.id1 = :userId1 OR g.id2 = :userId1) AND (g.id1 = :userId2 OR g.id2 = :userId2) AND g.isEnd = false")
    Long getGameIdByUsersId(Long userId1,Long userId2);
    @Query("SELECT g FROM Game g WHERE (g.id1 = :userId OR g.id2 = :userId) AND g.isEnd = false")
    Game gameByUserId(Long userId);
}
