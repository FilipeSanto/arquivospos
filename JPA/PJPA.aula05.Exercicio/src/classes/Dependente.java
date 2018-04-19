/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Filipe
 */
@Entity
@NamedQuery(name = "Dependente.findAll", query = "SELECT d FROM Dependente d")
public class Dependente implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private DependentePK id;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nasc")
    private Date dataNascimento;

    @Column(name = "nome_depend")
    private String nomeDependente;

    @Column(name = "sexo_depend")
    private String sexoDependente;

    @Column(name = "tipo_depend")
    private String tipoDependente;

    @ManyToOne
    @JoinColumn(name = "cod_emp")
    private Empregado empregado;

    public Dependente() {
    }

    public DependentePK getId() {
        return this.id;
    }

    public void setId(DependentePK id) {
        this.id = id;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeDependente() {
        return this.nomeDependente;
    }

    public void setNomeDependente(String nomeDependente) {
        this.nomeDependente = nomeDependente;
    }

    public String getSexoDependente() {
        return this.sexoDependente;
    }

    public void setSexoDependente(String sexoDependente) {
        this.sexoDependente = sexoDependente;
    }

    public String getTipoDependente() {
        return this.tipoDependente;
    }

    public void setTipoDependente(String tipoDependente) {
        this.tipoDependente = tipoDependente;
    }

    public Empregado getEmpregado() {
        return this.empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }
}
