package com.rabbit.mq.direct.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.config.queue.info}", autoDelete = "true"), exchange = @Exchange(value = "${mq.config.direct.exchange}", type = ExchangeTypes.DIRECT), key = "${mq.config.queue.direct.info.routing.key}"))
public class InfoConsumer {
	
	@RabbitHandler
	public void consumeInfoLog(String msg) {
		System.out.println("info log : " + msg);
	}
	
}
