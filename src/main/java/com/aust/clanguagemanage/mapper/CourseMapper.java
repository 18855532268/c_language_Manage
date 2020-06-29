package com.aust.clanguagemanage.mapper;

import com.aust.clanguagemanage.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseMapper extends JpaRepository<Course, Integer> {

    Course findCourseById(Integer id);
    //    @Query(value = " select insurance_company_id from t_user as user where user.number = ?1 "
//            ,nativeQuery = true)
}