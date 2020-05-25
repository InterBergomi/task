package com.example.task.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.form
 * @description:
 * @createTime: 2020-05-24 10:16
 */
@Data
@ApiModel(description = "学科课程数量查询入参")
public class SubjectLessonQueryForm {

    @ApiModelProperty(value = "学科编码")
    private String subjectCode;

    @ApiModelProperty(value = "年级编码")
    private String gradeCode;

    @ApiModelProperty(value = "课程时间筛选开始：yyyy-MM-dd")
    private String lessonStartDate;

    @ApiModelProperty(value = "课程时间筛选结束：yyyy-MM-dd")
    private String lessonEndDate;

}
