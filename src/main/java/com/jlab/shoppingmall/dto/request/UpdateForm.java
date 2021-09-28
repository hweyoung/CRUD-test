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
public class UpdateForm {

    private String userName;
    private String pwd;

}
