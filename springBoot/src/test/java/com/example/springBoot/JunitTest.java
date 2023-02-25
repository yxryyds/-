package com.example.springBoot;

import org.junit.jupiter.api.*;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Tag("slow")
@Tag("suit01")
@interface Suit01Fast{

}

public class JunitTest {
    @Test
    @Suit01Fast
    void show(){
        Method[] an = this.getClass().getDeclaredMethods();
        System.out.println(Arrays.asList(an));

        List<String> stringStream =  Arrays.stream(an).map(Method::getName).collect(Collectors.toList());
        System.out.println(stringStream);

        List<Annotation[]> collect = Arrays.stream(an).map(Method::getAnnotations).collect(Collectors.toList());
        collect.forEach((array)->{
            System.out.println(Arrays.stream(array).map(Annotation::annotationType).collect(Collectors.toList()));
        });
    }

    int i = 10;

    @Test
    @DisplayName("计算消息")
    public void testSpringBoot(){
        assertTrue(true, () ->(i = 100) + "shshshhs");
        assertEquals(10, i);
        System.out.println("i就是等于10");
    }

    @Test
    @Disabled("for demo")
    void skippedTest(){

    }

    @BeforeAll
    static void initAll(){

    }

    @BeforeEach
    void init(){

    }

    @AfterEach
    void tearDown(){

    }

    @AfterAll
    static void tearDownAll(){

    }
}
