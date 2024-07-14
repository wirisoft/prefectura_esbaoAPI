package com.appconsecurity.esbao.persistence.entities;


import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "bitacora")
public class BitacoraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bitacora_id")
    private Long id;

    @Column(name="dia_bitacora")
    private int dia_bitacora;

    @Column(name="hora_bitacora")
    private LocalTime hora_bitacora;

    @Column(name = "mes_bitacora")
    private String mes_bitacora;

    @Column(name = "anio")
    private int anio;

    @Column(name = "insidencia")
    private String insidencia;

    @Column(name = "pdf_bitacora")
    private byte[] pdf_bitacora;

    @Column(name = "evidencia_img", columnDefinition = "bytea")
    private byte[] evidencia_img;

    public LocalTime getHora_bitacora() {
        return hora_bitacora;
    }

    public void setHora_bitacora(LocalTime hora_bitacora) {
        this.hora_bitacora = hora_bitacora;
    }

//relaciones

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private AlumnoEntity alumno;

    public AlumnoEntity getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoEntity alumno) {
        this.alumno = alumno;
    }

    public int getDia_bitacora() {
        return dia_bitacora;
    }

    public void setDia_bitacora(int dia_bitacora) {
        this.dia_bitacora = dia_bitacora;
    }
//geters

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMes_bitacora() {
        return mes_bitacora;
    }

    public void setMes_bitacora(String mes_bitacora) {
        this.mes_bitacora = mes_bitacora;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getInsidencia() {
        return insidencia;
    }

    public void setInsidencia(String insidencia) {
        this.insidencia = insidencia;
    }

    public byte[] getPdf_bitacora() {
        return pdf_bitacora;
    }

    public void setPdf_bitacora(byte[] pdf_bitacora) {
        this.pdf_bitacora = pdf_bitacora;
    }

    public byte[] getEvidencia_img() {
        return evidencia_img;
    }

    public void setEvidencia_img(byte[] evidencia_img) {
        this.evidencia_img = evidencia_img;
    }
}
