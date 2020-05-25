package com.example.task.entity.po;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "subject")
public class Subject implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "subject_id")
	private Long subjectId;

	@Column(name = "subject_code")
	private String subjectCode;

	@Column(name = "subject_name")
	private String subjectName;

}
