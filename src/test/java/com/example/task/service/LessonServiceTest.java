package com.example.task.service;

import com.example.task.entity.po.Lesson;
import lombok.Data;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.service
 * @description:
 * @createTime: 2020-05-24 09:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = NAME_ASCENDING)
public class LessonServiceTest {

    @Autowired
    private LessonService lessonService;

    @Test
    public void test01initializeLesson() {
        try {
            Boolean result1 = this.lessonService.initializeLessonDate();
            Boolean result2 = this.lessonService.initializeRegisterQuantity();
            Boolean result3 = this.lessonService.initializeOriginalPrice();
            Boolean result4 = this.lessonService.initializeActualPrice();
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}
