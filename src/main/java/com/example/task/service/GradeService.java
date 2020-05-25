package com.example.task.service;

import com.example.task.entity.po.Grade;
import com.example.task.entity.po.Subject;

import java.util.List;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.service
 * @description:
 * @createTime: 2020-05-24 00:30
 */
public interface GradeService {

    List<Grade> findAllGradeList();

}
