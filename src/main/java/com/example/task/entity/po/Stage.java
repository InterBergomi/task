package com.example.task.entity.po;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "stage")
public class Stage implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "stage_id")
	private Long stageId;

	@Column(name = "stage_code")
	private String stageCode;

	@Column(name = "stage_name")
	private String stageName;

}
