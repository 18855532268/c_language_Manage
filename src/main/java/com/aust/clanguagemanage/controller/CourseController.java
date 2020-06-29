package com.aust.clanguagemanage.controller;


import com.aust.clanguagemanage.service.CourseService;
import com.aust.clanguagemanage.vo.ReturnVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 课程相关
 */
@Slf4j
@RestController
@RequestMapping("/course")
@Api(description = "课程管理")
public class CourseController {
    @Autowired
    private CourseService courseService;


//    @GetMapping("/course/info")
//    @ApiOperation(value = "课程详情", notes = "传入课程id")
//    @ApiImplicitParam(value = "信息id", name = "id", paramType = "query", dataType = "String", required = true)
//    public ReturnVO getCourseInfo(String id) {
//        return ReturnVO.getSuccess();
//    }

    @ApiOperation(value = "获取课程", notes = "传入课程id")
    @ApiImplicitParam(value = "信息id", name = "id", paramType = "query", dataType = "String", required = true)
    @GetMapping("/getCourse")
    public ReturnVO getCourse(String id) {
        return ReturnVO.getSuccess(courseService.getCourse(Integer.valueOf(id)));
    }

    @SneakyThrows
    @PostMapping("/uploadMaterials")
    public ReturnVO uploadMaterials(Integer couId, MultipartFile pointFile, MultipartFile planFile, MultipartFile lessonFile, Integer userId) {
        courseService.addMaterials(couId, pointFile, planFile, lessonFile, userId);
        return ReturnVO.getSuccess();
    }
    @ApiOperation(value = "上传课件", notes = "传入couId，pointFile，userId")
    @SneakyThrows
    @PostMapping("/uploadMaterialsPoint")
    public ReturnVO uploadMaterialsPoint(Integer couId, MultipartFile pointFile, Integer userId) {
        courseService.uploadMaterialsPoint(couId, pointFile, userId);
        return ReturnVO.getSuccess();
    }
    @ApiOperation(value = "获取课件url", notes = "传入课程id")
    @ApiImplicitParam(value = "couId", name = "couId", paramType = "query", dataType = "Integer", required = true)
    @GetMapping("/getMaterials")
    public ReturnVO getMaterials(Integer couId) {
        return ReturnVO.getSuccess(courseService.getMaterials(couId));
    }


}
