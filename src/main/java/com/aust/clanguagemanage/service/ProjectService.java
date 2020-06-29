package com.aust.clanguagemanage.service;

import com.alibaba.fastjson.JSONObject;
import com.aust.clanguage.base.domain.Project;
import com.aust.clanguage.base.mapper.ProjectMapper;
import com.aust.clanguage.base.vo.project.ProjectVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    public List<ProjectVo> getProjectList(Integer page, Integer pageSize){
        List<Project> list = projectMapper.findProjectsByPage(page, pageSize);
        log.info("项目返回：{}", JSONObject.toJSONString(list));
        return ProjectVo.of(list);
    }
}
