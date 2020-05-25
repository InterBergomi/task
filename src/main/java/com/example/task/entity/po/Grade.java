package com.example.task.entity.po;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "grade")
public class Grade implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "grade_id")
	private Long gradeId;

	@Column(name = "grade_code")
	private String gradeCode;

	@Column(name = "grade_name")
	private String gradeName;

	@Column(name = "stage_id")
	private Long stageId;

}
