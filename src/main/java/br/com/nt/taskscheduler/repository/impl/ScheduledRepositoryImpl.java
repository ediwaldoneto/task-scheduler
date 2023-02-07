package br.com.nt.taskscheduler.repository.impl;

import br.com.nt.taskscheduler.model.Schedule;
import br.com.nt.taskscheduler.repository.ScheduledRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public class ScheduledRepositoryImpl implements ScheduledRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Schedule> getScheduled(final LocalDateTime localDateTime) {
        return jdbcTemplate.queryForList("SELECT * FROM task WHERE active = true AND scheduled_time <= NOW()", Schedule.class);
    }

    @Override
    public List<Schedule> findAllTasksToBeExecuted() {
        return jdbcTemplate.query("SELECT * FROM task WHERE active = true AND scheduled_time <= CURRENT_TIME", (rs, rowNum) -> {
            Schedule task = new Schedule();
            task.setId(rs.getLong("id"));
            task.setUrl(rs.getString("url"));
            task.setScheduledTime(rs.getTimestamp("scheduled_time").toLocalDateTime());
            task.setActive(rs.getBoolean("active"));
            return task;
        });
    }
}
