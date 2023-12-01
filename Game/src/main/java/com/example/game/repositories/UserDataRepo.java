package com.example.game.repositories;

import com.example.game.models.UserData;
import jakarta.transaction.Transactional;
import org.hibernate.result.Output;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserDataRepo extends JpaRepository<UserData, Void> {
    @Query(value = "EXEC signIn :login, :password, :res OUTPUT;", nativeQuery = true)
    int signIn(@Param("login") String login, @Param("password") String password, int res);

    //@Procedure("signIn")
    //@Transactional
    //public int signIn(String login, String password);

}
