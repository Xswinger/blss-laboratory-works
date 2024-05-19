package com.github.Xswinger.blsslaboratorywork1.messaging.receiver;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.Xswinger.blsslaboratorywork1.configuration.mqtt.MqttConfiguration;

import jakarta.annotation.PostConstruct;

@Component
public class Receiver {

    @Autowired
    private IMqttClient mqttClient;

    @Autowired
    private MqttConfiguration configuration;

    @PostConstruct
    public void subscribeMain() throws Exception {
        mqttClient.subscribe(configuration.mainTopic, (topic, msg) -> {
            byte[] payload = msg.getPayload();
            System.out.println("Received message: " + new String(payload));
        });
    }

    @PostConstruct
    public void subscribeUaz() throws Exception {
        mqttClient.subscribe(configuration.uazTopic, (topic, msg) -> {
            byte[] payload = msg.getPayload();
            System.out.println("Received message: " + new String(payload));
        });
    }
}
