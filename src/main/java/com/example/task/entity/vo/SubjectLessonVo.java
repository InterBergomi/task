package com.example.task.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.entity.vo
 * @description:
 * @createTime: 2020-05-24 10:14
 */
@Data
@ApiModel(description = "学科课程数量查询结果")
public class SubjectLessonVo {

    @ApiModelProperty(value = "序号")
    private Integer sequence;

    @ApiModelProperty(value = "科目id")
    private Long subjectId;

    @ApiModelProperty(value = "科目编码")
    private String subjectCode;

    @ApiModelProperty(value = "科目名称")
    private String subjectName;

    @ApiModelProperty(value = "课程数量")
    private Integer lessonQuantity;

}
