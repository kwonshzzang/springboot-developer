package kr.co.kwonshzzang.springbootdeveloper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuizController {

    @GetMapping("/quiz")
    public ResponseEntity<String> quiz(@RequestParam("code") int code) {
        return switch (code) {
            case 1 -> ResponseEntity.created(null).body("Created!");
            case 2 -> ResponseEntity.badRequest().body("Bad Request!");
            default -> ResponseEntity.ok("OK!");
        };
    }

    @PostMapping("/quiz")
    public ResponseEntity<String> quiz2(@RequestBody Code code) {
        return switch (code.value()) {
            case 1 -> ResponseEntity.status(403).body("Forbidden!");
            default -> ResponseEntity.ok().body("OK!");
        };
    }

    record Code(int value) {}
}
