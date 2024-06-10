package com.github.Xswinger.blsslaboratorywork1.configuration.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfiguration {

    @Value("${mqtt.broker.url}")
    private String brokerUrl;

    @Value("${mqtt.username}")
    private String username;

    @Value("${mqtt.password}")
    private String password;

    @Value("${mqtt.topic.main}")
    public String mainTopic;

    @Value("${mqtt.topic.uaz}")
    public String uazTopic;

    @Value("${mqtt.topic.autoRu}")
    public String autoRuTopic;

    @Bean
    public IMqttClient mqttClient() throws MqttException {
        IMqttClient client = new MqttClient(brokerUrl, "main");
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        client.connect(options);
        return client;
    }

}
