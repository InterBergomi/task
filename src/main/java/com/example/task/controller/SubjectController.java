package com.example.task.controller;

import com.example.task.entity.po.Subject;
import com.example.task.entity.vo.SubjectLessonPageVo;
import com.example.task.entity.vo.SubjectLessonVo;
import com.example.task.form.SubjectLessonQueryForm;
import com.example.task.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.controller
 * @description:
 * @createTime: 2020-05-24 00:33
 */
@RestController
@RequestMapping("/subject")
@Api(description = "科目操作接口")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有科目")
    public List<Subject> findAllSubject() {
        List<Subject> allSubjectList = this.subjectService.findAllSubjectList();
        return allSubjectList;
    }

/*
    @RequestMapping(value = "/findAll/test", method = RequestMethod.GET)
    public ModelAndView findAllSubjectTest() {
        List<Subject> resultList = this.subjectService.findAllSubjectList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("initialPage");
        modelAndView.addObject("resultList", resultList);
        modelAndView.addObject("result", "hello world");
        return modelAndView;
    }
*/

    @RequestMapping(value = "/findSubjectLesson/test", method = RequestMethod.POST)
    @ApiOperation(value = "查询学科课程（接口）")
    public SubjectLessonPageVo findSubjectLessonTest(SubjectLessonQueryForm form) {
        SubjectLessonPageVo result = this.subjectService.findSubjectLessonList(form);
        return result;
    }

    @RequestMapping(value = "/findSubjectLesson", method = RequestMethod.GET)
    @ApiOperation(value = "查询学科课程（直接返回modelAndView）")
    public ModelAndView findSubjectLesson(SubjectLessonQueryForm form) {
        SubjectLessonPageVo result = this.subjectService.findSubjectLessonList(form);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("initialPage");
        modelAndView.addObject("resultList", result.getSubjectLessonVoList());
        modelAndView.addObject("gradeList", result.getGradeList());
        modelAndView.addObject("subjectList", result.getSubjectList());
        //modelAndView.addObject("lessonStartDate", result.getLessonStartDate());
        //modelAndView.addObject("lessonEndDate", result.getLessonEndDate());
        modelAndView.addObject("lessonStartDateList", result.getLessonStartDateList());
        modelAndView.addObject("lessonEndDateList", result.getLessonEndDateList());
        return modelAndView;
    }

}
