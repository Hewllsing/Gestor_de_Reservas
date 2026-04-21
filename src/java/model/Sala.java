package model;

import java.util.Objects;

public class Sala {
    private int id;
    private String designacao;
    private String tipo;
    private int lotacao;
    private String numero;
    private int piso_id;

    public Sala() {
    }

    public Sala(int id, String designacao, String tipo, int lotacao, String numero, int piso_id) {
        this.id = id;
        this.designacao = designacao;
        this.tipo = tipo;
        this.lotacao = lotacao;
        this.numero = numero;
        this.piso_id = piso_id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDesignacao() { return designacao; }
    public void setDesignacao(String designacao) { this.designacao = designacao; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getLotacao() { return lotacao; }
    public void setLotacao(int lotacao) { this.lotacao = lotacao; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public int getPiso_id() { return piso_id; }
    public void setPiso_id(int piso_id) { this.piso_id = piso_id; }

    @Override
    public String toString() {
        return "Sala{" + "id=" + id + ", designacao=" + designacao + ", tipo=" + tipo +
                ", lotacao=" + lotacao + ", numero=" + numero + ", piso_id=" + piso_id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.designacao);
        hash = 71 * hash + Objects.hashCode(this.tipo);
        hash = 71 * hash + this.lotacao;
        hash = 71 * hash + Objects.hashCode(this.numero);
        hash = 71 * hash + this.piso_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        final Sala other = (Sala) obj;

        if (this.id != other.id) return false;
        if (this.lotacao != other.lotacao) return false;
        if (this.piso_id != other.piso_id) return false;
        if (!Objects.equals(this.designacao, other.designacao)) return false;
        if (!Objects.equals(this.tipo, other.tipo)) return false;
        return Objects.equals(this.numero, other.numero);
    }
}