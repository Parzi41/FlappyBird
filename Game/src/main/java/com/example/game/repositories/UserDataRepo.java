package com.example.game.repositories;

import com.example.game.models.UserData;
import org.springframework.data.repository.CrudRepository;

public interface UserDataRepo extends CrudRepository<UserData, Long> {
}
