package com.github.Xswinger.blsslaboratorywork1.messaging.sender;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
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

    @Bean
    public void connect() {
        try {
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
    
            client.connect(options);   
        } catch (MqttException e) {
            // TODO: handle exception
        }
    }

    public void sendMessage(String topic, String messageContent) {
        try {
            MqttMessage message = new MqttMessage();
            message.setPayload(messageContent.getBytes());

            client.publish(topic, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    public void disconnect() {
        try {
            client.disconnect();
        } catch (MqttException e) {
            // TODO: handle exception
        }
    }

}
