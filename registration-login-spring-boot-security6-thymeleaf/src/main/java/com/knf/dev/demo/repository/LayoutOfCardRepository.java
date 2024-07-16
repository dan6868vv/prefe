package com.knf.dev.demo.repository;

import com.knf.dev.demo.entity.LayoutOfCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LayoutOfCardRepository extends JpaRepository<LayoutOfCard, Long> {
    @Query("SELECT g FROM LayoutOfCard g WHERE g.userId=:userId AND g.gameId=:gameId")
    LayoutOfCard getLOCByUserGameId(Long userId,Long gameId);
}
