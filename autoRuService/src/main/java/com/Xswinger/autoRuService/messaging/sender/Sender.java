package com.Xswinger.autoRuService.messaging.sender;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.Xswinger.autoRuService.configuration.jms.MqttConfiguration;

@Component
public class Sender {

    private MqttConfiguration configuration;

    private IMqttClient client;

    @Autowired
    public Sender(MqttConfiguration configuration) throws MqttException {
        this.configuration = configuration;
        this.client = configuration.mqttClient();
    }

    public void sendMessage(String topic, String messageContent) {
        try {
            this.configuration.connect();
            
            MqttMessage message = new MqttMessage();
            message.setPayload(messageContent.getBytes());

            client.publish(topic, message);

            client.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
