package br.com.nt.taskscheduler.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.nt.taskscheduler.model.Schedule;
import br.com.nt.taskscheduler.repository.ScheduledRepository;
@Repository
public class ScheduledRepositoryImpl implements ScheduledRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Schedule> findAllTasksToBeExecuted() {
        return jdbcTemplate.query("SELECT * FROM task WHERE active = true AND scheduled_time <= CURRENT_TIME", (rs, rowNum) -> {
            Schedule task = new Schedule();
            task.setId(rs.getLong("id"));
            task.setUrl(rs.getString("url"));
            task.setScheduledTime(rs.getTimestamp("scheduled_time").toLocalDateTime());
            task.setActive(rs.getBoolean("active"));
            task.setTaskName(rs.getString("task_name"));
            return task;
        });
    }
}
