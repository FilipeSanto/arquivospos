/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import classes.Dependente;
import classes.Empregado;
import classes.Gerencia;
import classes.ProjEmp;
import classes.Projeto;

/**
 *
 * @author Filipe
 */
public class Consulta {

    private static EntityManagerFactory emf = null;

    public static void main(String[] args) {

        emf = Persistence.createEntityManagerFactory("PJPAAula05");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("");
        System.out.println("A) Quais os nomes dos departamentos existentes na empresa?");
        questaoA(em);
        System.out.println("");
        System.out.println("B) Quais são as informações de todos os empregados da empresa?");
        questaoB(em);
        System.out.println("");
        System.out.println("C) Qual o nome do departamento de cada empregado?");
        questaoC(em);
        System.out.println("");
        System.out.println("D) Qual o nome dos dependentes de cada empregado?");
        questaoD(em);
        System.out.println("");
        System.out.println("E) Qual o código dos locais de cada projeto em desenvolvimento?");
        questaoE(em);
        System.out.println("");
        System.out.println("F) Qual o código do departamento responsável por cada projeto?");
        questaoF(em);
        System.out.println("");
        System.out.println("G) Qual o nome do departamento responsável por cada projeto?");
        questaoG(em);
        System.out.println("");
        System.out.println("H) Qual a data que cada empregado começou a gerenciar o departamento?\r\n"
                + "--Apresente o nome do empregado, o nome do departamento e a data");
        questaoH(em);
        System.out.println("");
        System.out.println("I) Quais os códigos dos empregados que trabalham no projeto de código 30?");
        questaoI(em);
        System.out.println("");
        System.out.println("J) Quais os nomes dos empregados que trabalham no projeto de código 20?");
        questaoJ(em);
        System.out.println("");
        System.out.println("K) Qual o nome do departamento do empregado de código 7?");
        questaoK(em);
        System.out.println("");
        System.out.println("L) Qual o nome do departamento que controla o projeto onde o empregado de código 4 trabalha?");
        questaoL(em);
        System.out.println("");
        System.out.println("M) Qual o nome dos empregados que trabalham em algum projeto ?");
        questaoM(em);
        System.out.println("");
        System.out.println("N) Qual o nome dos empregados que trabalham em algum projeto e que supervisionam outros empregados?");
        questaoN(em);
        System.out.println("");
        System.out.println("O) Qual o nome dos empregados que não estão trabalhando em projetos?");
        questaoO(em);
        System.out.println("");
        System.out.println("P) Qual o nome dos empregados que não estão trabalhando em projetos, mas que gerenciam algum departamento?");
        questaoP(em);
        System.out.println("");
        System.out.println("Q) Qual a descrição da ou das localizações do departamento de código 222?");
        questaoQ(em);
        System.out.println("");
        System.out.println("R) Qual a quantidade de horas trabalhadas pelo empregado de código 2?");
        questaoR(em);
        System.out.println("");
        System.out.println("S) Qual a quantidade de horas trabalhadas pelo empregado de código 4?");
        questaoS(em);
        System.out.println("");
        System.out.println("T) Qual a quantidade de horas trabalhadas pela empregada de nome Emília?");
        questaoT(em);
        System.out.println("");
        System.out.println("U) Qual a média de horas trabalhadas pelos empregados desta empresa?");
        questaoU(em);
        System.out.println("");
        System.out.println("V) Qual a quantidade de empregados existentes na empresa?");
        questaoV(em);
        System.out.println("");
        System.out.println("X) Quais os nomes dos dependentes de todas as empregadas da empresa (apenas empregadas)?");
        questaoX(em);
        System.out.println("");
        System.out.println("Y) Qual o nome dos projetos que não são controlados por algum departamento?");
        questaoY(em);
        System.out.println("");
        System.out.println("Z) Qual o nome dos departamentos que estão localizados em dois ou mais locais diferentes?");
        questaoZ(em);
        System.out.println("");

        em.getTransaction().commit();
        em.close();
        emf.close();

    }

    private static void questaoA(EntityManager manager) {

        String query = "select dep.nomeDept from Departamento dep";

        List<String> nomesDeps = manager.createQuery(query, String.class).getResultList();

        nomesDeps.forEach(nome -> System.out.println("Departamento: " + nome));

    }

    private static void questaoB(EntityManager manager) {

        Query query = manager.createQuery(" SELECT emp FROM Empregado emp");

        List<Empregado> empregados = query.getResultList();

        for (Empregado e : empregados) {
            System.out.print("Empregados : " + e.getNomeEmpregado());
            System.out.println("  " + e.getDataNascimento());
        }

    }

    private static void questaoC(EntityManager manager) {

        TypedQuery<Empregado> query = manager.createQuery("select e from Empregado e inner join fetch e.departamento",
                Empregado.class);
        List<Empregado> empregados = query.getResultList();

        for (Empregado emp : empregados) {
            System.out.println(
                    "Empregado x Departamento: " + emp.getNomeEmpregado() + " - " + emp.getDepartamento().getNomeDepartamento());

        }
    }

    private static void questaoD(EntityManager manager) {

        TypedQuery<Empregado> query = manager.createQuery("select	distinct(e) from Empregado e inner join fetch e.dependentes", Empregado.class);

        List<Empregado> empregados = query.getResultList();

        for (Empregado emp : empregados) {
            System.out.print("Empregado x Dependente : " + emp.getNomeEmpregado());

            for (Dependente dependente : emp.getDependentes()) {
                System.out.print(" - " + dependente.getNomeDependente());
            }
            System.out.println("");

        }
    }

    private static void questaoE(EntityManager manager) {

        TypedQuery<Projeto> query = manager.createQuery("select	p from Projeto p inner join fetch p.local",
                Projeto.class);

        List<Projeto> projetos = query.getResultList();

        for (Projeto p : projetos) {
            System.out.println("Projeto x Codigo do Local : " + p.getDescProj() + " - " + p.getLocal().getCodigoLocal());
        }
    }

    private static void questaoF(EntityManager manager) {

        TypedQuery<Projeto> query = manager.createQuery("select	p from Projeto p inner join fetch p.departamento",
                Projeto.class);

        List<Projeto> projetos = query.getResultList();

        for (Projeto p : projetos) {
            System.out.println(
                    "Projeto x Codigo do Departamento : " + p.getDescProj() + " - " + p.getDepartamento().getNumDepartamento());
        }
    }

    private static void questaoG(EntityManager manager) {

        TypedQuery<Projeto> query = manager.createQuery("select	p from Projeto p inner join fetch p.departamento",
                Projeto.class);

        List<Projeto> projetos = query.getResultList();

        for (Projeto p : projetos) {
            System.out.println(
                    "Projeto x Nome do Departamento : " + p.getDescProj() + " - " + p.getDepartamento().getNomeDepartamento());
        }
    }

    private static void questaoH(EntityManager manager) {

        TypedQuery<Gerencia> query = manager.createQuery(
                "select	g from Gerencia g inner join fetch g.departamento inner join fetch g.empregado ",
                Gerencia.class);

        List<Gerencia> gerencias = query.getResultList();

        for (Gerencia g : gerencias) {
            System.out.println("Gerencia x Nome do Departamento x Data empregado : " + g.getEmpregado().getNomeEmpregado() + " - " + g.getEmpregado().getNomeEmpregado() + " - " + g.getDepartamento().getNomeDepartamento() + " - " + g.getDataEmp());
        }
    }

    private static void questaoI(EntityManager manager) {

        TypedQuery<ProjEmp> query = manager.createQuery(
                "select	p from ProjEmp p inner join fetch p.empregado inner join fetch p.projeto where p.projeto.numProj = 30",
                ProjEmp.class);

        List<ProjEmp> projemps = query.getResultList();

        for (ProjEmp p : projemps) {
            System.out.println("Codigo do Projeto x Codigo Empregado : " + p.getProjeto().getNumProj() + " - " + p.getEmpregado().getCodigoEmpregado());
        }
    }

    private static void questaoJ(EntityManager manager) {

        TypedQuery<ProjEmp> query = manager.createQuery(
                "select	p from ProjEmp p inner join fetch p.empregado inner join fetch p.projeto where p.projeto.numProj = 20",
                ProjEmp.class);

        List<ProjEmp> projemps = query.getResultList();

        for (ProjEmp p : projemps) {
            System.out.println("Nome do Projeto x Codigo Empregado : " + p.getProjeto().getDescProj() + " - " + p.getEmpregado().getCodigoEmpregado());
        }
    }

    private static void questaoK(EntityManager manager) {

        TypedQuery<Empregado> query = manager.createQuery(
                "select e from Empregado e inner join fetch e.departamento where e.codEmp = 7", Empregado.class);
        List<Empregado> empregados = query.getResultList();

        for (Empregado dep : empregados) {
            System.out.println("Nome do Departamento do Codigo Empregado = 7: " + dep.getDepartamento().getNomeDepartamento());

        }
    }

    private static void questaoL(EntityManager manager) {

        TypedQuery<Gerencia> query = manager.createQuery(
                "select g from Gerencia g inner join fetch g.departamento inner join fetch g.empregado	where g.empregado.codEmp = 4", Gerencia.class);
        List<Gerencia> gerencias = query.getResultList();

        for (Gerencia ger : gerencias) {
            System.out.println("Nome do Departamento Codigo empregado = 4: " + ger.getDepartamento().getNomeDepartamento());

        }
    }

    private static void questaoM(EntityManager manager) {

        TypedQuery<ProjEmp> query = manager.createQuery(
                "select	p from ProjEmp p inner join fetch p.empregado inner join fetch p.projeto group by p.empregado.nomeEmp ", ProjEmp.class);

        List<ProjEmp> projemps = query.getResultList();

        for (ProjEmp p : projemps) {
            System.out
                    .println("O nome dos empregados que trabalham em algum projeto : " + p.getEmpregado().getNomeEmpregado());
        }
    }

    private static void questaoN(EntityManager manager) {

        TypedQuery<ProjEmp> query = manager.createQuery(
                "select	p from ProjEmp p inner join fetch p.empregado inner join fetch p.projeto group by p.empregado.nomeEmp ",
                ProjEmp.class);

        List<ProjEmp> projemps = query.getResultList();

        for (ProjEmp p : projemps) {
            System.out.println("O nome dos empregados que trabalham em algum projeto : " + p.getEmpregado().getNomeEmpregado());
        }
    }

    private static void questaoO(EntityManager manager) {

    }

    private static void questaoP(EntityManager manager) {

    }

    private static void questaoQ(EntityManager manager) {

        String sql = "SELECT			*\r\n" + "FROM			local         AS LOC\r\n"
                + "INNER JOIN		local_dept    AS LDP ON LDP.num_dept = '222' AND\r\n"
                + "									    LDP.cod_local = LOC.cod_local";

        List<Object> lista = (List<Object>) manager.createNativeQuery(sql).getResultList();

        for (Object obj : lista) {

            Object[] objeto = (Object[]) obj;

            System.out.println("Resultado:" + " " + objeto[1]);
        }
    }

    private static void questaoR(EntityManager manager) {

        String sql = "select num_proj,cod_emp,quant_horas,sum(quant_horas) as totalH from proj_emp where cod_emp = 2";

        List<ProjEmp> lista = manager.createNativeQuery(sql, ProjEmp.class).getResultList();

        lista.forEach(r -> System.out.println("A quantidade de horas trabalhadas: " + r.getQuantidadeHoras()));

    }

    private static void questaoS(EntityManager manager) {

        String sql = "select num_proj,cod_emp,quant_horas,sum(quant_horas) as totalH FROM  proj_emp WHERE cod_emp = 4";

        List<ProjEmp> lista = manager.createNativeQuery(sql, ProjEmp.class).getResultList();

        lista.forEach(r -> System.out.println("A quantidade de horas trabalhadas: " + r.getQuantidadeHoras()));

    }

    private static void questaoT(EntityManager manager) {

        String sql = "select a.cod_emp,a.nome_emp,b.quant_horas from empregado as a,proj_emp as b where " + "a.cod_emp = b.cod_emp and a.nome_emp = 'Emilia'";

        List<Object> lista = (List<Object>) manager.createNativeQuery(sql).getResultList();

        for (Object obj : lista) {

            Object[] objeto = (Object[]) obj;

            System.out.println("TOTAL HORAS: " + objeto[2]);
        }
    }

    private static void questaoU(EntityManager manager) {

        String sql = "select	num_proj, cod_emp, AVG(quant_horas) as quant_horas from proj_emp";

        List<Object> lista = (List<Object>) manager.createNativeQuery(sql).getResultList();

        for (Object obj : lista) {

            Object[] objeto = (Object[]) obj;

            System.out.println("TOTAL HORAS: " + objeto[2]);
        }
    }

    private static void questaoV(EntityManager manager) {

        String sql = "SELECT COUNT(*) AS NUM_EMP FROM empregado";

        Query queryCount = manager.createNativeQuery(sql);

        Object total = null;

        total = queryCount.getSingleResult();

        System.out.println("Total: " + total);
    }

    private static void questaoX(EntityManager manager) {

        String sql = "SELECT * FROM dependente INNER JOIN	empregado AS EMP ON EMP.cod_emp = dependente.cod_emp";

        List<Object> lista = (List<Object>) manager.createNativeQuery(sql).getResultList();

        for (Object obj : lista) {

            Object[] objeto = (Object[]) obj;

            System.out.println("Dependentes: " + objeto[2]);
        }
    }

    private static void questaoY(EntityManager manager) {

        String sql = "SELECT * FROM	 projeto WHERE num_dept is null";

        List<Object> lista = (List<Object>) manager.createNativeQuery(sql).getResultList();

        for (Object obj : lista) {

            Object[] objeto = (Object[]) obj;

            System.out.println("Projeto: " + objeto[3]);
        }
    }

    private static void questaoZ(EntityManager manager) {
    }
}
