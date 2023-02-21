/**
 * 
 */
package br.com.nt.taskscheduler.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.nt.taskscheduler.model.SchedulerLog;
import br.com.nt.taskscheduler.repository.SchedulerLogRepository;

/**
 * @author Neto
 *
 */
@Repository
public class SchedulerLogRepositoryImpl implements SchedulerLogRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(SchedulerLog schedulerLogs) {
		//MapSqlParameterSource param = ObjectToMapConverter.convert(schedulerLogs);
		jdbcTemplate.update("INSERT INTO logs (taskName, execution, success, errorMessage) VALUES (?, ?, ?, ?)",
                schedulerLogs.getTaskName(), schedulerLogs.getExecution(), schedulerLogs.getSuccess(), schedulerLogs.getErrorMessage());
	}

}
