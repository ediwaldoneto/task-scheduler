package br.com.nt.taskscheduler.service.impl;

import br.com.nt.taskscheduler.service.TaskSchedulerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@EnableScheduling
public class TaskSchedulerServiceImpl implements TaskSchedulerService {
    @Autowired
    private ScheduledServiceImpl scheduledService;

    final Logger LOG = LoggerFactory.getLogger(ScheduledServiceImpl.class);

    @Scheduled(cron = "0 * * * * *")
    @Override
    public void checkTasks() {
        LOG.info("start checking tasks {}", LocalDateTime.now());
        scheduledService.executeScheduled();
    }
}
