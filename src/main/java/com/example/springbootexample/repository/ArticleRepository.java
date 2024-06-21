package com.example.springbootexample.repository;

import com.example.springbootexample.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
