package com.github.Xswinger.blsslaboratorywork1.configuration.mqtt;

import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class MqttConfiguration {

    @Value("${mqtt.broker.url}")
    private String brokerUrl;

    @Value("${mqtt.username}")
    private String username;

    @Value("${mqtt.password}")
    private String password;

    @Value("${spring.jms.topic}")
    public String topic;

    @Bean
    public IMqttClient mqttClient() throws MqttException {
        String publisherId = UUID.randomUUID().toString();
        return new MqttClient(brokerUrl ,publisherId);
    }

    @Bean
    public MqttConnectOptions connect() throws MqttSecurityException, MqttException {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        return options;
    }

}
