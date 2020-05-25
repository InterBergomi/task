package com.example.task.repository;

import com.example.task.entity.po.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.repository
 * @description:
 * @createTime: 2020-05-24 00:29
 */
public interface LessonRepository extends
        JpaRepository<Lesson, String>, JpaSpecificationExecutor {

    List<Lesson> findAll();

    List<Lesson> findAllBySubjectCodeContainingAndGradeCodeContainingAndLessonStartDateGreaterThanEqualAndLessonEndDateLessThanEqual(
            String subjectCode, String gradeCode, String lessonStartDate, String lessonEndDate);

    List<Lesson> findAllBySubjectCodeContaining(String subjectCode);

}
