package com.jlab.shoppingmall.controller;

import com.jlab.shoppingmall.domain.User;
import com.jlab.shoppingmall.dto.request.JoinForm;
import com.jlab.shoppingmall.dto.request.UpdateForm;
import com.jlab.shoppingmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping
    public ResponseEntity<Long> join(@RequestBody JoinForm joinForm){
        Long userId = userService.createUser(joinForm);

        return ResponseEntity.ok(userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user = userService.getUser(id);

        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateUser(@PathVariable Long id, @RequestBody UpdateForm updateForm){
        Long userId = userService.updateUser(id, updateForm);

        return ResponseEntity.ok(userId);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok(id+"유저가 삭제되었습니다.");

    }

}
