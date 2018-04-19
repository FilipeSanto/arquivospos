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
@NamedQuery(name = "Projeto.findAll", query = "SELECT p FROM Projeto p")
public class Projeto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "num_proj")
    private int numProj;

    @Column(name = "desc_proj")
    private String descProj;

    @OneToMany(mappedBy = "projeto")
    private List<ProjEmp> projEmps;

    @ManyToOne
    @JoinColumn(name = "num_dept")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "cod_local")
    private Local local;

    public Projeto() {
    }

    public int getNumProj() {
        return this.numProj;
    }

    public void setNumProj(int numProj) {
        this.numProj = numProj;
    }

    public String getDescProj() {
        return this.descProj;
    }

    public void setDescProj(String descProj) {
        this.descProj = descProj;
    }

    public List<ProjEmp> getProjEmps() {
        return this.projEmps;
    }

    public void setProjEmps(List<ProjEmp> projEmps) {
        this.projEmps = projEmps;
    }

    public ProjEmp addProjEmp(ProjEmp projEmp) {
        getProjEmps().add(projEmp);
        projEmp.setProjeto(this);

        return projEmp;
    }

    public ProjEmp removeProjEmp(ProjEmp projEmp) {
        getProjEmps().remove(projEmp);
        projEmp.setProjeto(null);

        return projEmp;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Local getLocal() {
        return this.local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

}
