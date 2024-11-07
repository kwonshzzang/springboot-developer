package kr.co.kwonshzzang.springbootdeveloper;

import org.junit.jupiter.api.*;

public class JUnitCycleTest {

    @BeforeAll //전체 테스트를 시작하기 전에 1회 실행하므로 메소드는 static 으로 선언
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach //테스트 케이스를 시작하기 전마다 실행
    void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @Test
    void test1() {
        System.out.println("test1");
    }

    @Test
    void test2() {
        System.out.println("test2");
    }

    @Test
    void test3() {
        System.out.println("test3");
    }

    @AfterAll //전체 테스트를 마치고 종료하기 전에 1회 실행하므로 메소드는 static 으로 선언
    static void afterAll() {
        System.out.println("@AfterAll");
    }

    @AfterEach
    void afterEach() { // 테스트 케이스를 종료하기 전마다 실행
        System.out.println("@AfterEach");
    }
}
