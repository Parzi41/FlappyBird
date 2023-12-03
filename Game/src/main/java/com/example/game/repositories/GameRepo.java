package com.example.game.repositories;

import com.example.game.models.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<UserData, Void> {
}

