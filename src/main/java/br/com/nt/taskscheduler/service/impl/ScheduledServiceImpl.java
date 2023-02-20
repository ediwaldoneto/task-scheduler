package br.com.nt.taskscheduler.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.nt.taskscheduler.model.Schedule;
import br.com.nt.taskscheduler.model.SchedulerLogs;
import br.com.nt.taskscheduler.repository.impl.ScheduledRepositoryImpl;
import br.com.nt.taskscheduler.service.ScheduledService;

@Service
public class ScheduledServiceImpl implements ScheduledService {

	@Autowired
	private ScheduledRepositoryImpl scheduledRepository;

	private final RestTemplate restTemplate;

	@Autowired
	public ScheduledServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Autowired
	private SchedulerLogsServiceImpl logsServiceImpl;

	@Override
	public void executeScheduled() {

		final Logger LOG = LoggerFactory.getLogger(ScheduledServiceImpl.class);

		SchedulerLogs schedulerLogs = new SchedulerLogs();
		List<Schedule> schedule = scheduledRepository.findAllTasksToBeExecuted();
		String error = null;

		for (Schedule task : schedule) {
			try {

				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				schedulerLogs.setTaskName(task.getTaskName());
				schedulerLogs.setExecution(LocalDateTime.now());

				if (sdf.format(calendar.getTime()).equals(task.getScheduledTime().toLocalTime().toString())) {
					restTemplate.postForObject(task.getUrl(), task, Schedule.class);
					LOG.info("task successfully executed for the service {}", task.getTaskName());
				}else {
					continue;
				}
			} catch (Exception e) {
				LOG.info("An error occurred while running the service {}", task.getTaskName());
				error = e.getLocalizedMessage();

				schedulerLogs.setErrorMessage(e.getMessage());
			} finally {
				if (error == null) {
					schedulerLogs.setSuccess(true);
				} else {
					schedulerLogs.setSuccess(false);
				}
				logsServiceImpl.save(schedulerLogs);
			}
		}

	}

}
