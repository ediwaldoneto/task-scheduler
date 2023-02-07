package br.com.nt.taskscheduler.repository;

import java.time.LocalDateTime;
import java.util.List;

import br.com.nt.taskscheduler.model.Schedule;

public interface ScheduledRepository {

    public  List<Schedule> getScheduled(final LocalDateTime localDateTime);

    public List<Schedule> findAllTasksToBeExecuted();
}
