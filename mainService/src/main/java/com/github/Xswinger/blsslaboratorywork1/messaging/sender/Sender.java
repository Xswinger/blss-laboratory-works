package com.github.Xswinger.blsslaboratorywork1.messaging.sender;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import com.github.Xswinger.blsslaboratorywork1.configuration.mqtt.MqttConfiguration;
import com.github.Xswinger.blsslaboratorywork1.entities.Announcement;

@Component
public class Sender {

    private MqttConfiguration configuration;

    private IMqttClient client;

    @Autowired
    public Sender(MqttConfiguration configuration) throws MqttException {
        this.configuration = configuration;
        this.client = configuration.mqttClient();
    }

    public void sendMessage(Announcement announcement) {
        try {
            this.configuration.connect();
            
            MqttMessage message = new MqttMessage();
            message.setPayload(SerializationUtils.serialize(announcement));

            client.publish(configuration.topic, message);

            client.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
