package org.delta.cron.jobs;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.inject.Inject;

public class Example2Job implements Job {

    private Logger log = Logger.getLogger(Example2Job.class);

    @Inject
    private TestService testService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.debug("Example2 job start ...");

        this.testService.test();
    }
}
