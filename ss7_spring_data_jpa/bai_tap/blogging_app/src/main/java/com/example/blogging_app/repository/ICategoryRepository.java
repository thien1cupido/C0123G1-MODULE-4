package com.example.blogging_app.repository;

import com.example.blogging_app.model.Blog;
import com.example.blogging_app.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {

    Page<Category> findAllByStatusIsFalseOrderByCreateTimeDesc(Pageable pageable);

    @Query(value = "select b from Cate  c where b.status=true and b.title like concat('%',:title,'%') and b.author like concat('%',:author,'%' )")
    Page<Blog> searchBlog(Pageable pageable,@Param("title") String title,@Param("author")String author);
//    @Query(value = "update category c set c.status=true where category.status = :id")
//    @Modifying
//    @Transactional
//    void deleteCategoryById(@Param("id")Integer id);
}
