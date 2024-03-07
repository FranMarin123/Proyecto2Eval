package Model;

import java.time.LocalDate;
import java.util.Objects;

import Enum.Estado;

public class Task {
    private LocalDate dateStar;
    private  LocalDate dateFinis;
    private Estado estado;
    private User integrante;
    private String name;
    private String decripcion;

    public Task(Estado estado, User integrante, String name, String decripcion) {
        setEstado(Estado.Sin_Iniciar);
        this.integrante = integrante;
        this.name = name;
        this.decripcion = decripcion;
    }
    public Task(){
        this(Estado.Sin_Iniciar,null,"","");
    }

    public LocalDate getDateStar() {
        return dateStar;
    }


    public LocalDate getDateFinis() {
        return dateFinis;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        if(estado ==Estado.Sin_Iniciar){
            dateStar = LocalDate.of(00,00,00);
        }
        else if(estado==Estado.En_Proceso){
            dateStar = LocalDate.now();
        }
        if(estado==Estado.Finalizado){
            dateFinis = LocalDate.now();
        }
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
    public boolean equals(Object o) {
        boolean igual;
        if (this == o){
            igual = true;
        }
        if (o == null || getClass() != o.getClass()){
            igual = false;
        }
        Task task = (Task) o;
        igual = Objects.equals(dateStar, task.dateStar) && Objects.equals(name, task.name);
        return igual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateStar, name);
    }

    @Override
    public String toString() {
        return "Nombre " +
                "Fecha inicio=" + dateStar +
                ", Fecha Finalizada " + dateFinis +
                ", Estado de la tarea es " + estado +
                ", la persona encargada es " + getIntegrante().getNameUser() +
                ", nombre de la tarea" + name + '\'' +
                ", decripcion" + decripcion ;
    }

}
