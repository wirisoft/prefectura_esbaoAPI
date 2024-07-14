package com.appconsecurity.esbao.persistence.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "citatorio")
public class CitatorioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "citatorio_id")
    private Long id;

    @Column(name = "nombre_citatorio")
    private String nombre_citatorio;

    @Column(name = "asunto")
    private String asunto;

    @Column(name = "dia_citatorio")
    private Integer dia_citatorio;

    @Column(name = "mes_citatorio")
    private String mes_citatorio;

    @Column(name = "ano_citatorio")
    private String ano_citatorio;

    @Column(name = "hora_citatorio")
    private LocalTime hora_citatorio;

    @Column(name = "fecha_citatorio")
    private LocalDate fecha_citatorio;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "pdf_citatorio")
    private byte[] pdf_citatorio;

    //relaciones
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity users;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private AlumnoEntity alumno;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private TutorEntity tutor;


    public Integer getDia_citatorio() {
        return dia_citatorio;
    }

    public void setDia_citatorio(Integer dia_citatorio) {
        this.dia_citatorio = dia_citatorio;
    }

    public String getMes_citatorio() {
        return mes_citatorio;
    }

    public void setMes_citatorio(String mes_citatorio) {
        this.mes_citatorio = mes_citatorio;
    }

    public String getAno_citatorio() {
        return ano_citatorio;
    }

    public void setAno_citatorio(String ano_citatorio) {
        this.ano_citatorio = ano_citatorio;
    }

    public TutorEntity getTutor() {
        return tutor;
    }

    public void setTutor(TutorEntity tutor) {
        this.tutor = tutor;
    }

    public AlumnoEntity getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoEntity alumno) {
        this.alumno = alumno;
    }



    public UserEntity getUsers() {
        return users;
    }

    public void setUsers(UserEntity users) {
        this.users = users;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_citatorio() {
        return nombre_citatorio;
    }

    public void setNombre_citatorio(String nombre_citatorio) {
        this.nombre_citatorio = nombre_citatorio;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public LocalTime getHora_citatorio() {
        return hora_citatorio;
    }

    public void setHora_citatorio(LocalTime hora_citatorio) {
        this.hora_citatorio = hora_citatorio;
    }

    public LocalDate getFecha_citatorio() {
        return fecha_citatorio;
    }

    public void setFecha_citatorio(LocalDate fecha_citatorio) {
        this.fecha_citatorio = fecha_citatorio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public byte[] getPdf_citatorio() {
        return pdf_citatorio;
    }

    public void setPdf_citatorio(byte[] pdf_citatorio) {
        this.pdf_citatorio = pdf_citatorio;
    }
}
