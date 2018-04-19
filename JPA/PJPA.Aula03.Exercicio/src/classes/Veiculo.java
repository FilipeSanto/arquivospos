/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Filipe
 */
@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @Column(name = "id_veiculo")
    private int idVeiculo;
    
    @ManyToOne
    private int idCategoria;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "modelo")
    private String modelo;
    
    @Column(name = "fator_preco")
    private double fatorPreco;

    public Veiculo() {
    }

    public Veiculo(int idVeiculo, int idCategoria, String descricao, String modelo, double fatorPreco) {
        this.idVeiculo = idVeiculo;
        this.idCategoria = idCategoria;
        this.descricao = descricao;
        this.modelo = modelo;
        this.fatorPreco = fatorPreco;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getFatorPreco() {
        return fatorPreco;
    }

    public void setFatorPreco(double fatorPreco) {
        this.fatorPreco = fatorPreco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idVeiculo;
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
        final Veiculo other = (Veiculo) obj;
        if (this.idVeiculo != other.idVeiculo) {
            return false;
        }
        return true;
    }
    
    
    

}
