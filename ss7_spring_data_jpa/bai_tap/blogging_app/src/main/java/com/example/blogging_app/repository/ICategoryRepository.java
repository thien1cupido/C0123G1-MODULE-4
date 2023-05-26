package com.example.blogging_app.repository;

import com.example.blogging_app.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {

    Page<Category> findAllByStatusIsFalseOrderByCreateTimeDesc(Pageable pageable);


    @Query(value = "update category c set c.status=true where category.status = :id")
    @Modifying
    @Transactional
    void deleteCategoryById(@Param("id")Integer id);
}
