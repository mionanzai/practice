package com.example.web;

import lombok.Data;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Data

public class LunchUserStatusForm {

//    @NotNull
//
//    @Size(min = 1, max = 127)
//
  // private Integer id_user;


   // @NotNull
   // @Size(min = 1, max = 100000000)
    private String date;
    
   // @NotNull
  //  @Size(min = 1, max = 100000000)
    private String start_time;

  //  @NotNull
   // @Size(min = 1, max = 10000000)
    private String end_time;

  //  @NotNull
   // @Size(min = 0, max = 1)
    private Integer lunch_flg;

  //  @NotNull
  //  @Size(min = 1, max = 8)
    private Integer id_user;
    
    
  @Size(min = 1, max = 16)
    @Pattern(regexp="^[A-Za-z0-9_.]+$",message = "半角英数字で入力してください")

    private String username;
    

    
    
    
}