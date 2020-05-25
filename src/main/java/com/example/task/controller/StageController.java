package com.example.task.controller;

import com.example.task.entity.po.Stage;
import com.example.task.entity.po.Subject;
import com.example.task.service.StageService;
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
@RequestMapping("/stage")
@Api(description = "阶段操作接口")
public class StageController {

    @Autowired
    private StageService stageService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有阶段")
    public List<Stage> findAllStage() {
        List<Stage> allStageList = this.stageService.findAllStageList();
        return allStageList;
    }

}
