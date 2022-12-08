package org.delta;

import org.apache.log4j.BasicConfigurator;
import org.delta.cron.jobs.Example2JobTrigger;
import org.delta.cron.jobs.ExampleJobTrigger;
import org.delta.cron.jobs.GuiceJobFactory;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class QuartzScheduler {

    @Inject
    private GuiceJobFactory guiceJobFactory;

    @Inject
    private ExampleJobTrigger exampleJobTrigger;

    @Inject
    private Example2JobTrigger example2JobTrigger;

    public void registerJobs() {
        try {
            BasicConfigurator.configure();

            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //scheduler.setJobFactory(this.guiceJobFactory);

            exampleJobTrigger.register(scheduler);
            example2JobTrigger.register(scheduler);

            scheduler.start();


        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

}
