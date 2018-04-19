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
@NamedQuery(name = "Gerencia.findAll", query = "SELECT g FROM Gerencia g")
public class Gerencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private GerenciaPK id;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_emp")
    private Date dataEmp;

    @ManyToOne
    @JoinColumn(name = "num_dept")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "cod_emp")
    private Empregado empregado;

    public Gerencia() {
    }

    public GerenciaPK getId() {
        return this.id;
    }

    public void setId(GerenciaPK id) {
        this.id = id;
    }

    public Date getDataEmp() {
        return this.dataEmp;
    }

    public void setDataEmp(Date dataEmp) {
        this.dataEmp = dataEmp;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Empregado getEmpregado() {
        return this.empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }

}
