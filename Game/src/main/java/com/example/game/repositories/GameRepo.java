package com.example.game.repositories;

import com.example.game.models.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GameRepo extends JpaRepository<UserData, Void> {
    @Query(value = "EXEC AddScore :login, :score", nativeQuery = true)
    int AddScore(@Param("login") String login, @Param("score") int score);
}

