package com.Xswinger.uazService.scheduler;

import com.Xswinger.uazService.scheduler.job.ModelCountJob;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzSubmitJobs {
    private static final String CRON_EVERY_FIVE_MINUTES = "0 0/5 * ? * * *";

    @Bean(name = "getModelsCounter")
    public JobDetailFactoryBean jobModelsCounter() {
        return QuartzConfig.createJobDetail(ModelCountJob.class, "Model Statistics Job");
    }

    @Bean(name = "getModelsCounterTrigger")
    public SimpleTriggerFactoryBean triggerModelsCounter(@Qualifier("getModelsCounter") JobDetail jobDetail) {
        return QuartzConfig.createTrigger(jobDetail, 60000, "Model Statistics Trigger");
    }
}
