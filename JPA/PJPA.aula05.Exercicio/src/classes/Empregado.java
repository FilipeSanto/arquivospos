/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 *
 * @author Filipe
 */
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name="Empregado.findAll", query="SELECT e FROM Empregado e")
public class Empregado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_emp")
	private int codigoEmpregado;

	@Column(name="data_nasc")
	private String dataNascimento;

	@Column(name="end_emp")
	private String enderecoEmpregado;

	@Column(name="nome_emp")
	private String nomeEmpregado;

	@Column(name="sexo_emp")
	private String sexoEmpregado;

	@OneToMany(mappedBy="empregado")
	private List<Dependente> dependentes;

	@ManyToOne
	@JoinColumn(name="num_dept")
	private Departamento departamento;

	@ManyToOne
	@JoinColumn(name="cod_gerente")
	private Empregado empregado;

	@OneToMany(mappedBy="empregado")
	private List<Empregado> empregados;

	@OneToMany(mappedBy="empregado")
	private List<Gerencia> gerencias;

	@OneToMany(mappedBy="empregado")
	private List<ProjEmp> projEmps;

	public Empregado() {
	}

	public int getCodigoEmpregado() {
		return this.codigoEmpregado;
	}

	public void setCodigoEmpregado(int codigoEmpregado) {
		this.codigoEmpregado = codigoEmpregado;
	}

	public String getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEnderecoEmpregado() {
		return this.enderecoEmpregado;
	}

	public void setEnderecoEmpregado(String enderecoEmpregado) {
		this.enderecoEmpregado = enderecoEmpregado;
	}

	public String getNomeEmpregado() {
		return this.nomeEmpregado;
	}

	public void setNomeEmpregado(String nomeEmpregado) {
		this.nomeEmpregado = nomeEmpregado;
	}

	public String getSexoEmpregado() {
		return this.sexoEmpregado;
	}

	public void setSexoEmpregado(String sexoEmpregado) {
		this.sexoEmpregado = sexoEmpregado;
	}

	public List<Dependente> getDependentes() {
		return this.dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	public Dependente addDependente(Dependente dependente) {
		getDependentes().add(dependente);
		dependente.setEmpregado(this);

		return dependente;
	}

	public Dependente removeDependente(Dependente dependente) {
		getDependentes().remove(dependente);
		dependente.setEmpregado(null);

		return dependente;
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

	public List<Empregado> getEmpregados() {
		return this.empregados;
	}

	public void setEmpregados(List<Empregado> empregados) {
		this.empregados = empregados;
	}

	public Empregado addEmpregado(Empregado empregado) {
		getEmpregados().add(empregado);
		empregado.setEmpregado(this);

		return empregado;
	}

	public Empregado removeEmpregado(Empregado empregado) {
		getEmpregados().remove(empregado);
		empregado.setEmpregado(null);

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
		gerencia.setEmpregado(this);

		return gerencia;
	}

	public Gerencia removeGerencia(Gerencia gerencia) {
		getGerencias().remove(gerencia);
		gerencia.setEmpregado(null);

		return gerencia;
	}

	public List<ProjEmp> getProjEmps() {
		return this.projEmps;
	}

	public void setProjEmps(List<ProjEmp> projEmps) {
		this.projEmps = projEmps;
	}

	public ProjEmp addProjEmp(ProjEmp projEmp) {
		getProjEmps().add(projEmp);
		projEmp.setEmpregado(this);

		return projEmp;
	}

	public ProjEmp removeProjEmp(ProjEmp projEmp) {
		getProjEmps().remove(projEmp);
		projEmp.setEmpregado(null);

		return projEmp;
	}
    
    
    
}
