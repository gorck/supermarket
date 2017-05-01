<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en"> 
    <head>
        <s:include value="header.jsp" />
        <title>Consultar um Item</title>
    </head>
    <body>
        <div class="col-md-12">
            <ol class="breadcrumb">
                <li><a href="<%=request.getContextPath()%>/dashboard">Home</a></li>
                <li class="active">Consulta</li>
            </ol>
            <div class="row">
                <div class="conteudo">
                    <div class="col-lg-2 col-md-2">
                        <h3 class="page-title">Consultar um Item</h3>
                    </div>
                    </br>
                    <div class="col-md-10">
                        <div class="col-md-10">
                            </br>
                            </br>
                            </br>
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label class="col-md-2 control-label" for="descricao">
                                        Descrição do Item
                                    </label>
                                    <div class="col-md-6">
                                        <s:textfield id="descricao" name="item.descricao" cssClass="form-control" readonly="true" />
                                    </div>
                                </div>
                            </div>
                            <br>
                            <br>
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label class="col-md-2 control-label" for="valor">
                                        Valor 
                                    </label>
                                    <div class="col-md-2">
                                        <s:textfield id="valor" name="item.valor" cssClass="form-control numeric" readonly="true"/>
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
