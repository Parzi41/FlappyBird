package com.example.game.service;

import com.example.game.repositories.UserDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDataRepo userDataRepo;

    @Autowired
    public UserService(UserDataRepo userDataRepo) {
        this.userDataRepo = userDataRepo;
    }

    public int signIn(String login, String password) {
        int result = -1;

        return userDataRepo.signIn(login, password, result);

        //System.out.println(result);

        //userDataRepo.sign_in(login, password, result);

        //return result;
    }
}