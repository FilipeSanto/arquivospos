/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Filipe
 */
@Entity
@NamedQuery(name = "Local.findAll", query = "SELECT l FROM Local l")
public class Local implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cod_local")
    private int codigoLocal;

    @Column(name = "desc_local")
    private String descricaoLocal;

    @ManyToMany
    @JoinTable(
            name = "local_dept",
            joinColumns = {
                @JoinColumn(name = "cod_local")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "num_dept")
            }
    )
    private List<Departamento> departamentos;

    @OneToMany(mappedBy = "local")
    private List<Projeto> projetos;

    public Local() {
    }

    public int getCodigoLocal() {
        return this.codigoLocal;
    }

    public void setCodigoLocal(int codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public String getDescricaoLocal() {
        return this.descricaoLocal;
    }

    public void setDescricaoLocal(String descricaoLocal) {
        this.descricaoLocal = descricaoLocal;
    }

    public List<Departamento> getDepartamentos() {
        return this.departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public List<Projeto> getProjetos() {
        return this.projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public Projeto addProjeto(Projeto projeto) {
        getProjetos().add(projeto);
        projeto.setLocal(this);

        return projeto;
    }

    public Projeto removeProjeto(Projeto projeto) {
        getProjetos().remove(projeto);
        projeto.setLocal(null);

        return projeto;
    }

}
