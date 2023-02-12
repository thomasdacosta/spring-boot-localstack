package br.com.thomasdacosta.sns.service;

import com.amazonaws.services.sns.AmazonSNS;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SnsNotificationService {

	@Value("${snsNotificationName}")
	private String notificationName;

	private final NotificationMessagingTemplate notificationMessagingTemplate;

	@Autowired
	public SnsNotificationService(AmazonSNS amazonSns) {
		this.notificationMessagingTemplate = new NotificationMessagingTemplate(amazonSns);
	}

	public void sendNotification(String subject, Object message, Map<String, Object> headers) {
		this.notificationMessagingTemplate.convertAndSend(notificationName, message, headers);
	}

}
