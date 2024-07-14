package com.appconsecurity.esbao.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "alumno_tutor")
public class AlumnoTutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumno_tutor_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private AlumnoEntity alumno;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private TutorEntity tutor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AlumnoEntity getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoEntity alumno) {
        this.alumno = alumno;
    }

    public TutorEntity getTutor() {
        return tutor;
    }

    public void setTutor(TutorEntity tutor) {
        this.tutor = tutor;
    }
}
