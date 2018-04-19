/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Filipe
 */
@Embeddable
public class GerenciaPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "cod_emp", insertable = false, updatable = false)
    private int codigoEmpregado;

    @Column(name = "num_dept", insertable = false, updatable = false)
    private int numDepartamento;

    public GerenciaPK() {
    }

    public int getCodigoEmpregado() {
        return this.codigoEmpregado;
    }

    public void setCodEmpregado(int codigoEmpregado) {
        this.codigoEmpregado = codigoEmpregado;
    }

    public int getNumDepartamento() {
        return this.numDepartamento;
    }

    public void setNumDepartamento(int numDepartamento) {
        this.numDepartamento = numDepartamento;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GerenciaPK)) {
            return false;
        }
        GerenciaPK castOther = (GerenciaPK) other;
        return (this.codigoEmpregado == castOther.codigoEmpregado)
                && (this.numDepartamento == castOther.numDepartamento);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.codigoEmpregado;
        hash = hash * prime + this.numDepartamento;

        return hash;
    }
}
