<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en"> 
    <head>
        <s:include value="header.jsp" />
        <title>Lista de Item</title>
    </head>
    <body>

        <div class="col-md-12">
            <ol class="breadcrumb">
                <li><a href="<%=request.getContextPath()%>/dashboard">Home</a></li>
                <li class="active">Compras</li>
            </ol>
            <div class="row">
                <div class="conteudo">
                    <div class="col-lg-2 col-md-2">
                        <h3 class="page-title">Item</h3>
                    </div>
                    </br>
                    <div class="col-md-10">
                        <div class="col-md-10">
                            </br>
                            <table id="itemTable" class="table table-striped table-condensed table-bordered">
                                <thead>
                                    <tr>
                                        <th style="width: 5%">Cod</th>
                                        <th style="width: 10%" class="">Data</th>
                                        <th style="width: 10%" class="">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <s:iterator value="itemList">
                                        <tr>
                                            <td><s:property value="idCompra" /></td>
                                            <td><s:property value="data" /></td>
                                            <td><s:property value="total" /></td>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
<!--                            <div class="form-actions">
                                <a href="compra/new" class="btn btn-primary"><i class="fa fa-file"></i>&nbsp;Adicionar</a>
                            </div>-->
                        </div>
                    </div>
                </div>
            </div>
            <s:include value="footer.jsp" />
    </body>
</html>
