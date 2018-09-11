package com.blog.blog.services;

import com.blog.blog.models.Post;
import com.blog.blog.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostSvc {
	
	PostRepository postDao;
	
	public PostSvc(PostRepository postDao) {
		this.postDao = postDao;
	}
	
	public List<Post> giveMePosts() {
		return postDao.findAll();
	}
}
