package com.jlab.shoppingmall.domain;

import com.jlab.shoppingmall.dto.request.UpdateForm;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String pwd;

    @Builder
    public User(String userName, String pwd){
        this.userName=userName;
        this.pwd=pwd;
    }


    public void update(String userName, String pwd){
        this.userName = userName;
        this.pwd=pwd;
    }

}
