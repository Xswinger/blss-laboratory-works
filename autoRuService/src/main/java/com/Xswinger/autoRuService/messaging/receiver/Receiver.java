package com.Xswinger.autoRuService.messaging.receiver;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Xswinger.autoRuService.configuration.mqtt.MqttConfiguration;

import jakarta.annotation.PostConstruct;

@Component
public class Receiver {

    @Autowired
    private IMqttClient mqttClient;

    @Autowired
    private MqttConfiguration configuration;

    @PostConstruct
    public void subscribe() throws Exception {
        this.mqttClient.subscribe(configuration.topic, (topic, msg) -> {
            byte[] payload = msg.getPayload();
            System.out.println("Received message: " + new String(payload));
        });
    }
}
