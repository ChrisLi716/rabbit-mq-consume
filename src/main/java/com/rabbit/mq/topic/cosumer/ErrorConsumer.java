package com.rabbit.mq.topic.cosumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component("topicErrorConsumer")
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.config.queue.error}", autoDelete = "true"), exchange = @Exchange(value = "${mq.config.topic.exchange}", type = ExchangeTypes.TOPIC), key = "${mq.config.queue.topic.error.routing.key}"))
public class ErrorConsumer {
	
	@RabbitHandler
	public void consumeErrorLog(String msg) {
		System.out.println("error log : " + msg);
	}
	
}
