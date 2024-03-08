package com.example.deepucasestudyv01;

import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeepuCaseStudyV01Application {

	public static void main(String[] args) {
		SpringApplication.run(DeepuCaseStudyV01Application.class, args);
	}


	public void demo() {
		String cmpDate = "";
		String dueDate = "526563";

		String cmp2Date = "";
		String due2Date = "526563";

		boolean doNothing = false;

        if (Strings.isNotBlank(cmpDate)) {
			doNothing = true;
		} else {
			doNothing = false;
		}

		if (Strings.isNotBlank(cmp2Date)) {
			doNothing = true;
		} else {
			doNothing = false;
		}
	}
}
