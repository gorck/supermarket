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
                <li class="active">Iten</li>
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
                            <table id="alunoTable" class="table table-striped table-condensed table-bordered">
                                <thead>
                                    <tr>
                                        <th style="width: 5%">Cod</th>
                                        <th style="width: 30%" class="">Descrição</th>
                                        <th style="width: 10%" class="">Valor</th>
                                        <th style="width: 10%" class="">Qt Estoque</th>
                                        <th style="width: 20%" class="">Tag</th>
                                        <th style="width: 5%" class="centro">Ação</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <s:iterator value="itemList">
                                        <tr>
                                            <td><s:property value="idItem" /></td>
                                            <td><s:property value="descricao" /></td>
                                            <td><s:property value="valor" /></td>
                                            <td><s:property value="qtEstoque" /></td>
                                            <td><s:property value="tagRfid" /></td>
                                            <td class="centro">
                                                <a class='btn btn-xs btn-primary' href=item/<s:property value="idItem"/>/edit><i class='fa fa-edit'></i>&nbsp; Editar</a>
                                            </td>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                            <div class="form-actions">
                                <a href="item/new" class="btn btn-primary"><i class="fa fa-file"></i>&nbsp;Adicionar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <s:include value="footer.jsp" />
    </body>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/item.js"></script>
</html>
