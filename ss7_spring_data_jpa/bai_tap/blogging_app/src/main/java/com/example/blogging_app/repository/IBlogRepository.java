package com.example.blogging_app.repository;

import com.example.blogging_app.model.Blog;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;



public interface IBlogRepository extends JpaRepository<Blog,Integer> {
   @Query(value = "select b from Blog  b where b.status=true and b.title like concat('%',:title,'%') and b.author like concat('%',:author,'%' )")
   Page<Blog> searchBlog(Pageable pageable,@Param("title") String title,@Param("author")String author);

   Page<Blog> findAllByStatusIsFalseOrderByCreateTimeDesc(Pageable pageable);

   @Query(value = "update Blog b set b.status=true where b.id= :id")
   @Modifying
   @Transactional
   void deleteBlogById(@Param("id")Integer id);
}
