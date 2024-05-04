package com.Xswinger.uazService.scheduler.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelCountJob implements Job{
    @Autowired
    // private MemberService memberService;
    
    @Override
    public void execute(JobExecutionContext context) {
        // memberService.memberStats();
    }
}
