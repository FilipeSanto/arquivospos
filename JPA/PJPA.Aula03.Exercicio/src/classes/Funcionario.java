/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Filipe
 */
@Entity
@Table (name = "funcinario")
public class Funcionario {
    
    @Id
    @GeneratedValue
    @Column (name = "id_funcionario")
    private int idFuncionario;
    
    @Column (name = "nome")
    private String nome;
    
    @Column (name = "matricula")
    private String matricula;

    public Funcionario(int idFuncionario, String nome, String matricula) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.matricula = matricula;
    }

    public Funcionario() {
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
    
}
