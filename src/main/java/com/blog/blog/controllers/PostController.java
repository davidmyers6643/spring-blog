//package com.blog.blog;
//
//import org.springframework.stereotype.controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@controller
//public class PostController {
//
//    List<Post> posts = new ArrayList<>();
//
//    public PostController(){
//
//        posts.add(new Post("family","all of them"));
//        posts.add(new Post("house"," them"));
//        posts.add(new Post("car","i have one"));
//
//    }
//
//    @GetMapping("/posts")
//    public String index(Model viewModel) {
//
//        viewModel.addAttribute("post", posts);
//
//        return "posts/index";
//    }
//
//    @GetMapping("/posts/{id}")
//    @ResponseBody
//    public String show(@PathVariable long id, Model viewModel) {
//        Post post = posts.get((int) id -1);
//        viewModel.addAttribute("post", post);
//        return "posts/show"; }
//
//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String show() {
//        return "view the form for creating a post";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String createPage() {
//        return "create a new post!";
//    }
//
//
//
//}

//package com.blog.blog.controllers;
//
//import com.blog.blog.Post;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class PostController {
//
//    List<Post> posts = new ArrayList<>();
//
////    method	url	description
////    GET	/posts	posts index page
////    GET	/posts/{id}	view an individual post
////    GET	/posts/create	view the form for creating a post
////    POST	/posts/create	create a new post
//
//    public PostController(){
//
//        posts.add(new Post("My family","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab aliquam corporis dignissimos dolore exercitationem impedit, iure non nulla optio saepe sint soluta tenetur velit vero, voluptatem! Animi dignissimos eveniet incidunt?"));
//        posts.add(new Post("My feelings","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab aliquam corporis dignissimos non nulla optio saepe sint soluta tenetur velit vero, voluptatem! Animi dignissimos eveniet incidunt?"));
//        posts.add(new Post("My house","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab aliquam corporis dignissimos dolore exercitationem "));
//
//    }
//
//    @GetMapping("/posts")
//    public String index(Model viewModel) {
//
//        viewModel.addAttribute("posts", posts);
//
//        return "posts/index";
//    }
//
//    @GetMapping("/posts/{id}")
//    public String show(@PathVariable long id, Model viewModel) {
//        Post post = posts.get( (int) id - 1);
//        viewModel.addAttribute("post", post);
//        return "posts/show";
//    }
//
//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String show() {
//        return "Showing form to create new post!";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String create() {
//        return "New post was created!";
//    }
//
//}

//package com.blog.blog.controllers;
//
//import com.blog.blog.Post;
//import com.blog.blog.services.PostService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class PostController {
//
//    private final PostService postSvc;
//
//    public PostController(PostService postSvc) {
//        this.postSvc = postSvc;
//    }
//
//    @GetMapping("/posts")
//    public String index(Model viewModel) {
//        viewModel.addAttribute("posts", postSvc.findAll());
//        return "posts/index";
//    }
//
//    @GetMapping("/posts/{id}")
//    public String show(@PathVariable long id, Model viewModel) {
//        viewModel.addAttribute("post", postSvc.findOne(id));
//        return "posts/show";
//    }
//
//    @GetMapping("/posts/create")
//    public String show(Model model) {
//        model.addAttribute("post", new Post());
//        return "posts/create";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String create() {
//        return "New post was created!";
//    }
//
//    @PostMapping("posts/save")
//    public String createPost(@ModelAttribute Post post){
//        postSvc.save(post);
//        return "redirect:/posts";
//    }
//
//    @GetMapping("/posts/{id}/edit")
//    public String postEditForm(@PathVariable long id, Model viewModel) {
//        viewModel.addAttribute("post", postSvc.findOne(id));
//        return "posts/edit";
////        this was changed to update from edit
//    }
//    @PostMapping("posts/{id}/edit")
//    public String updatePost(@ModelAttribute Post post){
//        postSvc.update(post);
//        return "redirect:/posts";
//    }
//
//
//
//}

package com.blog.blog.controllers;

        import com.blog.blog.models.Post;
        import com.blog.blog.services.PostService;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostService postSvc;

    public PostController(PostService postSvc) {
        this.postSvc = postSvc;
    }

    @GetMapping("/posts")
    public String index(Model viewModel) {
        viewModel.addAttribute("posts", postSvc.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postSvc.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String insertPost(@ModelAttribute Post post) {
        postSvc.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String postEditForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postSvc.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@ModelAttribute Post post) {
         postSvc.save(post);
        System.out.println("Post updated!");
        return "redirect:/posts";
    }

}
