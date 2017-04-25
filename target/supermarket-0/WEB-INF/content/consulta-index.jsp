<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en"> 
    <head>
        <s:include value="header.jsp" />
        <title>Consulta de Itens</title>
    </head>
    <body>
        <div class="col-md-12">
            <ol class="breadcrumb">
                <li><a href="<%=request.getContextPath()%>/dashboard">Home</a></li>
                <li class="active">Consulta de Itens</li>
            </ol>
            <div class="row">
                <div class="conteudo">
                    <div class="col-md-12">
                        <h3 class="page-title">Matriculas</h3>                  
                        <div class="col-md-2">

                        </div>                         
                        <div class="col-md-10">
                            <div class="form-group">
                                <label class="col-md-1 control-label" for="nmAluno">
                                    Código
                                </label>
                                <div class="col-md-7">
                                    <s:textfield id="codigo" name="tagRFID" cssClass="form-control" maxlength="100" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <s:include value="footer.jsp" />
    </body>
</html>
