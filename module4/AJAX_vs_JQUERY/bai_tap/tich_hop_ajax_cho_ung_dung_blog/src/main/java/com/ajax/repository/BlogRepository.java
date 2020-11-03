package com.ajax.repository;


import com.ajax.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByCategory_NameCategory(String name);
    @Query(value = "SELECT * FROM blog limit ?1 , 5",nativeQuery = true)
    List<Blog> displayListBlog(int offset);
}
