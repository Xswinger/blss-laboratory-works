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

    @Autowired
    private IMqttClient mqttClient;

    @Autowired
    private MqttConfiguration configuration;

    public void mainSendMessage(Announcement announcement) {
        try {
            MqttMessage message = new MqttMessage();
            message.setPayload(SerializationUtils.serialize(announcement));

            mqttClient.publish(configuration.mainTopic, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void uazSendMessage(Announcement announcement) {
        try {
            MqttMessage message = new MqttMessage();
            message.setPayload(SerializationUtils.serialize(announcement));

            mqttClient.publish(configuration.uazTopic, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
