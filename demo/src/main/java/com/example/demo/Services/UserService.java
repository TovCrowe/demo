package com.example.demo.Services;
import com.example.demo.Models.UserModel;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;


        public List<UserModel> findAllUsers(){
            return userRepository.findAllUsers();
        }
        public UserModel findUserById(Long id){
            return userRepository.findUserById(id);

        }
        public void createUserService(UserModel user){
            userRepository.createUserQuery(user.getName(), user.getEmail(), user.getPassword());
        }
        public void editAllUserService(UserModel userEdit, Long id){
            userRepository.editAlluserQuery(userEdit.getName(), userEdit.getEmail(), userEdit.getPassword(), id);

        }
        public void deleteUserById(Long id){
            userRepository.deleteUserQuery(id);
        }
}