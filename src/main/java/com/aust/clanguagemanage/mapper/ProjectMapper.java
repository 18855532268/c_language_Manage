package com.aust.clanguagemanage.mapper;

import com.aust.clanguage.base.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectMapper extends JpaRepository<Project, Integer> {
        @Query(value = " select * from project limit ?1, ?2"
                ,nativeQuery = true)
    List<Project> findProjectsByPage(Integer page, Integer pageSize);
}
