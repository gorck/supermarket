<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <s:include value="header.jsp" />
        <title>Lista de Aluno</title>

    </head>
    <body>
        <div class="col-md-12">
            <ol class="breadcrumb">
                <li><a href="<%=request.getContextPath()%>/dashboard">Home</a></li>
                <li><a href="<%=request.getContextPath()%>/aluno-disciplina">Matricula</a></li>
                <li class="active">new</li>
            </ol>
            <div class="col-md-12">
                <h2>

                    <label class="col-md-4 control-label" for="nmAluno">
                        Matricula de Aluno
                    </label>
                </h2>
            </div>
            <div>&nbsp;</div>
            <div class="conteudo">
                <s:form id="disciplinaForm" namespace="/" action="%{#request.contextPath}/aluno-disciplina/%{id}/create" cssClass="form-horizontal" method="post" novalidate="novalidate" theme="simple">
                    <%--<s:form id="alunoDisciplinaForm" action="%{#request.contextPath}/aluno/%{id}/save" cssClass="form-horizontal" method="post" novalidate="verifica()" theme="simple">--%>
                    <s:hidden id="id" name="aluno.idAluno"/>
                    <input type="hidden" id="url" value="<%=request.getContextPath()%>"/>

                    <div class="form-group ">
                        <label class="col-md-2 control-label" for="categoriaCombo">
                            Turno
                        </label>
                        <div class="col-md-3">
                            <%--<s:action namespace="/ajax" name="loadTurnoDisciplina" executeResult="true"/>--%>
                            <s:select
                                id="comboDisciplina"
                                name="idDisciplina.idDisciplina"
                                list="disciplinaList"
                                listKey="idDisciplina"
                                listValue="nmDisciplina"
                                cssClass="form-control"
                                onchange="carregaAlunos();"
                                emptyOption="true"/>
                        </div>
                        <div id="divAlunos" class="col-md-5"></div>

                    </div>
                    <div class="form-group ">
                        <label class="col-md-2 control-label" for="categoriaCombo">
                            Alunos
                        </label>
                        <div class="col-md-3">
                            <s:select
                                id="comboAluno"
                                name="idAluno.idAluno"
                                list="alunoList"
                                listKey="idAluno"
                                listValue="nmAluno"
                                cssClass="form-control"
                                emptyOption="true"/>
                        </div>
                        <div class="col-md-3">
                            <button type="button" onclick="criaMatricula()" class="btn btn-primary">Salvar -></button>
                        </div>
                    </div>
                </s:form>
            </div>
        </div>
        <s:include value="footer.jsp" />
    </body>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/disciplina.js"></script>
</html>
