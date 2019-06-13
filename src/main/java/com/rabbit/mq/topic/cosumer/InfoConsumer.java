package com.rabbit.mq.topic.cosumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component("topicInfoConsumer")
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.config.queue.info}", autoDelete = "true"), exchange = @Exchange(value = "${mq.config.topic.exchange}", type = ExchangeTypes.TOPIC), key = "${mq.config.queue.topic.info.routing.key}"))
public class InfoConsumer {
	
	@RabbitHandler
	public void consumeInfoLog(String msg) {
		System.out.println("info log : " + msg);
	}
	
}
