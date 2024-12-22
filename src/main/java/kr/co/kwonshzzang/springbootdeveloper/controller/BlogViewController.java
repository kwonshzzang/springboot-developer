package kr.co.kwonshzzang.springbootdeveloper.controller;

import kr.co.kwonshzzang.springbootdeveloper.domain.Article;
import kr.co.kwonshzzang.springbootdeveloper.dto.ArticleListViewResponse;
import kr.co.kwonshzzang.springbootdeveloper.dto.ArticleViewResponse;
import kr.co.kwonshzzang.springbootdeveloper.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/new-article")
    // id 키를 가진 쿼리 파라미터의 값을 id 변수에 매핑(id는 없을 수도 있음)
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if(id == null) {
        // id가 없으면 생성
            model.addAttribute("article", new ArticleViewResponse());
        } else {
        // id가 없으면 수정
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }

        return "newArticle";
    }

    @GetMapping("/articles")
    public String getArticles(Model model) {

        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new).toList();
        model.addAttribute("articles", articles);

        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }
}
