package com.example.task.service.impl;

import com.example.task.entity.po.Stage;
import com.example.task.entity.po.Subject;
import com.example.task.repository.StageRepository;
import com.example.task.repository.SubjectRepository;
import com.example.task.service.StageService;
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
public class StageServiceImpl implements StageService {

    @Autowired
    private StageRepository stageRepository;

    @Override
    public List<Stage> findAllStageList() {
        List<Stage> stageList = this.stageRepository.findAll();
        return stageList;
    }
}
