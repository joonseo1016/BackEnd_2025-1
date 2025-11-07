package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ArticleController {
    @PostMapping("/article")
    public ResponseEntity<Void> createArticle(@RequestBody ArticleDto dto) {
        System.out.println("클라이언트가 보낸 description: " + dto.getDescription());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/article/{id}")
    public ResponseEntity<Void> updateArticle(
            @PathVariable("id") Long id, // URL의 {id} 값을 id 변수에 저장
            @RequestBody ArticleDto dto)   // Body의 JSON을 dto 변수에 저장
    {
        System.out.println("--- PUT /article/" + id + " ---");
        System.out.println("수정할 대상 ID: " + id);
        System.out.println("새로 받은 description: " + dto.getDescription());

        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/article/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {

        System.out.println("--- DELETE /article/" + id + " ---");
        System.out.println("삭제할 대상 ID: " + id);

        // (실제로는 id를 사용해 DB에서 데이터를 찾아 삭제합니다)

        // 204 No Content 응답 반환
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/article/{id}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable("id") Long id) {
        System.out.println("--- GET /article/" + id + " ---");

            return ResponseEntity.notFound().build();

    }
}