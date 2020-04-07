package com.octopus.common.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class TestQuartz {
		public static void main(String[] args) throws SchedulerException {
			//调度器工厂类
			SchedulerFactory factory = new StdSchedulerFactory();
			Scheduler scheduler = factory.getScheduler();
			//开始工作
			scheduler.start();
			
			//创建Job的描述也就是JobDetail (JobBuilder来创建)  withIdentity 前面参数是名称 后面参数是组
			JobDetail detail = JobBuilder.newJob(MyJob.class)//获取作业对象
					.withIdentity("testJob","testJob")
					.build();
			
			//为trigger定义规则
			CronScheduleBuilder schedBuilder = CronScheduleBuilder
					.cronSchedule("* * * * * ?");//cron表达式
			
			//创建一个触发器
			Trigger trigger =TriggerBuilder.newTrigger()
					.withIdentity("testTrigger","testGroup")//第一个参数为名称 第二个为组
					.withSchedule(schedBuilder) //提供触发规则
					.startNow()//马上按照规则执行
					.build();//创建
			
			//开始调度
			scheduler.scheduleJob(detail,trigger);
		}
}
