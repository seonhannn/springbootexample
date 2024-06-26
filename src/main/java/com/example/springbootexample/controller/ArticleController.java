package com.example.springbootexample.controller;

import com.example.springbootexample.dto.ArticleForm;
import com.example.springbootexample.entity.Article;
import com.example.springbootexample.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        // System.out.println(form.toString());
        log.info(form.toString());
        // DTO를 엔티티로 변환
        Article article = form.toEntity();
        // System.out.println(article.toString());
        log.info(article.toString());
        // 리파지토리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        // System.out.println(saved.toString());
        log.info(saved.toString());
        // 리다이렉트 작성할 위치
        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id: " + id);
        // 1. id를 조회해 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 2. 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);
        // 3. 뷰 페이지 반환하기
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        // 1. DB에서 모든 Article 데이터 가져오기
        List<Article> articleEntityList =  articleRepository.findAll();
        // 2. 가져온 Article 묶음을 모델에 등록하기
        model.addAttribute("articleList", articleEntityList);
        // 3. 사용자에게 보여 줄 뷰 페이지 설정하기
        return "articles/index";
    }
}
