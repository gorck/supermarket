package br.unisc.supermarket.action;

import br.unisc.supermarket.controller.AlunoController;
import br.unisc.supermarket.controller.AlunoDisciplinaController;
import br.unisc.supermarket.controller.DisciplinaController;
import com.opensymphony.xwork2.ActionSupport;
import br.unisc.supermarket.model.Aluno;
import br.unisc.supermarket.model.AlunoDisciplina;
import br.unisc.supermarket.model.Disciplina;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author jose
 */
@Results({
    @Result(name = "success", type = "redirectAction", params = {"actionName", "aluno"})
})
public class AlunoDisciplinaAction extends ActionSupport {

    private EntityManager em;
    private Map<String, Object> sessionMap;

    private List<Aluno> alunoList, alunoMatriculadoList, alunos;
    private List<Disciplina> disciplinaList;
    private List<AlunoDisciplina> alunoDisciplinaList;
    private Aluno aluno;
    private AlunoDisciplina alunoDisciplina;
    private String id, tag, retorno, nome, idAluno;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto");

    public String index() {
        try {
            alunos = new AlunoController(emf).findAll();
            alunoMatriculadoList = new AlunoController(emf).findAllMatriculados();
            disciplinaList = new DisciplinaController(emf).findAll();
            alunoDisciplinaList = new AlunoDisciplinaController(emf).findAllAlunoDisciplina();
            for (Disciplina d : disciplinaList) {
                d.setAlunoList(new AlunoController(emf).findAllMatriculadosByDisciplina(d.getIdDisciplina()));
            }

        } catch (Exception e) {
        }
        return "index";
    }

    public String edit() {

        disciplinaList = new DisciplinaController(emf).findAll();
        return "edit";

    }

    public String editNew() {
        alunoList = new ArrayList<>();
        disciplinaList = new DisciplinaController(emf).findAll();
        return "editNew";

    }

    public String criaMatricula() {

        try {
            alunoDisciplina = new AlunoDisciplina();
            alunoDisciplina.setIdAluno(new AlunoController(emf).findAluno(Integer.parseInt(idAluno)));
            alunoDisciplina.setIdDisciplina(new DisciplinaController(emf).findById(Integer.parseInt(id)));
            new AlunoDisciplinaController(emf).save(alunoDisciplina);

        } catch (Exception e) {

        }

        return SUCCESS;
    }

    public String verificaAluno() {
        aluno = new AlunoController(emf).findAlunoByTag(tag);
        if (aluno != null) {
            nome = aluno.getNmAluno();
            return retorno = "ok";
        } else {
            return retorno = "Aluno não encontrado na base de dados";
        }
    }

//    public String removeMatricula() {
//
//        try {
//            alunoDisciplina = new AlunoDisciplinaController(emf).findAlunoDisciplinaByDisciplinaAndIdAluno(Integer.parseInt(id), Integer.parseInt(idAluno));
//            new AlunoDisciplinaController(emf).destroy(alunoDisciplina.getIdAlunoDisciplina());
//
//        } catch (Exception e) {
//            e.getMessage();
//            return SUCCESS;
//        }
//
//        return SUCCESS;
//    }

    public String loadAluno() {
        alunoList = new AlunoController(emf).findAlunoNaoMatriculadosByDisciplina(Integer.parseInt(id));
        return "combo";
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public List<Aluno> getAlunoList() {
        return alunoList;
    }

    public void setAlunoList(List<Aluno> alunoList) {
        this.alunoList = alunoList;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getAlunoMatriculadoList() {
        return alunoMatriculadoList;
    }

    public void setAlunoMatriculadoList(List<Aluno> alunoMatriculadoList) {
        this.alunoMatriculadoList = alunoMatriculadoList;
    }

    public List<Disciplina> getDisciplinaList() {
        return disciplinaList;
    }

    public void setDisciplinaList(List<Disciplina> disciplinaList) {
        this.disciplinaList = disciplinaList;
    }

    public List<AlunoDisciplina> getAlunoDisciplinaList() {
        return alunoDisciplinaList;
    }

    public void setAlunoDisciplinaList(List<AlunoDisciplina> alunoDisciplinaList) {
        this.alunoDisciplinaList = alunoDisciplinaList;
    }

    public AlunoDisciplina getAlunoDisciplina() {
        return alunoDisciplina;
    }

    public void setAlunoDisciplina(AlunoDisciplina alunoDisciplina) {
        this.alunoDisciplina = alunoDisciplina;
    }

    public String getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(String idAluno) {
        this.idAluno = idAluno;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

}
