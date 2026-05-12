package com.timefit.entity;


import lombok.Data;

import java.time.LocalDateTime;


@Data   // Lombok注解，自动生成getter/setter
public class Schedule {
    private Long id;
    private String title;
    private String type;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean isCompleted= false;
    private Long userId;
}
