package kr.co.kwonshzzang.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import kr.co.kwonshzzang.springbootdeveloper.domain.Article;
import kr.co.kwonshzzang.springbootdeveloper.dto.AddArticleRequest;
import kr.co.kwonshzzang.springbootdeveloper.dto.UpdateArticleRequest;
import kr.co.kwonshzzang.springbootdeveloper.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(Long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());
        return article;
    }

}
