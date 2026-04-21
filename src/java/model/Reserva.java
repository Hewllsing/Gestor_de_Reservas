package model;

import java.util.Date;
import java.util.Objects;

public class Reserva {
    private int id;
    private Date dataInicio;
    private Date dataFim;
    private String estado;
    private int sala_id;
    private int formador_id;

    public Reserva() {
    }

    public Reserva(int id, Date dataInicio, Date dataFim, String estado, int sala_id, int formador_id) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.estado = estado;
        this.sala_id = sala_id;
        this.formador_id = formador_id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getDataInicio() { return dataInicio; }
    public void setDataInicio(Date dataInicio) { this.dataInicio = dataInicio; }

    public Date getDataFim() { return dataFim; }
    public void setDataFim(Date dataFim) { this.dataFim = dataFim; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public int getSala_id() { return sala_id; }
    public void setSala_id(int sala_id) { this.sala_id = sala_id; }

    public int getFormador_id() { return formador_id; }
    public void setFormador_id(int formador_id) { this.formador_id = formador_id; }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim + ", estado=" + estado +
                ", sala_id=" + sala_id + ", formador_id=" + formador_id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.dataInicio);
        hash = 71 * hash + Objects.hashCode(this.dataFim);
        hash = 71 * hash + Objects.hashCode(this.estado);
        hash = 71 * hash + this.sala_id;
        hash = 71 * hash + this.formador_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        final Reserva other = (Reserva) obj;

        if (this.id != other.id) return false;
        if (this.sala_id != other.sala_id) return false;
        if (this.formador_id != other.formador_id) return false;
        if (!Objects.equals(this.dataInicio, other.dataInicio)) return false;
        if (!Objects.equals(this.dataFim, other.dataFim)) return false;
        return Objects.equals(this.estado, other.estado);
    }
}