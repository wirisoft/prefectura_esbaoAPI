package com.appconsecurity.esbao.persistence.entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "alumno")
public class AlumnoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumno_id")
    private Long id;

    @Column(name = "nombre_alumno")
    private String nombre_alumno;

    @Column(name = "primer_apellido")
    private String primer_apellido;

    @Column(name = "segundo_apellido")
    private String segundo_apellido;

    @Column(name = "turno")
    private String turno;

    @Column(name = "grado")
    private String grado;

    @Column(name = "grupo")
    private String grupo;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "area_especialidad")
    private String area_especialidad;

    @Column(name = "telefono_alumno")
    private String telefono_alumno;

    // relaciones
    @OneToMany(mappedBy = "alumno")
    private List<AlumnoTutorEntity> alumnoTutorEntities;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private TutorEntity tutor;

    public TutorEntity getTutor() {
        return tutor;
    }

    public void setTutor(TutorEntity tutor) {
        this.tutor = tutor;
    }

    // getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getArea_especialidad() {
        return area_especialidad;
    }

    public void setArea_especialidad(String area_especialidad) {
        this.area_especialidad = area_especialidad;
    }

    public String getTelefono_alumno() {
        return telefono_alumno;
    }

    public void setTelefono_alumno(String telefono_alumno) {
        this.telefono_alumno = telefono_alumno;
    }



    public List<AlumnoTutorEntity> getAlumnoTutorEntities() {
        return alumnoTutorEntities;
    }

    public void setAlumnoTutorEntities(List<AlumnoTutorEntity> alumnoTutorEntities) {
        this.alumnoTutorEntities = alumnoTutorEntities;
    }

    public Optional<Object> getAlumnosTutores() {
        return Optional.empty();
    }
}
