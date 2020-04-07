package com.octopus.common.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job{

    
	public void execute(JobExecutionContext context) throws JobExecutionException {
			System.out.println("自定义我的任务:"+new Date());
	}

}
