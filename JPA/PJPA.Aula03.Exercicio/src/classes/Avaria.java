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
@Table (name = "avaria")
public class Avaria {
    
    @Id
    @Column (name = "id_avaria")
    private int idAvaria;
    
    @Column (name = "valor")
    private double valor;
    
    @Column (name = "descricao")
    private String descricao;
    
    @ManyToOne
    private int idLocacao;

    public Avaria() {
    }

    public Avaria(int idAvaria, double valor, String nome, int idLocacao) {
        this.idAvaria = idAvaria;
        this.valor = valor;
        this.descricao = nome;
        this.idLocacao = idLocacao;
    }

    public int getIdAvaria() {
        return idAvaria;
    }

    public void setIdAvaria(int idAvaria) {
        this.idAvaria = idAvaria;
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
        hash = 97 * hash + this.idAvaria;
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
        final Avaria other = (Avaria) obj;
        if (this.idAvaria != other.idAvaria) {
            return false;
        }
        return true;
    }
    
    
    
}
