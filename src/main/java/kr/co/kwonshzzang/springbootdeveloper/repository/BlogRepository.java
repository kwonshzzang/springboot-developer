package kr.co.kwonshzzang.springbootdeveloper.repository;

import kr.co.kwonshzzang.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {
}
