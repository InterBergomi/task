package com.example.task.service;

import com.example.task.entity.po.Subject;
import com.example.task.entity.vo.SubjectLessonPageVo;
import com.example.task.entity.vo.SubjectLessonVo;
import com.example.task.form.SubjectLessonQueryForm;

import java.util.List;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.service
 * @description:
 * @createTime: 2020-05-24 00:30
 */
public interface SubjectService {

    /**
     * 查询所有科目
     * @return
     */
    List<Subject> findAllSubjectList();

    /**
     * 查询学科课程的初始页面
     * @param form
     * @return
     */
    SubjectLessonPageVo findSubjectLessonList(SubjectLessonQueryForm form);

}
