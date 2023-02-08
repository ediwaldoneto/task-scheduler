package br.com.nt.taskscheduler.repository;

import java.util.List;

import br.com.nt.taskscheduler.model.Schedule;

public interface ScheduledRepository {


    public List<Schedule> findAllTasksToBeExecuted();
}
