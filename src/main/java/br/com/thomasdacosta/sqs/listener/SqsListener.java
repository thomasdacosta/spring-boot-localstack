package br.com.thomasdacosta.sqs.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SqsListener {

    @io.awspring.cloud.messaging.listener.annotation.SqsListener("${sqsQueueName}")
    public void queueListener(String message) {
        try {
            log.info(message);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

}
