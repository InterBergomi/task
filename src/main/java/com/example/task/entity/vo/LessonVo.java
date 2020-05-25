package com.example.task.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.entity.vo
 * @description:
 * @createTime: 2020-05-24 10:04
 */
@Data
@ApiModel(description = "课程详细信息")
public class LessonVo {

    @ApiModelProperty(value = "序号")
    private Integer sequence;

    @ApiModelProperty(value = "课程id")
    private Long lessonId;

    @ApiModelProperty(value = "课程名称")
    private String lessonName;

    @ApiModelProperty(value = "科目编码")
    private String subjectCode;

    @ApiModelProperty(value = "科目名称")
    private String subjectName;

    @ApiModelProperty(value = "年级编码")
    private String gradeCode;

    @ApiModelProperty(value = "年级名称")
    private String gradeName;

    @ApiModelProperty(value = "教师名称")
    private String teacherName;

    @ApiModelProperty(value = "开课区间")
    private String lessonDuration;

    @ApiModelProperty(value = "开课时间开始：yyyy-MM-dd")
    private String lessonStartDate;

    @ApiModelProperty(value = "开课时间结束：yyyy-MM-dd")
    private String lessonEndDate;

    @ApiModelProperty(value = "课程原价")
    private Long originalPrice;

    @ApiModelProperty(value = "课程实价")
    private Long actualPrice;

}
