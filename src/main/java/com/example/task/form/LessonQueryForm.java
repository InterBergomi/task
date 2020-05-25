package com.example.task.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.form
 * @description:
 * @createTime: 2020-05-24 10:04
 */
@Data
@ApiModel(description = "课程详情查询入参")
public class LessonQueryForm {

    @ApiModelProperty(value = "科目编码")
    private String subjectCode;
}
