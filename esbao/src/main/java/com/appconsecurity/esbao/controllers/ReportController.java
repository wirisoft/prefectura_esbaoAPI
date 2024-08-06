package com.appconsecurity.esbao.controllers;

import com.appconsecurity.esbao.pdf.BitacoraReportGenerator;
import com.appconsecurity.esbao.pdf.CitatorioReportGenerator;
import com.appconsecurity.esbao.persistence.entities.BitacoraEntity;
import com.appconsecurity.esbao.persistence.entities.CitatorioEntity;
import com.appconsecurity.esbao.services.IBitacoraService;
import com.appconsecurity.esbao.services.ICitatorioService;

import net.sf.jasperreports.engine.JRException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "http://vps-4243804-x.dattaweb.com")
@RestController
@RequestMapping("/api/pdf")
public class ReportController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private BitacoraReportGenerator bitacoraReportGenerator;

    @Autowired
    private CitatorioReportGenerator citatorioReportGenerator;

    @Autowired
    private IBitacoraService bitacoraService; // Asegúrate de que IBitacoraService esté correctamente definido y autowired

    @Autowired
    private ICitatorioService citatorioService; // Asegúrate de que ICitatorioService esté correctamente definido y autowired

    @GetMapping("/bitacora/{id}")
    public ResponseEntity<byte[]> getBitacoraPdf(@PathVariable Long id) {
        logger.info("Recibida solicitud para generar PDF de bitácora con ID: {}", id);
        try {
            byte[] pdfBytes = bitacoraReportGenerator.generateReportBitacora(id);
            logger.info("PDF generado exitosamente para bitácora con ID: {}", id);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=bitacora_" + id + ".pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdfBytes);
        } catch (JRException e) {
            logger.error("Error al generar el PDF para bitácora con ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (RuntimeException e) {
            logger.warn("No se encontró la bitácora con ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/citatorio/{id}")
    public ResponseEntity<byte[]> getCitatorioPdf(@PathVariable Long id) {
        logger.info("Recibida solicitud para generar PDF de citatorio con ID: {}", id);
        try {
            byte[] pdfBytes = citatorioReportGenerator.generateReportCitatorio(id);
            logger.info("PDF generado exitosamente para citatorio con ID: {}", id);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=citatorio_" + id + ".pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdfBytes);
        } catch (JRException e) {
            logger.error("Error al generar el PDF para citatorio con ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (RuntimeException e) {
            logger.warn("No se encontró el citatorio con ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/bitacoras")
    public ResponseEntity<List<Map<String, Object>>> getAllBitacorasInfo() {
        try {
            List<BitacoraEntity> bitacoras = bitacoraService.getAllBitacoras(); // Aquí llama al método de servicio para obtener todas las bitácoras
            List<Map<String, Object>> bitacorasInfo = bitacoras.stream()
                    .map(b -> {
                        Map<String, Object> info = new HashMap<>();
                        info.put("id", b.getId()); // Aquí obtienes el ID de la bitácora correctamente
                        info.put("dia", b.getDia_bitacora());
                        info.put("mes", b.getMes_bitacora());
                        info.put("anio", b.getAnio());
                        return info;
                    })
                    .collect(Collectors.toList());
            return ResponseEntity.ok(bitacorasInfo);
        } catch (Exception e) {
            logger.error("Error al obtener la información de todas las bitácoras", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/citatorios")
    public ResponseEntity<List<Map<String, Object>>> getAllCitatoriosInfo() {
        try {
            List<CitatorioEntity> citatorios = citatorioService.getAllCitatorios(); // Aquí llama al método de servicio para obtener todos los citatorios
            List<Map<String, Object>> citatoriosInfo = citatorios.stream()
                    .map(c -> {
                        Map<String, Object> info = new HashMap<>();
                        info.put("id", c.getId()); // Aquí obtienes el ID del citatorio correctamente
                        info.put("dia", c.getDia_citatorio());
                        info.put("mes", c.getMes_citatorio());
                        info.put("anio", c.getAno_citatorio());
                        return info;
                    })
                    .collect(Collectors.toList());
            return ResponseEntity.ok(citatoriosInfo);
        } catch (Exception e) {
            logger.error("Error al obtener la información de todos los citatorios", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
