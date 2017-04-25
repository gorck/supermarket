<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <s:include value="header.jsp" />
        <title>Dados do Aluno</title>
    </head>
    <body>
        <div class="col-md-12">
            <ol class="breadcrumb">
                <li><a href="<%=request.getContextPath()%>/dashboard">Home</a></li>
                <li><a href="<%=request.getContextPath()%>/aluno">Aluno</a></li>
                <li class="active"><s:property value="aluno.nmAluno"/></li>
            </ol>
            <div class="col-md-12">
                <h2>
                    <label class="col-md-4 control-label" for="nmAluno">
                        Cadastro de Aluno
                    </label>
                </h2>
            </div>
            <div>&nbsp;</div>
            <div class="conteudo">
                <s:form id="alunoForm" namespace="/" action="%{#request.contextPath}/aluno/%{id}" cssClass="form-horizontal" method="post" novalidate="novalidate" theme="simple">
                    <input type="hidden" id="url" value="<%=request.getContextPath()%>"/>
                    <s:if test="aluno != null">
                        <s:hidden id="id" name="aluno.idAluno"/>
                    </s:if>
                    <div class="col-md-12">

                        <div class="form-group obrigatorio">
                            <label class="col-md-2 control-label" for="nmAluno">
                                Nome
                            </label>
                            <div class="col-md-6">
                                <s:textfield id="nmAluno" name="aluno.nmAluno" cssClass="form-control" maxlength="100" />
                            </div>
                        </div>
                        <div class="form-group obrigatorio">
                            <label class="col-md-2 control-label" for="dsEmail">
                                Email
                            </label>
                            <div class="col-md-6">
                                <s:textfield id="dsEmail" name="aluno.dsEmail" cssClass="form-control" maxlength="100" />
                            </div>
                        </div>
                        <div class="form-group obrigatorio">
                            <label class="col-md-2 control-label" for="nrTelefone">
                                Telefone
                            </label>
                            <div class="col-md-6">
                                <s:textfield id="nrTelefone" name="aluno.nrTelefone" cssClass="form-control" maxlength="100" />
                            </div>
                        </div>
                        <div class="form-group obrigatorio">
                            <label class="col-md-2 control-label" for="nmCliente">
                                Tag RFID
                            </label>
                            <div class="col-md-6">
                                <s:textfield id="tgrfid" name="aluno.tagRfid" cssClass="form-control" maxlength="100" />
                            </div>
                        </div>
                        <div class="form-group obrigatorio">
                            <label class="col-md-2 control-label" for="nmCliente">
                                Ativo
                            </label>
                            <div class="col-md-6">
                                <s:checkbox id="fgAtivo" name="aluno.fgAtivo" value="true" data-toggle="toggle" data-size="mini" />
                            </div>
                        </div>
                    </div>
                    <div class="form-actions">
                        <s:submit cssClass="btn btn-primary" value="Salvar" label="Salvar"/>
                        <button type="button" class="btn btn-default"><a href="<%=request.getContextPath()%>/aluno"/>Cancelar</button>
                    </div>
                </s:form>
            </div>
        </div>
        <s:include value="footer.jsp" />
    </body>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/aluno.js"></script>
</html>
