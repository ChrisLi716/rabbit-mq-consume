package com.rabbit.mq.topic.cosumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.config.queue.debug}", autoDelete = "true"), exchange = @Exchange(value = "${mq.config.topic.exchange}", type = ExchangeTypes.TOPIC), key = "${mq.config.queue.topic.debug.routing.key}"))
public class DebugConsumer {
	
	@RabbitHandler
	public void consumeInfoLog(String msg) {
		System.out.println("debug log : " + msg);
	}
	
}
