<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <s:include value="header.jsp" />
        <title>Cadastro de Disciplina</title>
    </head>
    <body>
        <div class="col-md-12">
            <ol class="breadcrumb">
                <li><a href="<%=request.getContextPath()%>/dashboard">Home</a></li>
                <li><a href="<%=request.getContextPath()%>/disciplina">Disciplina</a></li>
                <li class="active"><s:property value="disciplina.nmDisciplina"/></li>
            </ol>
            <div class="conteudo">
                <%--<s:form id="disciplinaForm" namespace="/" action="%{#request.contextPath}/disciplina/%{id}/create" cssClass="form-horizontal" method="post" novalidate="novalidate" theme="simple">--%>
                <s:form id="disciplinaForm" namespace="/" action="%{#request.contextPath}/disciplina/%{id}/create" cssClass="form-horizontal" method="post" novalidate="novalidate" theme="simple">

                    <s:hidden id="id" name="disciplina.idDisciplina"/>
                    <input type="hidden" id="url" value="<%=request.getContextPath()%>"/>

                    <div class="col-md-12">
                        <div class="form-group obrigatorio">
                            <label class="col-md-2 control-label" for="nmDisciplina">
                                Nome
                            </label>
                            <div class="col-md-6">
                                <s:textfield id="nmDisciplina" name="disciplina.nmDisciplina" cssClass="form-control" maxlength="100" />
                            </div>
                        </div>
                        <div class="form-group ">
                            <label class="col-md-2 control-label" for="categoriaCombo">
                                Turno
                            </label>
                            <div class="col-md-5">
                                <%--<s:action namespace="/ajax" name="loadTurnoDisciplina" executeResult="true"/>--%>
                                <s:select
                                    id="comboTurno"
                                    name="disciplina.turnoDisciplina.idTurnoDisciplina"
                                    list="objetoList"
                                    listKey="idTurnoDisciplina"
                                    listValue="dsTurnoDisciplina"
                                    cssClass="form-control"
                                    emptyOption=""/>
                            </div>
                        </div>
                        <s:if test="scheduleList.size()==0">
                            <div class="form-group">
                                <label class="col-md-2 control-label" for="dt">
                                    Data de Inicio
                                </label>
                                <div class="col-md-3">
                                    <s:textfield id="dt" cssClass="form-control data" maxlength="10" />
                                </div>
                                <div class="col-md-3">
                                    <button type="button" onclick="gerar()" class="btn btn-default" >Gerar Schedule</button>
                                </div>
                            </div>
                        </s:if><s:else>
                            <s:if test="id!=null">


                                <div class="col-md-12">
                                    <div class="col-md-6">
                                        <table id="scheduleTable" class="table table-striped table-condensed table-bordered">
                                            <thead>
                                                <tr>
                                                    <th style="width: 5%" class="centro">#</th>
                                                    <th class="centro">Dia</th>
                                                    <th class="centro">Data</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <s:iterator value="scheduleList" status="st">
                                                    <tr>
                                                        <td class="centro"><s:property value="%{#st.index+1}" /></td>
                                                        <td class="centro"><s:property value="diaString" /></td>
                                                        <td class="centro"><s:property value="dtSchedule" />&nbsp; &nbsp;
                                                            <button type="button" onclick="carregaPresenca('<s:property value="idSchedule" />')" class="btn btn-xs btn-success" >Ver Presenças<i></i></button>
                                                            <button type="button" onclick="adicionaPresenca('<s:property value="idSchedule" />')" class="btn btn-xs btn-success" >Adicionar<i></i></button>
                                                        </td>
                                                    </tr>
                                                </s:iterator>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div id="divPresente" class="col-md-5"></div>
                                </div>
                            </s:if>
                        </s:else>
                        <div class="form-actions">
                            <s:submit cssClass="btn btn-primary" value="Salvar" label="Salvar"/>
                            <button type="button" class="btn btn-default"><a href="<%=request.getContextPath()%>/disciplina"/>Cancelar</button>
                        </div>
                    </div>
                </s:form>
            </div> 
            <s:include value="footer.jsp" />
        </div>
    </body>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.maskedinput.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.mask.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/disciplina.js"></script>
</html>
