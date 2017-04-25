package br.unisc.supermarket.action;

import br.unisc.supermarket.controller.DisciplinaController;
import br.unisc.supermarket.controller.RegistroPresencaController;
import br.unisc.supermarket.controller.ScheduleController;
import br.unisc.supermarket.controller.TurnoDisciplinaController;
import br.unisc.supermarket.model.Aluno;
import br.unisc.supermarket.model.Disciplina;
import br.unisc.supermarket.model.RegistroPresenca;
import br.unisc.supermarket.model.Schedule;
import br.unisc.supermarket.model.TurnoDisciplina;
import com.opensymphony.xwork2.ActionSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author jose
 */
@Results({
    @Result(name = "success", type = "redirectAction", params = {"actionName", "disciplina"})
})
public class DisciplinaAction extends ActionSupport {

    public List<TurnoDisciplina> objetoList;
    public List<Schedule> scheduleList;
    public List<Disciplina> disciplinaList;
    public List<RegistroPresenca> registroPresencaList;
    public List<Aluno> alunoList;
    public Disciplina disciplina;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto");

    private Map<Integer, String> diasSemanaMap;

    private String id, dia, idSchedule, dt;

    public String index() {
        disciplinaList = new DisciplinaController(emf).findAll();
        return "index";
    }

    public String create() throws Exception {
        if (disciplina.getNmDisciplina().isEmpty()) {
            return "index";
        }
        if (StringUtils.isNotBlank(id)) {
            disciplina.setIdDisciplina(Integer.parseInt(id));
        }
        new DisciplinaController(emf).save(disciplina);
        return SUCCESS;
    }

    public String edit() {
        disciplina = new DisciplinaController(emf).findById(Integer.parseInt(id));
        objetoList = new TurnoDisciplinaController(emf).findAll();
        scheduleList = new ScheduleController(emf).findByIdDiscipina(Integer.parseInt(id));
        carregaDias();

        return "edit";
    }

    public String editNew() {
        objetoList = new TurnoDisciplinaController(emf).findAll();
        return "editNew";
    }

    public String geraSchedule() throws ParseException {
        Date data = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        data = (Date) formatter.parse(dt);

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(data);
        int diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);

//        Date data = new Date(new SimpleDateFormat(dt));///
        for (int x = 0; x < 18; x++) {
            Schedule s = new Schedule();
            s.setDisciplina(new Disciplina(Integer.parseInt(id)));
            s.setDtDiaSemana(diaDaSemana);
            s.setDtSchedule(data);
            new ScheduleController(emf).save(s);
            data = DateUtils.addDays(data, 7);
        }

        return SUCCESS;

    }

    public String carregaListaPresenca() {
        alunoList = new RegistroPresencaController(emf)
                .findByIdScheduleAndIdDisciplina(Integer.parseInt(idSchedule), Integer.parseInt(id));
        return SUCCESS;
    }

    public String adicionaPresenca() {
        alunoList = new RegistroPresencaController(emf)
                .findByIdScheduleAndIdDisciplina(Integer.parseInt(idSchedule), Integer.parseInt(id));
        return SUCCESS;
    }

    private void carregaDias() {
        diasSemanaMap = new LinkedHashMap<Integer, String>();
        diasSemanaMap.put(1, "Segunda-Feira");
        diasSemanaMap.put(2, "Terça-Feira");
        diasSemanaMap.put(3, "Quarta-Feira");
        diasSemanaMap.put(4, "Quinta-Feira");
        diasSemanaMap.put(5, "Sexta-Feira");
    }

    public List<TurnoDisciplina> getObjetoList() {
        return objetoList;
    }

    public void setObjetoList(List<TurnoDisciplina> objetoList) {
        this.objetoList = objetoList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public List<Disciplina> getDisciplinaList() {
        return disciplinaList;
    }

    public void setDisciplinaList(List<Disciplina> disciplinaList) {
        this.disciplinaList = disciplinaList;
    }

    public List<RegistroPresenca> getRegistroPresencaList() {
        return registroPresencaList;
    }

    public void setRegistroPresencaList(List<RegistroPresenca> registroPresencaList) {
        this.registroPresencaList = registroPresencaList;
    }

    public List<Aluno> getAlunoList() {
        return alunoList;
    }

    public void setAlunoList(List<Aluno> alunoList) {
        this.alunoList = alunoList;
    }

    public String getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(String idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Map<Integer, String> getDiasSemanaMap() {
        return diasSemanaMap;
    }

    public void setDiasSemanaMap(Map<Integer, String> diasSemanaMap) {
        this.diasSemanaMap = diasSemanaMap;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

}
