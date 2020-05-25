package com.example.task.controller;

import com.example.task.entity.po.Lesson;
import com.example.task.entity.po.Subject;
import com.example.task.entity.vo.LessonVo;
import com.example.task.form.LessonQueryForm;
import com.example.task.service.LessonService;
import com.example.task.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/lesson")
@Api(description = "课程操作接口")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有课程")
    public List<Lesson> findAllLesson() {
        List<Lesson> allLessonList = this.lessonService.findAllLessonList();
        return allLessonList;
    }

    @RequestMapping(value = "/findLessonBySubjectCode/test", method = RequestMethod.POST)
    @ApiOperation(value = "根据科目编码查询所有课程（接口）")
    public List<LessonVo> findLessonBySubjectCodeTest(LessonQueryForm form) {
        List<LessonVo> lessonList = this.lessonService.findLessonBySubjectCode(form);
        return lessonList;
    }

    @RequestMapping(value = "/findLessonBySubjectCode", method = RequestMethod.GET)
    @ApiOperation(value = "根据科目编码查询所有课程（直接返回modelAndView）")
    public ModelAndView findLessonBySubjectCode(@ModelAttribute(value = "subjectCode") String subjectCode) {
        LessonQueryForm form = new LessonQueryForm() {{
            setSubjectCode(subjectCode);
        }};
        List<LessonVo> lessonList = this.lessonService.findLessonBySubjectCode(form);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("subjectLessonDetailsPage");
        modelAndView.addObject("lessonDetailsList", lessonList);
        return modelAndView;
    }

}
