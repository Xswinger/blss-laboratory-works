package com.Xswinger.autoRuService.messaging.sender;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    //TODO configure in properties file
    @Value("${mqtt.broker.url}")
    private String brokerUrl;

    @Value("${mqtt.client.id}")
    private String clientId;

    private final MqttClient client;

    @Autowired
    public Sender() throws MqttException {
        this.client = new MqttClient(brokerUrl, clientId);
    }

    public void sendMessage(String topic, String messageContent) {
        try {
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);

            client.connect(options);

            MqttMessage message = new MqttMessage();
            message.setPayload(messageContent.getBytes());

            client.publish(topic, message);

            client.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
