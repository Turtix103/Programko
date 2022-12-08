package org.delta.cron.jobs;

import com.google.inject.Injector;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;

import javax.inject.Inject;

public class GuiceJobFactory implements JobFactory {

    @Inject
    private Injector guice;

    @Override
    public Job newJob(TriggerFiredBundle bundle, Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = bundle.getJobDetail();
        Class jobClass = jobDetail.getJobClass();

        try {
            return (Job) guice.getInstance(jobClass);
        } catch (Exception e) {
            e.printStackTrace();

            throw new UnsupportedOperationException(e);
        }
    }
}
