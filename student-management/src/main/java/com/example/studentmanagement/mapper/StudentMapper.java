package com.example.studentmanagement.mapper;

import com.example.studentmanagement.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    //Select * from student where name like %T%
    @Select("Select * from student where name like #{name}")
    List<Student> getStudentsContainStringName(@Param("name") String name);

    //Select * from student where university_class_id IN
    //(Select id from university_class where year = 2021 And number =1);
    @Select("Select * from student where university_class_id IN " +
            "(Select id from university_class where year = #{year} And number = #{number})")
    List<Student> getStudentInClass(@Param("year") int year, @Param("number") int number);
}
