package com.timefit.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data   //getter setter方法自动生成
@AllArgsConstructor   //构造函数自动生成，和getter setter方法不一样！
public class ApiResponse<T> {
    //T是泛型，当你不知道返回的类型，就用它，占位
    private int code;
    private String message;
    private T data;
}
