/**
 * 
 */
package br.com.nt.taskscheduler.repository;

import br.com.nt.taskscheduler.model.SchedulerLog;

/**
 * @author Neto
 *
 */
public interface SchedulerLogsRepository {

	public void insert(SchedulerLog schedulerLogs);
}
