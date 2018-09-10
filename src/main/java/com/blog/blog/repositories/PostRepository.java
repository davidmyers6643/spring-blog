//package com.blog.blog.repositories;
//
//import com.blog.blog.models.Post;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.List;
//
//public interface PostRepository extends CrudRepository<Post, Long> {
//    List<Post> findAll();
//
//    List<Post> findByTitleContainingOrDescriptionContaining(String string1, String string2);
//
//    @Query("from Post a where a.id > ?1")
//    List<Post> findCustom(long id);
//}
