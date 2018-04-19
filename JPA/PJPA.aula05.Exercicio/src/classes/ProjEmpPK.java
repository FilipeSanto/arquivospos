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
public class ProjEmpPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="num_proj", insertable=false, updatable=false)
	private int numProj;

	@Column(name="cod_emp", insertable=false, updatable=false)
	private int codigoEmpregado;

	public ProjEmpPK() {
	}
	public int getNumProj() {
		return this.numProj;
	}
	public void setNumProj(int numProj) {
		this.numProj = numProj;
	}
	public int getCodEmpregado() {
		return this.codigoEmpregado;
	}
	public void setCodEmpregado(int codigoEmpregado) {
		this.codigoEmpregado = codigoEmpregado;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProjEmpPK)) {
			return false;
		}
		ProjEmpPK castOther = (ProjEmpPK)other;
		return 
			(this.numProj == castOther.numProj)
			&& (this.codigoEmpregado == castOther.codigoEmpregado);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numProj;
		hash = hash * prime + this.codigoEmpregado;
		
		return hash;
	}
}
