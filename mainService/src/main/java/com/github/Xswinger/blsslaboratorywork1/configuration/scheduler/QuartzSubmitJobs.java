package com.github.Xswinger.blsslaboratorywork1.configuration.scheduler;

import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.github.Xswinger.blsslaboratorywork1.configuration.scheduler.job.ModelCountJob;

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
