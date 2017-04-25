<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en"> 
    <head>
        <s:include value="header.jsp" />
        <title>Lista de Disciplinas</title>
    </head>
    <body>

        <div class="col-md-12">
            <ol class="breadcrumb">
                <li><a href="<%=request.getContextPath()%>/dashboard">Home</a></li>
                <li class="active">Disciplina</li>
            </ol>
            <div class="row">
                <div class="conteudo">
                    <div class="col-lg-2 col-md-2">
                        <h3 class="page-title">Disciplina</h3>
                    </div>
                    <div class="col-md-10">
                        </br>
                        </br>
                        <table id="disciplinaTable" class="table table-striped table-condensed table-bordered">
                            <thead>
                                <tr>
                                    <th>Nome</th>
                                    <th style="width: 10%"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="disciplinaList" status="st">
                                    <tr>
                                        <td><s:property value="nmDisciplina" /></td>
                                        <td>
                                            <a class='btn btn-xs btn-primary' href=disciplina/<s:property value="idDisciplina" />/edit><i class='fa fa-edit'></i>&nbsp; Editar</a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                        <div class="form-actions">
                            <a href="disciplina/new" class="btn btn-primary"><i class="fa fa-file"></i>&nbsp;Adicionar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <s:include value="footer.jsp" />
    </body>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/aluno.js"></script>
</html>
