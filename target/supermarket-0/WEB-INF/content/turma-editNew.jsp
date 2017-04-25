<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <s:include value="header.jsp" />
        <title>Cadastro de Turma</title>
    </head>
    <body>

        <div class="col-md-12">
            <ol class="breadcrumb">
                <li><a href="<%=request.getContextPath()%>/aluno">Aluno</a></li>
                <li class="active">add</li>
            </ol>
            <div class="conteudo">
                <s:form id="aluno" namespace="/" action="%{#request.contextPath}/aluno/%{id}" cssClass="form-horizontal" method="post" novalidate="novalidate" theme="simple">


                    <div class="form-group obrigatorio">
                        <label class="col-md-2 control-label" for="nmCliente">
                            Nome
                        </label>
                        <div class="col-md-6">
                            <s:textfield id="nmAluno" name="aluno.nmAluno" cssClass="form-control" maxlength="100" />
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


                    <div class="form-actions">
                        <s:submit cssClass="btn btn-primary" value="Salvar" label="Salvar"/>
                        <button href="<%=request.getContextPath()%>/aluno#"  class="btn btn-default" >Cancelar</button>
                    </div>
                </div>
            </s:form>
        </div>
        <s:include value="footer.jsp" />
    </body>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/aluno.js"></script>
</html>
