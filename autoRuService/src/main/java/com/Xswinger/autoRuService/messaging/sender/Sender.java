package com.Xswinger.autoRuService.messaging.sender;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Xswinger.autoRuService.configuration.mqtt.MqttConfiguration;

@Component
public class Sender {

    @Autowired
    private IMqttClient mqttClient;

    @Autowired
    private MqttConfiguration configuration;

    public void sendMessage(String messageContent) {
        try {
            MqttMessage message = new MqttMessage();
            message.setPayload(messageContent.getBytes());

            mqttClient.publish(configuration.topic, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
