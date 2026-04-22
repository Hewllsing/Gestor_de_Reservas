package model;

import java.util.Objects;

public class Pavilhao {
    private int id;
    private String designacao;
    private String numero;

    public Pavilhao() {
    }

    public Pavilhao(String designacao, String numero) {
        this.designacao = designacao;
        this.numero = numero;
    }

    
    
    public Pavilhao(int id, String designacao, String numero) {
        this.id = id;
        this.designacao = designacao;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Pavilhao{" + "id=" + id + ", designacao=" + designacao + ", numero=" + numero + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.designacao);
        hash = 71 * hash + Objects.hashCode(this.numero);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        final Pavilhao other = (Pavilhao) obj;

        if (this.id != other.id) return false;
        if (!Objects.equals(this.designacao, other.designacao)) return false;
        return Objects.equals(this.numero, other.numero);
    }
}