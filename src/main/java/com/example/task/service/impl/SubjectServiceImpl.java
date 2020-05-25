package com.example.task.service.impl;

import com.example.task.entity.po.Grade;
import com.example.task.entity.po.Lesson;
import com.example.task.entity.po.Subject;
import com.example.task.entity.vo.SubjectLessonPageVo;
import com.example.task.entity.vo.SubjectLessonVo;
import com.example.task.form.SubjectLessonQueryForm;
import com.example.task.repository.GradeRepository;
import com.example.task.repository.LessonRepository;
import com.example.task.repository.SubjectRepository;
import com.example.task.service.SubjectService;
import com.example.task.util.DateTimeUtils;
import com.example.task.util.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.service.impl
 * @description:
 * @createTime: 2020-05-24 00:31
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public List<Subject> findAllSubjectList() {
        List<Subject> subjectList = this.subjectRepository.findAll();
        return subjectList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SubjectLessonPageVo findSubjectLessonList(SubjectLessonQueryForm form) {
        //统计每天的各个学科课程数量。可以查看历史数据。

        //挨个处理入参，避免空值
        String lessonStartDate;
        if (ObjectUtils.isEmpty(form.getLessonStartDate())) {
            lessonStartDate = "2020-02-21";
        } else {
            lessonStartDate = form.getLessonStartDate();
        }
        String lessonEndDate;
        if (ObjectUtils.isEmpty(form.getLessonEndDate())) {
            lessonEndDate = "2021-01-03";
        } else {
            lessonEndDate = form.getLessonEndDate();
        }
        String formSubjectCode;
        if (ObjectUtils.isEmpty(form.getSubjectCode())) {
            formSubjectCode = "";
        } else {
            formSubjectCode = form.getSubjectCode();
        }
        String formGradeCode;
        if (ObjectUtils.isEmpty(form.getGradeCode())) {
            formGradeCode = "";
        } else {
            formGradeCode = form.getGradeCode();
        }

        //查出所有年级
        List<Grade> gradeList = this.gradeRepository.findAll();

        //查出所有科目，并建立科目编码和数据库实体类的联系
        List<Subject> subjectList = this.subjectRepository.findAll();
        Map<String, Subject> subjectCodeSubjectMap = subjectList.stream()
                .collect(Collectors.toMap(Subject::getSubjectCode, Function.identity()));

        //查出符合条件的课程
        List<Lesson> lessonList = this.lessonRepository
                .findAllBySubjectCodeContainingAndGradeCodeContainingAndLessonStartDateGreaterThanEqualAndLessonEndDateLessThanEqual(
                        formSubjectCode, formGradeCode, lessonStartDate, lessonEndDate);
        Map<String, List<Lesson>> subjectCodeLessonListMap = lessonList
                .stream().collect(Collectors.groupingBy(Lesson::getSubjectCode));

        //对表格数据进行赋值
        List<SubjectLessonVo> resultList = new ArrayList<>();
        for (Map.Entry<String, List<Lesson>> entry: subjectCodeLessonListMap.entrySet()) {
            String subjectCode = entry.getKey();
            List<Lesson> tempLessonList = entry.getValue();
            SubjectLessonVo vo = new SubjectLessonVo();
            vo.setSubjectCode(subjectCode);
            vo.setSubjectId(subjectCodeSubjectMap.get(subjectCode).getSubjectId());
            vo.setSubjectName(subjectCodeSubjectMap.get(subjectCode).getSubjectName());
            vo.setLessonQuantity(tempLessonList.size());
            resultList.add(vo);
        }

        //根据subjectId排序
        resultList.sort(new Comparator<SubjectLessonVo>() {
            @Override
            public int compare(SubjectLessonVo o1, SubjectLessonVo o2) {
                return o1.getSubjectId().compareTo(o2.getSubjectId());
            }
        });

        //给一个序号
        for (int i = 0; i < resultList.size(); i++) {
            resultList.get(i).setSequence(i + 1);
        }

        SubjectLessonPageVo pageVo = new SubjectLessonPageVo();
        pageVo.setSubjectLessonVoList(resultList);
        pageVo.setSubjectList(subjectList);
        pageVo.setGradeList(gradeList);
        pageVo.setLessonStartDateList(DateTimeUtils.getEveryDay("2020-02-21", "2021-01-03"));
        pageVo.setLessonEndDateList(DateTimeUtils.getEveryDay("2020-02-21", "2021-01-03"));
        pageVo.setLessonStartDate(DateTimeUtils.strToDate("2020-02-21", "yyyy-MM-dd"));
        pageVo.setLessonEndDate(DateTimeUtils.strToDate("2021-01-03", "yyyy-MM-dd"));

        return pageVo;
    }
}
