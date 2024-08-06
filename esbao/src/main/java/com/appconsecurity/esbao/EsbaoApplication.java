package com.appconsecurity.esbao;

import com.appconsecurity.esbao.config.CustomCorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CorsFilter;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class EsbaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsbaoApplication.class, args);
	}



}

