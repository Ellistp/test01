package com.yhub.rabbitmq;

import com.sun.glass.ui.Application;
import com.yhub.rabbitmq.sender.RabbitSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RabbitmqApplicationTests {

	@Autowired
	private RabbitSender rabbitSender;

	@Test
	public void contextLoads() {
		// 测试广播模式
		rabbitSender.broadcast("同学们集合啦！");
		// 测试Direct模式
		rabbitSender.direct("定点消息");
	}
}
