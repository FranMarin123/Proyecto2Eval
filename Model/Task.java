package Model;

import java.time.LocalDate;
import Enum.Estado;

public class Task {
    private LocalDate DateStar;
    private  LocalDate DateFinis;
    private Estado estado;
    private User Integrante;
    private String name;
    private String decripcion;

    public Task(LocalDate dateStar, LocalDate dateFinis,Estado estado, User integrante, String name, String decripcion) {
        DateStar = dateStar;
        DateFinis = dateFinis;
        this.estado = estado;
        Integrante = integrante;
        this.name = name;
        this.decripcion = decripcion;
    }

    public LocalDate getDateStar() {
        return DateStar;
    }

    public void setDateStar(LocalDate dateStar) {
        DateStar = dateStar;
    }

    public LocalDate getDateFinis() {
        return DateFinis;
    }

    public void setDateFinis(LocalDate dateFinis) {
        DateFinis = dateFinis;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public User getIntegrante() {
        return Integrante;
    }

    public void setIntegrante(User integrante) {
        Integrante = integrante;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

}
