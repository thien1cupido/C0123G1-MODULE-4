package com.example.blogging_app.repository;

import com.example.blogging_app.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Blog findBlogById(Integer integer);

   @Query(value = "select * from blog as b where b.title like concat('%',:title,'%') and b.author like concat('%',:author,'%')",nativeQuery = true)
    List<Blog> searchBlog(@Param("title") String title,@Param("author")String author);
}
