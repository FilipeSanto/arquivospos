/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Filipe
 */
@Table (name = "multa")
public class Multa {
    
    @Id
    @Column (name = "id_multa")
    private int idMulta;
    
    @Column (name = "valor")
    private double valor;
    
    @Column (name = "descricao")
    private String descricao;
    
    @ManyToOne
    private int idLocacao;

    public Multa() {
    }

    public Multa(int idMulta, double valor, String descricao, int idLocacao) {
        this.idMulta = idMulta;
        this.valor = valor;
        this.descricao = descricao;
        this.idLocacao = idLocacao;
    }

    public int getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(int idMulta) {
        this.idMulta = idMulta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idMulta;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Multa other = (Multa) obj;
        if (this.idMulta != other.idMulta) {
            return false;
        }
        return true;
    }
    
    
}
