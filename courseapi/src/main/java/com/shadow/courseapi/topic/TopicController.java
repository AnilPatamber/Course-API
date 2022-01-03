package com.shadow.courseapi.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("Topic")
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
	@RequestMapping("/topics")	
	public List<Topic> getAllTopics()
	{
		return topicService.getAllTopics();
	}	
	
	@RequestMapping(method = RequestMethod.POST ,value = "/topics")
	public void addTopics(@RequestBody Topic topic)
	{
		topicService.addTopics(topic);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/topics")
	public void updateTopics(@RequestBody List<Topic> topics)
	{
		topicService.updateTopics(topics);
	}

	
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		List <Topic> topics = new ArrayList<>(Arrays.asList(
				new Topic ("Spring", "Springboot", "Springboot framework"),
				new Topic ("Java", "Java8", "Java 8 Lambda expressions"),
				new Topic ("Java", "Hibernate", "Hibernate framework"),
				new Topic ("JavaScript", "JavaScript","JavaScript for beginners")
				));
		for(Topic topic : topics) topicService .addTopics(topic);
	    System.out.println("Sample data has been injected into the Derby Database...");
	}
}
