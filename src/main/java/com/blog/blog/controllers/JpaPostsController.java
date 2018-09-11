package com.blog.blog.controllers;

import com.blog.blog.models.Post;
import com.blog.blog.repositories.PostRepository;

import com.blog.blog.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JpaPostsController {
	
	@Autowired
    PostRepository postDao;

//    public JpaPostsController(PostRepository postDao) {
//        this.postDao = postDao;
//    }
	
	@Autowired
	PostSvc postSvc;
	
	public JpaPostsController(PostSvc postSvc) {
		this.postSvc = postSvc;
	}

    @GetMapping("/jpa/posts/find")
    @ResponseBody
    public String jpaFindTest() {
        return postDao.findOne(2L).toString();
    }
	
	@GetMapping("/jpa/posts/findall")
	@ResponseBody
	public String jpaPostFindAllTest() {
		List<Post> posts = postSvc.giveMePosts();
		String output = "";
		for (Post post : posts) {
			output += post.toString() + "<br>";
		}
		return output;
	}

    @GetMapping("/jpa/posts/create")
    @ResponseBody
    public String jpaPostCreateTest() {
        Post post = new Post("New Post", "This is a brand new post");
        postDao.save(post);
        return jpaPostFindAllTest();
    }

    @GetMapping("/jpa/posts/update")
    @ResponseBody
    public String jpaPostUpdateTest() {
        Post post = new Post(3,"Update Post", "This is a updated post");
        postDao.save(post);
        return jpaPostFindAllTest();
    }

    @GetMapping("/jpa/posts/delete")
    @ResponseBody
    public String jpaPostDeleteTest() {
        postDao.delete(3L);
        return jpaPostFindAllTest();
    }

    @GetMapping("/jpa/posts/search")
    @ResponseBody
    public String jpaPostSearchTest() {

        List<Post> posts = postDao.findByTitleContainingOrBodyContaining("desc", "desc");

        String output = "";
        for (Post post : posts) {
            output += post.toString() + "<br>";
        }

        return output;
    }

    @GetMapping("/jpa/posts/custom")
    @ResponseBody
    public String jpaPostCustomTest() {

        List<Post> posts = postDao.findCustom(2);

        String output = "";
        for (Post post : posts) {
            output += post.toString() + "<br>";
        }

        return output;
    }


}
