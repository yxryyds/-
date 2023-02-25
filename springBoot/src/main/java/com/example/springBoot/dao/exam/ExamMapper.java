package com.example.springBoot.dao.exam;

import com.example.springBoot.model.exam.Cource;
import com.example.springBoot.model.exam.ScResult;
import com.example.springBoot.model.exam.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ExamMapper {
    /**
     * 修改学生信息表中的学生学号，姓名，性别，年龄以及所在院系。如果修改后的学号与其他同学
     * 学号一致，则修改失败
     */
    public int updateStudent(Student s);

    /**
     *查询课程信息
     * 查询条件中包含课程号，课程名，先修课程id以及学分，返回符合查询条件的课程信息。
     */

    public List<Cource> queryCourse(
            String courseNo,
            String courseName,
            Integer priorId,
            Integer credit);

    /**
     * 返回所有学生的选课信息，要求结果中包含学生信息，以及选课信息，
     * 不需要把课程详情列出，必须使用关联映射实现。
     */
    public List<Student> queryAllStudentSc();
}

