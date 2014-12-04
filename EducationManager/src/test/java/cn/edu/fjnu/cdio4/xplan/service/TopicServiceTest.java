package cn.edu.fjnu.cdio4.xplan.service;

import java.net.InetAddress;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.fjnu.cdio4.xplan.domain.Forum;
import cn.edu.fjnu.cdio4.xplan.domain.Reply;
import cn.edu.fjnu.cdio4.xplan.domain.Topic;
import cn.edu.fjnu.cdio4.xplan.domain.User;

public class TopicServiceTest extends BaseServiceTest {
	@Autowired
	ITopicService topicService;

	@Test
	public void testSave() throws Exception {
		Topic topic = new Topic(null, null, 1, 0, null, new Date());
		//创建一个版块的id
     	Forum forum = new Forum(1L);
		topic.setForum(forum);
		//传入一个用户的id
		User user = new User(1L);
		//传入一个回复
		Reply reply = new Reply();
		reply.setId(2L);
		InetAddress addr = InetAddress.getLocalHost();
		String ipAddr = addr.getHostAddress().toString();//获得本机IP
	
		topic.setIpAddr(ipAddr);
		topic.setTitle("指针");
		topic.setContent("这个指针太难了，有没有高手指点一下，谢谢");
		topic.setUser(user);
		topic.setPostTime(new Date());
//		topic.setLastReply(reply);
		topicService.save(topic);
	}
}
