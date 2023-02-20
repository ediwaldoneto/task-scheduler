/**
 * 
 */
package br.com.nt.taskscheduler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nt.taskscheduler.model.SchedulerLogs;
import br.com.nt.taskscheduler.repository.impl.SchedulerLogsRepositoryImpl;
import br.com.nt.taskscheduler.service.SchedulerLogsService;

/**
 * @author Neto
 *
 */
@Service
public class SchedulerLogsServiceImpl implements SchedulerLogsService {

	@Autowired
	private SchedulerLogsRepositoryImpl repositoryImpl;

	@Override
	public void save(SchedulerLogs schedulerLogs) {
		repositoryImpl.insert(schedulerLogs);

	}

}
