package cn.edu.fjnu.cdio4.xplan.service;

import java.net.InetAddress;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.fjnu.cdio4.xplan.domain.Reply;
import cn.edu.fjnu.cdio4.xplan.domain.Topic;
import cn.edu.fjnu.cdio4.xplan.domain.User;
import cn.edu.fjnu.cdio4.xplan.service.IReplyService;

/**
 *类的作用：
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-12-3   上午9:00:53
 */
public class ReplyServiceTest extends BaseServiceTest {
	@Autowired
	IReplyService replyService;

	@Test
	public void testSave() throws Exception {
		Reply reply = new Reply();
		InetAddress addr = InetAddress.getLocalHost();
		String ipAddr = addr.getHostAddress().toString();//获得本机IP
		
		User user = new User(1L);
		Topic topic = new Topic();
		topic.setId(1L);
		reply.setIpAddr(ipAddr);
		reply.setTitle("指针");
		reply.setContent("这个指针太难了，有没有高手指点一下，谢谢");
		reply.setUser(user);
		reply.setPostTime(new Date());
		reply.setTopic(topic);
		
		replyService.save(reply);
		
		//模拟数据库第二个数据
		Reply reply2 = new Reply();
	
		User user2 = new User(2L);
		reply2.setIpAddr(ipAddr);
		reply2.setTitle("指针");
		reply2.setContent("楼主没有想象的那么难了，多敲一下代码体会体会，" +
				"慢慢的理解，逐渐的就会掌握的");
		reply2.setUser(user2);
		reply2.setPostTime(new Date());
		reply2.setTopic(topic);
		
		replyService.save(reply2);
		
		
		
	}
}
