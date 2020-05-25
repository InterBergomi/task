package com.example.task.service.impl;

import com.example.task.entity.po.Grade;
import com.example.task.entity.po.Lesson;
import com.example.task.entity.po.Subject;
import com.example.task.entity.vo.LessonVo;
import com.example.task.form.LessonQueryForm;
import com.example.task.repository.GradeRepository;
import com.example.task.repository.LessonRepository;
import com.example.task.repository.SubjectRepository;
import com.example.task.service.LessonService;
import com.example.task.service.SubjectService;
import com.example.task.util.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
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
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public List<Lesson> findAllLessonList() {
        List<Lesson> lessonList = this.lessonRepository.findAll();
        return lessonList;
    }

    @Override
    public List<LessonVo> findLessonBySubjectCode(LessonQueryForm form) {
        String subjectCode = "";
        if (!ObjectUtils.isEmpty(form.getSubjectCode())) {
            subjectCode = form.getSubjectCode();
        }
        List<Lesson> lessonList = this.lessonRepository.findAllBySubjectCodeContaining(subjectCode);
        List<LessonVo> lessonVoList = ListUtils.srcListToDesList(lessonList, LessonVo.class);

        //查出年级的基本信息，将gradeCode对应上相应实体类
        List<Grade> gradeList = this.gradeRepository.findAll();
        Map<String, Grade> gradeCodeGradeMap = gradeList.stream().collect(
                Collectors.toMap(Grade::getGradeCode, Function.identity()));

        //查出科目的基本信息，将subjectCode对应上相应实体类
        List<Subject> subjectList = this.subjectRepository.findAll();
        Map<String, Subject> subjectCodeSubjectMap = subjectList.stream()
                .collect(Collectors.toMap(Subject::getSubjectCode, Function.identity()));

        //给个序号，并给subjectName和gradeName赋值
        for (int i = 0; i < lessonVoList.size(); i++) {
            if (!ObjectUtils.isEmpty(gradeCodeGradeMap.get(lessonVoList.get(i).getGradeCode()))) {
                lessonVoList.get(i).setGradeName(gradeCodeGradeMap
                        .get(lessonVoList.get(i).getGradeCode()).getGradeName());
            }
            if (!ObjectUtils.isEmpty(subjectCodeSubjectMap.get(lessonVoList.get(i).getSubjectCode()))) {
                lessonVoList.get(i).setSubjectName(subjectCodeSubjectMap
                        .get(lessonVoList.get(i).getSubjectCode()).getSubjectName());
            }
            lessonVoList.get(i).setSequence(i + 1);
        }

        return lessonVoList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean initializeLessonDate() {
        List<Lesson> allLessonList = this.findAllLessonList();
        List<Lesson> newLessonList = new ArrayList<>();
        allLessonList.stream().forEach(lesson -> {
            if (ObjectUtils.isEmpty(lesson.getLessonStartDate())
                    && ObjectUtils.isEmpty(lesson.getLessonEndDate())) {
                Lesson newLesson = new Lesson();
                BeanUtils.copyProperties(lesson, newLesson);
                String lessonDuration = lesson.getLessonDuration();
                String startDateFromDuration = getStartDateFromDuration(lessonDuration);
                String endDateFromDuration = getEndDateFromDuration(lessonDuration);
                newLesson.setLessonStartDate(startDateFromDuration);
                newLesson.setLessonEndDate(endDateFromDuration);
                newLessonList.add(newLesson);
            }
        });
        this.lessonRepository.saveAll(newLessonList);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean initializeRegisterQuantity() {
        List<Lesson> allLessonList = this.findAllLessonList();
        List<Lesson> newLessonList = new ArrayList<>();
        allLessonList.stream().forEach(lesson -> {
            if (ObjectUtils.isEmpty(lesson.getRegisterQuantity())) {
                Lesson newLesson = new Lesson();
                BeanUtils.copyProperties(lesson, newLesson);
                String registerQuantityString = lesson.getRegisterQuantityString();
                Long registerQuantity = Long.valueOf(registerQuantityString.replace("人报名", ""));
                newLesson.setRegisterQuantity(registerQuantity);
                newLessonList.add(newLesson);
            }
        });
        this.lessonRepository.saveAll(newLessonList);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean initializeOriginalPrice() {
        List<Lesson> allLessonList = this.findAllLessonList();
        List<Lesson> newLessonList = new ArrayList<>();
        allLessonList.stream().forEach(lesson -> {
            if (ObjectUtils.isEmpty(lesson.getOriginalPrice())
                    && !ObjectUtils.isEmpty(lesson.getOriginalPriceString())) {
                Lesson newLesson = new Lesson();
                BeanUtils.copyProperties(lesson, newLesson);
                String originalPriceString = lesson.getOriginalPriceString();
                String originalPriceTemp = originalPriceString.replace("¥", "");
                Long originalPrice = Long.valueOf(originalPriceTemp.replace(" ", ""));
                newLesson.setOriginalPrice(originalPrice);
                newLessonList.add(newLesson);
            }
        });
        this.lessonRepository.saveAll(newLessonList);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean initializeActualPrice() {
        List<Lesson> allLessonList = this.findAllLessonList();
        List<Lesson> newLessonList = new ArrayList<>();
        allLessonList.stream().forEach(lesson -> {
            if (ObjectUtils.isEmpty(lesson.getActualPrice())
                    && !ObjectUtils.isEmpty(lesson.getActualPriceString())) {
                Lesson newLesson = new Lesson();
                BeanUtils.copyProperties(lesson, newLesson);
                String actualPriceString = lesson.getActualPriceString();
                String actualPriceTemp = actualPriceString.replace("¥", "");
                Long actualPrice = Long.valueOf(actualPriceTemp.replace(" ", ""));
                newLesson.setActualPrice(actualPrice);
                newLessonList.add(newLesson);
            }
        });
        this.lessonRepository.saveAll(newLessonList);
        return true;
    }

    private static String getStartDateFromDuration(String lessonDuration) {
        StringBuffer result = new StringBuffer();
        String currentYear = "2020";
        String nextYear = "2021";
        String[] split1 = lessonDuration.split("-");
        String originalStartDate = split1[0];

        String replace1 = originalStartDate.replace("月", "-");
        String replace2 = replace1.replace("日", "-");
        String[] split2 = replace2.split("-");

        //拼接“月”
        if (split2[0].length() == 1) {
            result.append(currentYear).append("-").append("0").append(split2[0]);
        } else if (split2[0].length() == 2) {
            result.append(currentYear).append("-").append(split2[0]);
        }

        //拼接“日”
        if (split2[1].length() == 1) {
            result.append("-").append("0").append(split2[1]);
        } else if (split2[1].length() == 2) {
            result.append("-").append(split2[1]);
        }

        String resultString = result.toString();
        result.setLength(0);

        return resultString;
    }

    private static String getEndDateFromDuration(String lessonDuration) {
        StringBuffer result = new StringBuffer();
        String currentYear = "2020";
        String nextYear = "2021";
        String[] split = lessonDuration.split("-");
        String originalEndDate = split[1];

        String replace1 = originalEndDate.replace("年", "-");
        String replace2 = replace1.replace("月", "-");
        String replace3 = replace2.replace("日", "-");
        String[] split2 = replace3.split("-");

        if (split2.length == 2) {
            //无“年”
            result.append(currentYear);

            //拼接“月”
            if (split2[0].length() == 1) {
                result.append("-").append("0").append(split2[0]);
            } else if (split2[0].length() == 2) {
                result.append("-").append(split2[0]);
            }

            //拼接“日”
            if (split2[1].length() == 1) {
                result.append("-").append("0").append(split2[1]);
            } else if (split2[1].length() == 2) {
                result.append("-").append(split2[1]);
            }

        } else if (split2.length == 3) {
            //有“年”
            String year = originalEndDate.substring(0, 4);
            result.append(year);

            //拼接“月”
            if (split2[1].length() == 1) {
                result.append("-").append("0").append(split2[1]);
            } else if (split2[1].length() == 2) {
                result.append("-").append(split2[1]);
            }

            //拼接“日”
            if (split2[2].length() == 1) {
                result.append("-").append("0").append(split2[2]);
            } else if (split2[2].length() == 2) {
                result.append("-").append(split2[2]);
            }
        }

        String resultString = result.toString();
        result.setLength(0);

        return resultString;
    }

    public static void main(String[] args) {
        String test01 = "9月4日-2021年1月3日";
        String test02 = "7月31日-8月8日";
        String startDateFromDuration01 = getStartDateFromDuration(test01);
        String endDateFromDuration01 = getEndDateFromDuration(test01);
        String startDateFromDuration02 = getStartDateFromDuration(test02);
        String endDateFromDuration02 = getEndDateFromDuration(test02);
    }
}
