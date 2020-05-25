package com.example.task.entity.vo;

import com.example.task.entity.po.Grade;
import com.example.task.entity.po.Subject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.entity.vo
 * @description:
 * @createTime: 2020-05-24 12:38
 */
@Data
@ApiModel(description = "学科课程数量初始页查询结果")
public class SubjectLessonPageVo {

    @ApiModelProperty(value = "学科课程数量查询结果")
    List<SubjectLessonVo> subjectLessonVoList = new ArrayList<>();

    @ApiModelProperty(value = "科目下拉框内容")
    List<Subject> subjectList = new ArrayList<>();

    @ApiModelProperty(value = "年级下拉框内容")
    List<Grade> gradeList = new ArrayList<>();

    @ApiModelProperty(value = "课程筛选时间开始")
    private Date lessonStartDate;

    @ApiModelProperty(value = "课程筛选时间结束")
    private Date lessonEndDate;

    @ApiModelProperty(value = "课程筛选时间开始")
    List<String> lessonStartDateList = new ArrayList<>();

    @ApiModelProperty(value = "课程筛选时间结束")
    List<String> lessonEndDateList = new ArrayList<>();

}
