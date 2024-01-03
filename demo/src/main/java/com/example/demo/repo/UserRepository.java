package com.example.demo.repo;

import com.example.demo.Models.UserModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Long>{
    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<UserModel>findAllUsers();
    @Query(value = "SELECT * FROM users WHERE user_id = :id", nativeQuery = true)
    UserModel findUserById(@Param("id")Long id);
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users (name, email, password) VALUES (:name, :email, :password)", nativeQuery = true)
    void createUserQuery(@Param("name") String name, @Param("email") String email, @Param("password") String password);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET name = :name, email = :email, password = :password WHERE user_id = :id", nativeQuery = true)
    void editAllUserQuery(@Param("name") String name, @Param("email") String email, @Param("password") String password, @Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users WHERE user_id = :id", nativeQuery = true)
    void deleteUserQuery(@Param("id") Long id);


}
