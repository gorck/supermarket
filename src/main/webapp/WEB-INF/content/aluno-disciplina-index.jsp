<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en"> 
    <head>
        <s:include value="header.jsp" />
        <title>Matriculas</title>
    </head>
    <body>

        <div class="col-md-12">
            <ol class="breadcrumb">
                <li><a href="<%=request.getContextPath()%>/dashboard">Home</a></li>
                <li class="active">Matriculas</li>
            </ol>
            <div class="row">
                <div class="conteudo">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 toppad">
                        <h3 class="page-title">Matriculas</h3>
                        <div class="col-xs-2"> <!-- required for floating -->
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs nav-stacked">
                                <li class="active"><a href="#matriculas" data-toggle="tab">Matriculas</a></li> 
                                <li><a href="#aluno" data-toggle="tab">Alunos</a></li>
                                <li><a href="#disciplinas" data-toggle="tab">Disciplinas</a></li>
                            </ul>
                        </div>
                        <div class="col-xs-10">
                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div class="tab-pane tab-pane active" id="matriculas">
                                    <div class="col-md-3">
                                        <a class='btn btn-primary' href=aluno-disciplina/new><i class='fa fa-edit'></i>&nbsp; Matricular um aluno em uma disciplina</a>
                                    </div>
                                    <div>&nbsp;</div>
                                    <div>&nbsp;</div>

                                    <div class="panel-danger" id="accordion" role="tablist" aria-multiselectable="true">
                                        <s:iterator value="disciplinaList">
                                            <div class="panel panel-default">
                                                <div class="panel-heading" role="tab" id="headingOne">
                                                    <h4 class="panel-title">
                                                        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#<s:property value="idDisciplina"/>" aria-expanded="false" aria-controls="collapseOne">
                                                            <s:property value="nmDisciplina" /> -  <s:property value="turnoDisciplina.dsTurnoDisciplina" /> - (<s:property value="alunoList.size()" />)
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="<s:property value="idDisciplina"/>" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                                                    <div class="panel-body">
                                                        <table id="alunoMatriculadoTable" class="table table-striped table-condensed table-bordered">
                                                            <thead>
                                                                <tr>
                                                                    <th style="width: 45%">Nome</th>
                                                                    <th style="width: 25%">Email</th>
                                                                    <th style="width: 25%">Telefone</th>
                                                                    <th style="width: 5%" class="centro">Ação</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <s:if test="alunoList.size()>0">
                                                                    <s:iterator value="alunoList">
                                                                        <tr>
                                                                            <td><s:property value="nmAluno" /></td>
                                                                            <td><s:property value="dsEmail" /></td>
                                                                            <td><s:property value="nrTelefone" /></td>
                                                                            <td class="centro">
                                                                                <a class='btn btn-xs btn-primary' href=aluno/<s:property value="idAluno.idAluno" />/edit><i class='fa fa-edit'></i>&nbsp; Editar Aluno</a>
                                                                            </td>
                                                                        </tr>
                                                                    </s:iterator>
                                                                </s:if><s:else>
                                                                    <tr>
                                                                        <td colspan="4">Nenhum aluno encontrado</td>
                                                                    </tr>
                                                                </s:else>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </s:iterator>
                                    </div>

                                </div>
                                <div class="tab-pane" id="aluno">
                                    <div class="row">
                                        <div class=" col-md-12 col-lg-12 ">
                                            <div class="tab-content">
                                                </br>
                                                <table id="alunoTable" class="table table-striped table-condensed table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th style="width: 50%">Nome</th>
                                                            <th style="width: 25%">Email</th>
                                                            <th style="width: 15%">Telefone</th>
                                                            <th style="width: 10%" class="centro">Ação</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <s:iterator value="alunos">
                                                            <tr <s:if test="!fgAtivo"> class="inativo hide"</s:if>>
                                                                <td><s:property value="nmAluno" /></td>
                                                                <td><s:property value="dsEmail" /></td>
                                                                <td><s:property value="nrTelefone" /></td>
                                                                <td class="centro">
                                                                    <a class='btn btn-xs btn-primary' href=aluno/<s:property value="idAluno" />/edit><i class='fa fa-edit'></i>&nbsp; Editar</a>
                                                                </td>
                                                            </tr>
                                                        </s:iterator>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="disciplinas">
                                    <div class="row">
                                        <div class=" col-md-12 col-lg-12 ">
                                            <div class="tab-content">
                                                </br>
                                                <table id="alunoMatriculadoTable" class="table table-striped table-condensed table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th style="width: 60%">Nome</th>
                                                            <th style="width: 30%">Turno</th>
                                                            <th style="width: 10%" class="centro">Ação</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <s:iterator value="disciplinaList">
                                                            <tr>
                                                                <td><s:property value="nmDisciplina" /></td>
                                                                <td class="centro" ><s:property value="turnoDisciplina.dsTurnoDisciplina"/></td>
                                                                <td class="centro">
                                                                    <a class='btn btn-xs btn-primary' target="_blank" href=disciplina/<s:property value="idDisciplina"/>/edit><i class='fa fa-edit'></i>&nbsp; Editar</a>
                                                                </td>
                                                            </tr>
                                                        </s:iterator>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>  
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <s:include value="footer.jsp" />
    </body>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/aluno.js"></script>
</html>
