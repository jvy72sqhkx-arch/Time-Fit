package com.timefit.controller;

import com.timefit.entity.ApiResponse;
import com.timefit.entity.Schedule;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {


    /**
     * 获取所有日程(两条模拟数据）
     * @return
     */

    @GetMapping
    public ApiResponse<List<Schedule>> getAllSchedules() {
        //模拟数据1,而且因为Schedule类只加了Data注解，这里只能new一个之后一个个赋值
        Schedule schedule1 = new Schedule();
        schedule1.setId(1L);
        schedule1.setTitle("晨会");
        schedule1.setType("task");
        schedule1.setStartTime(LocalDateTime.of(2024, 5, 20, 9, 0));
        schedule1.setEndTime(LocalDateTime.of(2024, 5, 20, 10, 0));
        schedule1.setIsCompleted(false);
        schedule1.setUserId(1L);

        //模拟数据2
        Schedule schedule2 = new Schedule();
        schedule2.setId(2L);
        schedule2.setTitle("碎片运动");
        schedule2.setType("exercise");
        schedule2.setStartTime(LocalDateTime.of(2024, 5, 20, 11, 0));
        schedule2.setEndTime(LocalDateTime.of(2024, 5, 20, 11, 10));
        schedule2.setIsCompleted(true); // 这个标记为已完成
        schedule2.setUserId(1L);

        List<Schedule> scheduleList = Arrays.asList(schedule1, schedule2);
        //这个方法等价于：用了3个scheduleList.add(schedule ?),就是一个快速建表的方法

        return new ApiResponse<>(200, "success", scheduleList);
    }
}
