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
@Entity
@Table(name="proj_emp")
@NamedQuery(name="ProjEmp.findAll", query="SELECT p FROM ProjEmp p")
public class ProjEmp implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProjEmpPK id;

	@Column(name="quant_horas")
	private int quantidadeHoras;

	@ManyToOne
	@JoinColumn(name="cod_emp")
	private Empregado empregado;

	@ManyToOne
	@JoinColumn(name="num_proj")
	private Projeto projeto;

	public ProjEmp() {
	}

	public ProjEmpPK getId() {
		return this.id;
	}

	public void setId(ProjEmpPK id) {
		this.id = id;
	}

	public int getQuantidadeHoras() {
		return this.quantidadeHoras;
	}

	public void setQuantidadeHoras(int quantidadeHoras) {
		this.quantidadeHoras = quantidadeHoras;
	}

	public Empregado getEmpregado() {
		return this.empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public Projeto getProjeto() {
		return this.projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}
