package com.github.Xswinger.blsslaboratorywork1.delegates.addAdmin;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.impl.IdentityServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class RegistrationProcess implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String userId = execution.getVariable("user_id_register").toString();
        String userName = execution.getVariable("fist_name_register").toString();
        String userSurname = execution.getVariable("last_name_register").toString();
        String userPassword = execution.getVariable("password_register").toString();

        final IdentityServiceImpl identityService = (IdentityServiceImpl) execution.getProcessEngineServices().getIdentityService();
        if (identityService.createUserQuery().userId(userId).count() != 0) {
            throw new BpmnError("User already exist");
        }

        User newUser = identityService.newUser(userId);
        newUser.setFirstName(userName);
        newUser.setLastName(userSurname);
        newUser.setPassword(userPassword);
        newUser.setEmail(userId + "@bloss.brigada");
        
        identityService.saveUser(newUser, true);
        
        identityService.createMembership(userId, "authorized");
        execution.setVariable("register_result", "User register success");
    }

}
