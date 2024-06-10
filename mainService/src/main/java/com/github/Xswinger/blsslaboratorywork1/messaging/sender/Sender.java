package com.github.Xswinger.blsslaboratorywork1.messaging.sender;

import java.nio.ByteBuffer;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.Xswinger.blsslaboratorywork1.configuration.mqtt.MqttConfiguration;
@Service
public class Sender {

    @Autowired
    private IMqttClient mqttClient;

    @Autowired
    private MqttConfiguration configuration;

    public void sendMessageFromMainToAutoRu(Integer announcementId) {
        try {
            MqttMessage message = new MqttMessage();
            message.setPayload(ByteBuffer.allocate(Long.BYTES).putLong(announcementId).array());

            mqttClient.publish(configuration.autoRuTopic, message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendMessageFromAutoRuToMain(Long id) {
        try {
            MqttMessage message = new MqttMessage();

            byte[] bytes = ByteBuffer.allocate(Long.BYTES).putLong(id).array();

            message.setPayload(bytes);

            mqttClient.publish(configuration.mainTopic, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessageFromUazToMain(Integer count) {
        try {
            MqttMessage message = new MqttMessage();
            message.setPayload(ByteBuffer.allocate(Long.BYTES).putLong(count).array());

            mqttClient.publish(configuration.uazTopic, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
