package br.com.nt.taskscheduler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.nt.taskscheduler.service.TaskSchedulerService;

@Service
@EnableScheduling
public class TaskSchedulerServiceImpl implements TaskSchedulerService {
	@Autowired
	private ScheduledServiceImpl scheduledService;

	@Scheduled(cron = "0 * * * * *")
	@Override
	public void checkTasks() {
		scheduledService.executeScheduled();
	}
}
