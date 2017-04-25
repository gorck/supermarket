<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en"> 
    <head>
        <s:include value="header.jsp" />
        <title>Lista de Turmas</title>
    </head>
    <body>
        <div id="wrapper" class="">

            <div class="col-md-12">
                <div class="row">
                    <div class="conteudo">
                        <div class="col-lg-12 col-md-12">
                            <h3 class="page-title">Aluno</h3>
                        </div>
                        <div class="col-md-12">
                            <table id="categoria" class="table table-striped table-condensed table-bordered">
                                <thead>
                                    <tr>
                                        <th>Nome</th>
                                        <th>Status</th>
                                        <th style="width: 10%"></th>
                                    </tr>
                                </thead>
                                <tbody></tbody>
                            </table>
                            <div class="form-actions">
                                <a href="aluno/new" class="btn btn-primary"><i class="fa fa-file"></i>&nbsp;Adicionar</a>
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
