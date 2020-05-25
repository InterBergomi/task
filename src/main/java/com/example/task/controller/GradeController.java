package com.example.task.controller;

import com.example.task.entity.po.Grade;
import com.example.task.entity.po.Subject;
import com.example.task.service.GradeService;
import com.example.task.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.controller
 * @description:
 * @createTime: 2020-05-24 00:33
 */
@RestController
@RequestMapping("/grade")
@Api(description = "年级操作接口")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有年级")
    public List<Grade> findAllGrade() {
        List<Grade> allGradeList = this.gradeService.findAllGradeList();
        return allGradeList;
    }

}
