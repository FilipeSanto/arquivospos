/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 *
 * @author Filipe
 */
@Entity
@NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d")
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "num_dept")
    private int numDepartamento;

    @Column(name = "nome_dept")
    private String nomeDepartamento;

    @OneToMany(mappedBy = "departamento")
    private List<Empregado> empregados;

    @OneToMany(mappedBy = "departamento")
    private List<Gerencia> gerencias;

    @ManyToMany(mappedBy = "departamentos")
    private List<Local> locais;

    @OneToMany(mappedBy = "departamento")
    private List<Projeto> projetos;

    public Departamento() {
    }

    public int getNumDepartamento() {
        return this.numDepartamento;
    }

    public void setNumDepartamento(int numDepartamento) {
        this.numDepartamento = numDepartamento;
    }

    public String getNomeDepartamento() {
        return this.nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public List<Empregado> getEmpregados() {
        return this.empregados;
    }

    public void setEmpregados(List<Empregado> empregados) {
        this.empregados = empregados;
    }

    public Empregado addEmpregado(Empregado empregado) {
        getEmpregados().add(empregado);
        empregado.setDepartamento(this);

        return empregado;
    }

    public Empregado removeEmpregado(Empregado empregado) {
        getEmpregados().remove(empregado);
        empregado.setDepartamento(null);

        return empregado;
    }

    public List<Gerencia> getGerencias() {
        return this.gerencias;
    }

    public void setGerencias(List<Gerencia> gerencias) {
        this.gerencias = gerencias;
    }

    public Gerencia addGerencia(Gerencia gerencia) {
        getGerencias().add(gerencia);
        gerencia.setDepartamento(this);

        return gerencia;
    }

    public Gerencia removeGerencia(Gerencia gerencia) {
        getGerencias().remove(gerencia);
        gerencia.setDepartamento(null);

        return gerencia;
    }

    public List<Local> getlocais() {
        return this.locais;
    }

    public void setlocais(List<Local> locais) {
        this.locais = locais;
    }

    public List<Projeto> getProjetos() {
        return this.projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public Projeto addProjeto(Projeto projeto) {
        getProjetos().add(projeto);
        projeto.setDepartamento(this);

        return projeto;
    }

    public Projeto removeProjeto(Projeto projeto) {
        getProjetos().remove(projeto);
        projeto.setDepartamento(null);

        return projeto;
    }

}
