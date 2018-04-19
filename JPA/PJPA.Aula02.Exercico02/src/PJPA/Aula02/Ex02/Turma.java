/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PJPA.Aula02.Ex02;

/**
 *
 * @author Filipe
 */
public class Turma {
    
    private int codigo;
    private int codigoDisciplina;
    private int codigoProfessor;

    public Turma(int codigo, int codigoDisciplina, int codigoProfessor) {
        this.codigo = codigo;
        this.codigoDisciplina = codigoDisciplina;
        this.codigoProfessor = codigoProfessor;
    }

    public Turma() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(int codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public int getCodigoProfessor() {
        return codigoProfessor;
    }

    public void setCodigoProfessor(int codigoProfessor) {
        this.codigoProfessor = codigoProfessor;
    }
    
    
    
    
    
}
