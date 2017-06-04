package com.example.web;

import lombok.Data;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.validator.NumberValid;



@Data

public class LunchUserMasterForm {

//    @NotNull
//
//    @Size(min = 1, max = 127)
//
//    private Integer id_user;

    @NotNull

    @Size(min = 1, max = 16)
    
    @Pattern(regexp="^[A-Za-z0-9_.]+$",message = "半角英数字で入力してください")

    @NumberValid
    private String username;

}