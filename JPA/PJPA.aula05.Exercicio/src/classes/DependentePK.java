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
public class DependentePK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "cod_emp", insertable = false, updatable = false)
    private int codigoEmpempregado;

    @Column(name = "cod_depend")
    private int codigoDependente;

    public DependentePK() {
    }

    public int getCodigoEmpregado() {
        return this.codigoEmpempregado;
    }

    public void setCodigoEmpregado(int codigoEmpregado) {
        this.codigoEmpempregado = codigoEmpregado;
    }

    public int getCodigoDependente() {
        return this.codigoDependente;
    }

    public void setCodigoDependente(int codigoDependente) {
        this.codigoDependente = codigoDependente;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DependentePK)) {
            return false;
        }
        DependentePK castOther = (DependentePK) other;
        return (this.codigoEmpempregado == castOther.codigoEmpempregado)
                && (this.codigoDependente == castOther.codigoDependente);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.codigoEmpempregado;
        hash = hash * prime + this.codigoDependente;

        return hash;
    }
}
