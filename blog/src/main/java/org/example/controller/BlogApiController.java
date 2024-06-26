package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Article;
import org.example.dto.AddArticleRequest;
import org.example.dto.ArticleResponse;
import org.example.dto.UpdateArticleRequest;
import org.example.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController  // 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
@RequiredArgsConstructor
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        log.info("########## findAllArticles");
        List<ArticleResponse> articles = blogService.findAll()
            .stream()
            .map(ArticleResponse::new)  // ArticleResponse로 변환
            .toList();

        return ResponseEntity.ok()
            .body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticleById(@PathVariable long id) {
        Article article = blogService.findById(id);
        return ResponseEntity.ok()
            .body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);
        return ResponseEntity.ok()
            .build();
    }

    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request) {
        Article updatedArticle = blogService.update(id, request);
        return ResponseEntity.ok()
            .body(updatedArticle);
    }
}
