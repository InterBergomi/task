package com.example.task.service.impl;

import com.example.task.entity.po.Grade;
import com.example.task.entity.po.Subject;
import com.example.task.repository.GradeRepository;
import com.example.task.repository.SubjectRepository;
import com.example.task.service.GradeService;
import com.example.task.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.service.impl
 * @description:
 * @createTime: 2020-05-24 00:31
 */
@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public List<Grade> findAllGradeList() {
        List<Grade> gradeList = this.gradeRepository.findAll();
        return gradeList;
    }
}
