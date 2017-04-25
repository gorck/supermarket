package br.unisc.supermarket.action;

import br.unisc.supermarket.controller.AlunoController;
import br.unisc.supermarket.controller.RegistroPresencaController;
import br.unisc.supermarket.controller.ScheduleController;
import com.opensymphony.xwork2.ActionSupport;
import br.unisc.supermarket.model.Aluno;
import br.unisc.supermarket.model.Disciplina;
import br.unisc.supermarket.model.RegistroPresenca;
import java.util.Date;
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
public class AlunoAction extends ActionSupport {

    private EntityManager em;
    private Map<String, Object> sessionMap;
    private List<Aluno> alunoList;
    private Aluno aluno;
    private Disciplina disciplina;
    private String id, tag, retorno, nome;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto");

    public String index() {
        try {
            alunoList = new AlunoController(emf).findAll();
        } catch (Exception e) {
        }
        return "index";
    }

    public String create() {
        try {
            new AlunoController(emf).create(aluno);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return SUCCESS;
    }

    public String edit() {
        aluno = new AlunoController(emf).findAluno(Integer.parseInt(id));
        return "edit";
    }

    public String editNew() {
        aluno = new Aluno();
        return "editNew";
    }

    public String verificaAluno() {
        try{
             aluno = new AlunoController(emf).findAlunoByTag(tag);
        if (aluno != null) {
            nome = aluno.getNmAluno();
            disciplina = new AlunoController(emf).findAlunoMatriculadoByTag(tag);
            if (!new RegistroPresencaController(emf).findByregistro(aluno.getIdAluno(), disciplina.getIdDisciplina())) {
                RegistroPresenca rg = new RegistroPresenca();
                rg.setDtPresenca(new Date());
                rg.setIdAluno(aluno);
                rg.setIdSchedule(new ScheduleController(emf).findByIdAlunoAndDate(aluno.getIdAluno()));
                rg.setDisciplina(disciplina);
                new RegistroPresencaController(emf).save(rg);
            }

            return retorno = "ok";
        } else {
            return retorno = "Aluno não encontrado na base de dados";
        }
        }catch(Exception e ){
            System.out.println(e.getMessage().toString());
        }
       return retorno = "Aluno não encontrado na base de dados";
    }

    public String carregaListaAlunosByDisciplina() {
        alunoList = new AlunoController(emf).findAllMatriculadosByDisciplina(Integer.parseInt(id));
        return SUCCESS;
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

}
