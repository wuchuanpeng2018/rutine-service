package com.onecard;

import com.onecard.annotations.Todo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnecardRutineAnnotationsServiceApplication {

	@Todo(author = "wuchp1", priority = Todo.Priority.L, status = Todo.Status.NO_STATU)
	public static void main(String[] args) {
		SpringApplication.run(OnecardRutineAnnotationsServiceApplication.class, args);
	}

	@Todo(author = "wuchp2", priority = Todo.Priority.L, status = Todo.Status.NO_STATU)
	public void ss() {

	}

}
