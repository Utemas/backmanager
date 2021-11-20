package com.backmanager.backmanager.saticScheduleTask;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
/**
 * 每天凌晨1点进行的操作
 */
@Configuration
@EnableScheduling
public class EveryDayMorning {
   //添加定时任务
   @Scheduled(cron = "0 0 0 * * ?")
   private void configureTasks() {
       System.err.println("执行静态定时任务2时间: " + LocalDateTime.now());
   }
}
