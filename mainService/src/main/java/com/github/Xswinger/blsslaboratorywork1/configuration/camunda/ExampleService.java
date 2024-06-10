package com.github.Xswinger.blsslaboratorywork1.configuration.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class ExampleService implements JavaDelegate {

    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Example called.");
    }

}
