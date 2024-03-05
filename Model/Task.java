package Model;

import java.time.LocalDate;
import Enum.Estado;

public class Task {
    private LocalDate DateStar;
    private  LocalDate DateFinis;
    private Estado estado;
    private User integrante;
    private String name;
    private String decripcion;

    public Task(LocalDate dateStar, LocalDate dateFinis,Estado estado, User integrante, String name, String decripcion) {
        this.DateStar = dateStar;
        this.DateFinis = dateFinis;
        this.estado = estado;
        this.integrante = integrante;
        this.name = name;
        this.decripcion = decripcion;
    }

    public LocalDate getDateStar() {
        return DateStar;
    }

    public void setDateStar(LocalDate dateStar) {
        this.DateStar = dateStar;
    }

    public LocalDate getDateFinis() {
        return DateFinis;
    }

    public void setDateFinis(LocalDate dateFinis) {
        this.DateFinis = dateFinis;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public User getIntegrante() {
        return integrante;
    }

    public void setIntegrante(User integrante) {
        this.integrante = integrante;
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

    @Override
    public String toString() {
        return "Nombre " +
                "Fecha inicio=" + DateStar +
                ", Fecha Finalizada " + DateFinis +
                " Estado de la tarea es " + estado +
                " la persona encargada es " + integrante +
                ", name='" + name + '\'' +
                ", decripcion='" + decripcion ;
    }
}
