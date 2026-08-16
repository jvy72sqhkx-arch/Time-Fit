package com.timefit.controller;

import com.timefit.entity.ApiResponse;
import com.timefit.entity.Schedule;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    注解的作用
    @RestController  就是帮你实例化 ScheduleController控制器，并把返回值转为JSON
    @RequestBody 	new了一个请求体对应的Java对象
 */

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    //静态变量，以下所有方法都能用
    private static List<Schedule> scheduleList = new ArrayList<>();
    private static Long nextId = 1L;


    /**
     * 获取所有日程(两条模拟数据）
     * @return
     */

    @GetMapping
    public ApiResponse<List<Schedule>> getAllSchedules(@RequestParam(required = false) String type) {
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

        if (type != null && !type.isEmpty()) {
            List<Schedule> filteredList = new ArrayList<>();
            for (Schedule schedule : scheduleList) {
                if (type.equals(schedule.getType())) {
                    filteredList.add(schedule);
                }
            }
            return new ApiResponse<>(200, "success", filteredList);
        }

        return new ApiResponse<>(200, "success", scheduleList);
    }


    /*
      创建日程
     */

    @PostMapping
    public ApiResponse<Schedule> createSchedule(@RequestBody Schedule newSchedule) {
        //基本校验
        if(newSchedule.getTitle() == null || newSchedule.getTitle().isEmpty()){
            return new ApiResponse<>(400, "标题不能为空", null);
        }
        if(newSchedule.getType() == null || newSchedule.getType().isEmpty()){
            return new ApiResponse<>(400, "类型不能为空", null);
        }
        if(newSchedule.getStartTime() == null || newSchedule.getEndTime() == null){
            return new ApiResponse<>(400, "开始时间和结束时间不能为空", null);
        }
        //TODO 一些基础信息的校验回头再来补呀

        newSchedule.setId(nextId++);
        newSchedule.setIsCompleted(false);
        newSchedule.setUserId(1L);

        scheduelList.add(newSchedule);

        return new ApiResponse<>(201, "日程创建成功", newSchedule);
    }


    @PutMapping("/{id}")
    public ApiResponse<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Schedule updatedSchedule) {
        //@RequestBody Schedule updatedSchedule 表示接收一个叫做updatedSchedule的Schedule类对象，这个对象是更新后的新实例

        Schedule foundSchedule =null;
        //注意！这里不new是因为找到的Schedule对象已经是一个实例了！我们只需要先把位置给它留好
        for (Schedule schedule : scheduelList) {
            if (schedule.getId().equals(id)) {
                foundSchedule = schedule;
                break;
            }
        }
        // 如果没找到
        if (foundSchedule == null) {
            return new ApiResponse<>(404, "日程不存在", null);
        }

        //找到了，更新
        if (updatedSchedule.getTitle() != null && !updatedSchedule.getTitle().isEmpty()) {
            foundSchedule.setTitle(updatedSchedule.getTitle());
        }
        if (updatedSchedule.getType() != null && !updatedSchedule.getType().isEmpty()) {
            foundSchedule.setType(updatedSchedule.getType());
        }
        if (updatedSchedule.getStartTime() != null) {
            foundSchedule.setStartTime(updatedSchedule.getStartTime());
        }
        if (updatedSchedule.getEndTime() != null) {
            foundSchedule.setEndTime(updatedSchedule.getEndTime());
        }
        if (updatedSchedule.getIsCompleted() != null) {
            foundSchedule.setIsCompleted(updatedSchedule.getIsCompleted());
        }
        return new ApiResponse<>(200, "日程更新成功", foundSchedule);
    }



}
