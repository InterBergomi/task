package com.example.task.service;

import com.example.task.entity.po.Stage;
import com.example.task.entity.po.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.service
 * @description:
 * @createTime: 2020-05-24 00:30
 */
public interface StageService {

    List<Stage> findAllStageList();

}
