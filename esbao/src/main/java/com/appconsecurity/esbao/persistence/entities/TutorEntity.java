package com.appconsecurity.esbao.persistence.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tutor")
public class TutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tutor_id")
    private Long id;

    @Column(name = "nombre_tutor")
    private String nombre_tutor;

    @Column(name = "tipo_tutor")
    private String tipo_tutor;

    @Column(name = "telefono_tutor")
    private String telefono_tutor;

    @Column(name = "email_tutor")
    private String email_tutor;

    // relaciones
    @OneToMany(mappedBy = "tutor")
    private List<AlumnoTutorEntity> alumnoTutorEntities;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private AlumnoEntity alumno;

    public AlumnoEntity getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoEntity alumno) {
        this.alumno = alumno;
    }

    // getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_tutor() {
        return nombre_tutor;
    }

    public void setNombre_tutor(String nombre_tutor) {
        this.nombre_tutor = nombre_tutor;
    }

    public String getTipo_tutor() {
        return tipo_tutor;
    }

    public void setTipo_tutor(String tipo_tutor) {
        this.tipo_tutor = tipo_tutor;
    }

    public String getTelefono_tutor() {
        return telefono_tutor;
    }

    public void setTelefono_tutor(String telefono_tutor) {
        this.telefono_tutor = telefono_tutor;
    }

    public String getEmail_tutor() {
        return email_tutor;
    }

    public void setEmail_tutor(String email_tutor) {
        this.email_tutor = email_tutor;
    }

    public List<AlumnoTutorEntity> getAlumnoTutorEntities() {
        return alumnoTutorEntities;
    }

    public void setAlumnoTutorEntities(List<AlumnoTutorEntity> alumnoTutorEntities) {
        this.alumnoTutorEntities = alumnoTutorEntities;
    }
}
