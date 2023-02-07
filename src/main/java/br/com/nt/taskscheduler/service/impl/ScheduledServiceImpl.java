package br.com.nt.taskscheduler.service.impl;

import br.com.nt.taskscheduler.model.Schedule;
import br.com.nt.taskscheduler.repository.impl.ScheduledRepositoryImpl;
import br.com.nt.taskscheduler.service.ScheduledService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
@Service
public class ScheduledServiceImpl implements ScheduledService {

    @Autowired
    private ScheduledRepositoryImpl scheduledRepository;
    
    private final RestTemplate restTemplate;
    @Autowired
    public ScheduledServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void executeScheduled() {

        final Logger LOG = LoggerFactory.getLogger(ScheduledServiceImpl.class);

        List<Schedule> schedule = scheduledRepository.findAllTasksToBeExecuted();
        for (Schedule task : schedule) {
            try {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                int second = calendar.get(Calendar.SECOND);
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

                if (sdf.format(calendar.getTime()).equals(task.getScheduledTime().toLocalTime().toString())){
                    restTemplate.getForObject(task.getUrl(), String.class);
                    LOG.info("task executed successfully");
                }
            } catch (Exception e) {
                LOG.info("an error has occurred" + e);
            }
        }
        LOG.info("end of check tasks" +
                " {}", LocalDateTime.now());
    }

}
