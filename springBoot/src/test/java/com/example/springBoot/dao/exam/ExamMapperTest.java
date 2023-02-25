package com.example.springBoot.dao.exam;

import com.example.springBoot.model.exam.Cource;
import com.example.springBoot.model.exam.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExamMapperTest {
    @Resource
    private ExamMapper examMapper;

    @Test
    @DisplayName("成功修改学生信息")
    void updateStudentSuccess() {
        Student student = new Student(1, "201815001", "张三", "男", 25, "CS", null);
        int i = examMapper.updateStudent(student);
        assertEquals(1, i);
        System.out.println("修改成功");
    }

    @Test
    @DisplayName("错误修改学生信息")
    public void updateStudentWorry(){
        // 让学号与其他同学学号一致
        Student student = new Student(0, "201815002", "张三", "男", 25, "CS", null);
        int i = examMapper.updateStudent(student);
        assertEquals(1, i);
    }

    @Test
    @DisplayName("成功查询课程信息")
    public void testQueryCourse(){
        // 查询课程号为null，课程名为null，先修课id为1，学分大于2的所有课程
        List<Cource> cources = examMapper.queryCourse(null, null, 1, 2);
        cources.forEach(System.out::println);
    }

    @Test
    @DisplayName("错误查询课程信息")
    public void QueryCourseWorry(){
        // 令课程号与课程名不在同一个课程
        List<Cource> courses = examMapper.queryCourse("6324567", "操作系统", null, null);
        assertTrue(courses.size() >= 1, () -> "课程号与课程名不匹配则查询失败");
    }

    @Test
    @DisplayName("成功查询每个学生的选课信息")
    public void testSc(){
        List<Student> scResults = examMapper.queryAllStudentSc();
        scResults.forEach(System.out::println);
    }

}