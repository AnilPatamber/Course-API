package com.shadow.courseapi.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	TopicRepository topicRepository;
	
	public void addTopics(Topic topic)
	{
		topicRepository.save(topic);
	}
	public List<Topic> getAllTopics()
	{
		Iterable<Topic> itr = topicRepository.findAll();
		List<Topic> topics = new ArrayList<>();
		itr.forEach(topics::add);		
		return topics;
	}
	public void updateTopics(List<Topic> topics)
	{
		for(Topic topic : topics)
			topicRepository.save(topic);
	}

}
