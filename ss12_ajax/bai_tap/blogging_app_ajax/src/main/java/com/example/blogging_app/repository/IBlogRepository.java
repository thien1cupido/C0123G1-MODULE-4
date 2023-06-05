package com.example.blogging_app.repository;

import com.example.blogging_app.model.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select b from Blog  b where b.status=false and b.title like concat('%',:title,'%')")
    List<Blog> searchBlog(@Param("title") String title);

    @Query(value = "select b from Blog b where b.status=false")
    Slice<Blog> findAllBlog(Pageable pageable);


    @Query(value = "select b from Blog  b where b.category.idCategory= :id ")
    List<Blog> findAllByCategory(@Param("id") Integer id);

}
