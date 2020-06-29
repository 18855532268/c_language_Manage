package com.aust.clanguagemanage.service;

import com.alibaba.fastjson.JSONObject;
import com.aust.clanguagemanage.constant.ConstantsForDomain;
import com.aust.clanguagemanage.domain.CorUser;
import com.aust.clanguagemanage.entity.Course;
import com.aust.clanguagemanage.exception.ErrorMessageException;
import com.aust.clanguagemanage.mapper.CoruserMapper;
import com.aust.clanguagemanage.mapper.CourseMapper;
import com.aust.clanguagemanage.mapper.MaterialsMapper;
import com.aust.clanguagemanage.util.CommonUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CoruserMapper coruserMapper;
    @Value("${upload.temp}")
    private String tempFilePath;
    @Autowired
    private MaterialsMapper materialsMapper;

    public void getCourseInfoById(Integer id) {
        CommonUtil.checkParameters(id);
        Course course = courseMapper.findCourseById(id);
        CorUser teacherId = coruserMapper.findCorUserByCouIdAndUserRole(course.getId(),
                ConstantsForDomain.ROLE_TEACHER);

    }

    // 前端测试用
    public Course getCourse(Integer id) {
        Course course = courseMapper.findCourseById(id);
        return course;
    }

    @SneakyThrows
    public void addMaterials(Integer couId, MultipartFile pointFile, MultipartFile planFile, MultipartFile lessonFile, Integer userId) {
        log.info("上传文件");
        Materials materials = new Materials();
        CommonUtil.checkParameters(couId);
        if (pointFile != null) {
            String pointPath = upload(pointFile);
            materials.setPoint(pointPath);
        }
        if (planFile != null) {
            String planPath = upload(planFile);
            materials.setPlan(planPath);
        }
        if (lessonFile != null) {
            String lessonPath = upload(lessonFile);
            materials.setLesson(lessonPath);
        }
        materials.setCouId(couId);
        materials.setUserId(userId);
        materialsMapper.save(materials);
        log.info("课件上传：{}", JSONObject.toJSONString(materials));
    }

    private String upload(MultipartFile file) throws IOException {
        String transFilePath = null;
        if (file != null) {
            String fileName = file.getOriginalFilename();
            if (StringUtils.isBlank(fileName)) {
                throw new ErrorMessageException("上传的文件名错误");
            }
//            String substring = fileName.substring(fileName.lastIndexOf("."));
            transFilePath = tempFilePath  + "/" + fileName ;
            log.info("上传图片路径:{}", transFilePath);
            file.transferTo(new File(transFilePath));
        }
        return transFilePath;
    }

    public List<MaterialsVo> getMaterials(Integer couId) {
        List<Materials> materials = materialsMapper.findMaterialsByCouId(couId);

        return MaterialsVo.of(materials);

    }

    public void uploadMaterialsPoint(Integer couId, MultipartFile pointFile, Integer userId) throws IOException {
        log.info("上传文件：{}", JSONObject.toJSONString(pointFile.getName()));
        Materials materials = new Materials();
        CommonUtil.checkParameters(couId);
        String pointPath = upload(pointFile);
        materials.setPoint(pointPath);

        materials.setCouId(couId);
        materials.setUserId(userId);
        materialsMapper.save(materials);
        log.info("课件上传：{}", JSONObject.toJSONString(materials));
    }
    /**
     * 配置上传文件大小的配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize("10MB");
        /// 总上传数据大小
        factory.setMaxRequestSize("10MB");
        return factory.createMultipartConfig();
    }
}
