package com.appconsecurity.esbao.pdf;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appconsecurity.esbao.persistence.entities.CitatorioEntity;
import com.appconsecurity.esbao.services.ICitatorioService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.*;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CitatorioReportGenerator {

    private static final Logger logger = LoggerFactory.getLogger(CitatorioReportGenerator.class);

    @Autowired
    private ICitatorioService citatorioService;

    public byte[] generateReportCitatorio(Long id) throws JRException {
        logger.info("Iniciando generación de reporte para citatorio con ID: {}", id);

        String filePath = "src" + File.separator +
                "main" + File.separator +
                "resources" + File.separator +
                "templates" + File.separator +
                "report" + File.separator +
                "Report_citatorio.jrxml";

        logger.info("Buscando citatorio con ID: {}", id);

        Optional<CitatorioEntity> citatorioOptional = citatorioService.getCitatorioById(id);
        if (!citatorioOptional.isPresent()) {
            logger.warn("No se encontró el citatorio con ID: {}", id);
            throw new RuntimeException("Citatorio no encontrado con ID: " + id);
        }
        CitatorioEntity citatorio = citatorioOptional.get();
        logger.info("Citatorio encontrado: {}", citatorio);
        List<CitatorioEntity> citatorioList = List.of(citatorio);

        JasperReport report = JasperCompileManager.compileReport(filePath);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(citatorioList);
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("dia_citatorio", citatorio.getDia_citatorio());
        parameters.put("mes_citatorio", citatorio.getMes_citatorio());
        parameters.put("ano_citatorio", citatorio.getAno_citatorio());
        parameters.put("asunto", citatorio.getAsunto());
        parameters.put("departamento", citatorio.getDepartamento());

        LocalTime localTime = citatorio.getHora_citatorio();
        Time sqlTime = Time.valueOf(localTime);
        parameters.put("hora_citatorio", sqlTime);

        if (citatorio.getAlumno() != null) {
            parameters.put("alumno.nombre_alumno", citatorio.getAlumno().getNombre_alumno());
            parameters.put("alumno.primer_apellido", citatorio.getAlumno().getPrimer_apellido());
            parameters.put("alumno.segundo_apellido", citatorio.getAlumno().getSegundo_apellido());
            parameters.put("alumno.grado", citatorio.getAlumno().getGrado());
            parameters.put("alumno.grupo", citatorio.getAlumno().getGrupo());
        }

        if (citatorio.getTutor() != null) {
            parameters.put("tutor.nombre_tutor", citatorio.getTutor().getNombre_tutor());
        }

        // Convertir LocalDate a java.sql.Date
        if (citatorio.getFecha_citatorio() != null) {
            Date sqlDate = Date.valueOf(citatorio.getFecha_citatorio());
            parameters.put("fecha_citatorio", sqlDate);
        }

        parameters.put("imageCitatorio", "classpath:/static/images/");

        JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
        byte[] pdfBytes = JasperExportManager.exportReportToPdf(print);

        // Guardar el PDF en el servidor (opcional)
//        String fileName = "Reporte_citatorio_" + id + ".pdf";
//        String saveFilePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + fileName;
//        try (FileOutputStream fos = new FileOutputStream(saveFilePath)) {
//            fos.write(pdfBytes);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        logger.info("Reporte generado exitosamente para citatorio con ID: {}", id);
        return pdfBytes;
    }
}