package com.example.task.entity.po;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "lesson")
public class Lesson implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "lesson_id")
	private Long lessonId;

	@Column(name = "lesson_name")
	private String lessonName;

	@Column(name = "subject_code")
	private String subjectCode;

	@Column(name = "grade_code")
	private String gradeCode;

	@Column(name = "teacher_name")
	private String teacherName;

	@Column(name = "lesson_duration")
	private String lessonDuration;

	@Column(name = "lesson_start_date")
	private String lessonStartDate;

	@Column(name = "lesson_end_date")
	private String lessonEndDate;

	@Column(name = "register_quantity_string")
	private String registerQuantityString;

	@Column(name = "register_quantity")
	private Long registerQuantity;

	@Column(name = "original_price_string")
	private String originalPriceString;

	@Column(name = "original_price")
	private Long originalPrice;

	@Column(name = "actual_price_string")
	private String actualPriceString;

	@Column(name = "actual_price")
	private Long actualPrice;

}
