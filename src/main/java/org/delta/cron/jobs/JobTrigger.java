package org.delta.cron.jobs;

import org.quartz.Scheduler;

public interface JobTrigger {

    public void register(Scheduler scheduler);

}
