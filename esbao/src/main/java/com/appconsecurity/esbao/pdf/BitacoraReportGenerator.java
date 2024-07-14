package com.appconsecurity.esbao.pdf;

import com.appconsecurity.esbao.persistence.entities.BitacoraEntity;
import com.appconsecurity.esbao.services.IBitacoraService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BitacoraReportGenerator {

    private static final Logger logger = LoggerFactory.getLogger(BitacoraReportGenerator.class);


    @Autowired
    private IBitacoraService bitacoraService;

    public byte[] generateReportBitacora(Long id) throws JRException {
        logger.info("Iniciando generación de reporte para bitácora con ID: {}", id);

        String filePath = "src" + File.separator +
                "main" + File.separator +
                "resources" + File.separator +
                "templates" + File.separator +
                "report" + File.separator +
                "Report_bitacora.jrxml";

        logger.info("Buscando bitácora con ID: {}", id);

        Optional<BitacoraEntity> bitacoraOptional = bitacoraService.getBitacoraById(id);
        if (!bitacoraOptional.isPresent()) {
            logger.warn("No se encontró la bitácora con ID: {}", id);
            throw new RuntimeException("Bitácora no encontrada con ID: " + id);
        }
        BitacoraEntity bitacora = bitacoraOptional.get();
        logger.info("Bitácora encontrada: {}", bitacora);
        List<BitacoraEntity> bitacoraList = List.of(bitacora);

        JasperReport report = JasperCompileManager.compileReport(filePath);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(bitacoraList);
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("dia_bitacora", bitacora.getDia_bitacora());
        parameters.put("mes_bitacora", bitacora.getMes_bitacora());
        parameters.put("anio", bitacora.getAnio());
        parameters.put("insidencia", bitacora.getInsidencia());

        LocalTime localTime = bitacora.getHora_bitacora();
        Time sqlTime = Time.valueOf(localTime);
        parameters.put("hora_bitacora", sqlTime);

        if (bitacora.getAlumno() != null) {
            parameters.put("alumno.nombre_alumno", bitacora.getAlumno().getNombre_alumno());
            parameters.put("alumno.primer_apellido", bitacora.getAlumno().getPrimer_apellido());
            parameters.put("alumno.segundo_apellido", bitacora.getAlumno().getSegundo_apellido());
            parameters.put("alumno.grado", bitacora.getAlumno().getGrado());
            parameters.put("alumno.grupo", bitacora.getAlumno().getGrupo());
        }

        if (bitacora.getUser() != null) {
            parameters.put("users.nombre_usuario", bitacora.getUser().getNombre_usuario());
        }

        parameters.put("imageBitacora", "classpath:/static/images/");

        JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
        byte[] pdfBytes = JasperExportManager.exportReportToPdf(print);

        // Guardar el PDF en el servidor (opcional)
//        String fileName = "Reporte_bitacora_" + id + ".pdf";
//        String saveFilePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + fileName;
//        try (FileOutputStream fos = new FileOutputStream(saveFilePath)) {
//            fos.write(pdfBytes);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        logger.info("Reporte generado exitosamente para bitácora con ID: {}", id);
        return pdfBytes;
    }
}