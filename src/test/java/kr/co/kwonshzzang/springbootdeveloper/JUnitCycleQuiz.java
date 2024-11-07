package kr.co.kwonshzzang.springbootdeveloper;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitCycleQuiz {

    @BeforeEach
    public void beforeEach() {
        System.out.println("Hello!");
    }

    @Test
    void junitQuiz3() {
        System.out.println("This is first test");
    }

    @Test
    void junitQuiz4() {
        System.out.println("This is second test");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Bye!");
    }
}
