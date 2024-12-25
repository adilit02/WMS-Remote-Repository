package ait.com.entity;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	private Integer id;
	private String name;
	private String email;
	private String password;
	private String roll;
	private LocalDateTime createdAt = LocalDateTime.now();
}
