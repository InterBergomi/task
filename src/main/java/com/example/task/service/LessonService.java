package com.example.task.service;

import com.example.task.entity.po.Lesson;
import com.example.task.entity.vo.LessonVo;
import com.example.task.form.LessonQueryForm;

import java.util.List;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.service
 * @description:
 * @createTime: 2020-05-24 00:30
 */
public interface LessonService {

    /**
     * 无条件查询所有课程
     * @return
     */
    List<Lesson> findAllLessonList();

    /**
     * @param form
     * @return
     */
    List<LessonVo> findLessonBySubjectCode(LessonQueryForm form);

    /**
     * @return
     */
    Boolean initializeLessonDate();

    /**
     * @return
     */
    Boolean initializeRegisterQuantity();

    /**
     * @return
     */
    Boolean initializeOriginalPrice();

    /**
     * @return
     */
    Boolean initializeActualPrice();

}
