package model;

import java.util.Objects;

public class Piso {
    private int id;
    private String numero;
    private int pavilhao_id;

    public Piso() {
    }

    public Piso(int id, String numero, int pavilhao_id) {
        this.id = id;
        this.numero = numero;
        this.pavilhao_id = pavilhao_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getPavilhao_id() {
        return pavilhao_id;
    }

    public void setPavilhao_id(int pavilhao_id) {
        this.pavilhao_id = pavilhao_id;
    }

    @Override
    public String toString() {
        return "Piso{" + "id=" + id + ", numero=" + numero + ", pavilhao_id=" + pavilhao_id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.numero);
        hash = 71 * hash + this.pavilhao_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        final Piso other = (Piso) obj;

        if (this.id != other.id) return false;
        if (this.pavilhao_id != other.pavilhao_id) return false;
        return Objects.equals(this.numero, other.numero);
    }
}