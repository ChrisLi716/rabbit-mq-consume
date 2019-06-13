package com.rabbit.mq.direct.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.config.queue.error}", autoDelete = "true"), exchange = @Exchange(value = "${mq.config.direct.exchange}", type = ExchangeTypes.DIRECT), key = "${mq.config.queue.direct.error.routing.key}"))
public class ErrorConsumer {
	
	@RabbitHandler
	public void consumeErrorLog(String msg) {
		System.out.println("error log : " + msg);
	}
	
}
