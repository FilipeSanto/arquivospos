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
@Table(name = "locacao")
public class Locacao {

    @Id
    @Column(name = "id_locacao")
    private int id;

    @ManyToOne
    private Veiculo veiculo;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Funcionario funcionarioCad;

    @ManyToOne
    private Funcionario funcionariorec;

    @Column(name = "qtde_dias")
    private int qtdDias;

    @Column(name = "kilometragem")
    private int kilometragem;

    public Locacao() {
    }

    public Locacao(int id, Veiculo veiculo, Cliente cliente, Funcionario funcionarioCad, Funcionario funcionariorec, int qtdDias, int kilometragem) {
        this.id = id;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.funcionarioCad = funcionarioCad;
        this.funcionariorec = funcionariorec;
        this.qtdDias = qtdDias;
        this.kilometragem = kilometragem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionarioCad() {
        return funcionarioCad;
    }

    public void setFuncionarioCad(Funcionario funcionarioCad) {
        this.funcionarioCad = funcionarioCad;
    }

    public Funcionario getFuncionariorec() {
        return funcionariorec;
    }

    public void setFuncionariorec(Funcionario funcionariorec) {
        this.funcionariorec = funcionariorec;
    }

    public int getQtdDias() {
        return qtdDias;
    }

    public void setQtdDias(int qtdDias) {
        this.qtdDias = qtdDias;
    }

    public int getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(int kilometragem) {
        this.kilometragem = kilometragem;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.id;
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
        final Locacao other = (Locacao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    

}
