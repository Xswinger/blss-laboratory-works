package com.Xswinger.uazService.messaging.sender;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Xswinger.uazService.configuration.MqttConfiguration;


@Component
public class Sender {

    @Autowired
    private IMqttClient client;

    @Autowired
    private MqttConfiguration configuration;

    @Autowired
    public Sender(MqttConfiguration configuration) throws MqttException {
        this.configuration = configuration;
        this.client = configuration.mqttClient();
    }

    public void sendMessage(String messageContent) {
        try {
            MqttMessage message = new MqttMessage();
            message.setPayload(messageContent.getBytes());

            client.publish(configuration.topic, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
