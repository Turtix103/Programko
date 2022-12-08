package org.delta.cron.jobs;

import org.quartz.*;

import javax.inject.Singleton;

@Singleton
public class Example2JobTrigger implements JobTrigger {

    private static final String NAME_OF_JOB = "Job2";
    private static final String NAME_OF_GROUP = "group2";
    private static final String NAME_OF_TRIGGER = "triggerStart2";
    private static final int TIME_INTERVAL = 9;

    @Override
    public void register(Scheduler scheduler) {
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(NAME_OF_TRIGGER, NAME_OF_GROUP)
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(TIME_INTERVAL).repeatForever())
                .build();

        JobDetail jobInstance = JobBuilder.newJob(Example2Job.class).withIdentity(NAME_OF_JOB, NAME_OF_GROUP).build();
        try {
            scheduler.scheduleJob(jobInstance, trigger);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}
