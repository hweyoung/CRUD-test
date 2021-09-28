package com.jlab.shoppingmall.dto.request;

import com.jlab.shoppingmall.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class JoinForm {

    private String userName;
    private String pwd;

    public User toEntity(){
        return User.builder()
                .userName(userName)
                .pwd(pwd)
                .build();
    }
}
