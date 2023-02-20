/**
 * 
 */
package br.com.nt.taskscheduler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nt.taskscheduler.model.SchedulerLog;
import br.com.nt.taskscheduler.repository.impl.SchedulerLogRepositoryImpl;
import br.com.nt.taskscheduler.service.SchedulerLogService;

/**
 * @author Neto
 *
 */
@Service
public class SchedulerLogServiceImpl implements SchedulerLogService {

	@Autowired
	private SchedulerLogRepositoryImpl repositoryImpl;

	@Override
	public void save(SchedulerLog schedulerLogs) {
		repositoryImpl.insert(schedulerLogs);

	}

}
