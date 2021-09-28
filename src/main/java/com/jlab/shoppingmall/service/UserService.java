package com.jlab.shoppingmall.service;

import com.jlab.shoppingmall.domain.User;
import com.jlab.shoppingmall.domain.UserRepository;
import com.jlab.shoppingmall.dto.request.JoinForm;
import com.jlab.shoppingmall.dto.request.UpdateForm;
import com.jlab.shoppingmall.dto.response.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("찾는 유저가 없습니다."));
        return user;
    }

    @Transactional
    public Long createUser(JoinForm joinForm){
        User request = joinForm.toEntity();

        User newUser = userRepository.save(request);
        return newUser.getId();
    }
    @Transactional
    public Long updateUser(Long id, UpdateForm updateForm){
        User user = userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("찾는 유저가 없습니다."));

        user.update(updateForm.getUserName(), updateForm.getPwd());

        return user.getId();
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("찾는 유저가 없습니다."));

        userRepository.delete(user);
    }
}
