package com.tgi.sms.model;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

	@Scheduled(cron = "0 54 17 * * ?")
	public void cronJobSch() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Task executing: "+now);
	}
}
