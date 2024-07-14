package com.appconsecurity.esbao;

import com.appconsecurity.esbao.pdf.BitacoraReportGenerator;
import com.appconsecurity.esbao.pdf.CitatorioReportGenerator;
import com.appconsecurity.esbao.persistence.entities.BitacoraEntity;
import com.appconsecurity.esbao.persistence.repositories.BitacoraRepository;
import com.appconsecurity.esbao.services.IBitacoraService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

