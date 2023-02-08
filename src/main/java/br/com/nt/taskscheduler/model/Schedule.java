package br.com.nt.taskscheduler.model;

import java.time.LocalDateTime;

public class Schedule {

    private Long id;
    private String url;
    private LocalDateTime scheduledTime;
    private boolean active;
    private String taskName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	
}
