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
                <li><a href="<%=request.getContextPath()%>/item">Item</a></li>
                <li class="active">novo</li>
            </ol>
            <div class="conteudo">

                <s:form id="itemForm" namespace="/" action="%{#request.contextPath}/item!salvar" cssClass="form-horizontal" method="post" novalidate="novalidate" theme="simple">
                    <input type="hidden" id="url" value="<%=request.getContextPath()%>"/>
                    <s:hidden id="id" name="item.idItem"/>
                    <div class="col-md-12">
                        <div class="form-group obrigatorio">
                            <label class="col-md-2 control-label" for="descricao">
                                Descrição do Item
                            </label>
                            <div class="col-md-6">
                                <s:textfield id="descricao" name="item.descricao" cssClass="form-control" maxlength="100" />
                            </div>
                        </div>
                        <div class="form-group obrigatorio">
                            <label class="col-md-2 control-label" for="nmCliente">
                                Tag RFID
                            </label>
                            <div class="col-md-6">
                                <s:textfield id="tgrfid" name="item.tagRfid" cssClass="form-control" maxlength="100" />
                            </div>
                        </div>
                        <div class="form-group obrigatorio">
                            <label class="col-md-2 control-label" for="valor">
                                Valor 
                            </label>
                            <div class="col-md-2">
                                <s:textfield id="valor" name="item.valor" cssClass="form-control numeric" maxlength="100"  />
                            </div>
                            <div class="form-group obrigatorio">
                                <label class="col-md-2 control-label" for="qtEstoque">
                                    Quantidade Estoque
                                </label>
                                <div class="col-md-2">
                                    <s:textfield id="qtEstoque" name="item.qtEstoque" cssClass="form-control numeric" maxlength="100" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-actions">
                        <s:submit cssClass="btn btn-primary" value="Salvar" label="Salvar"/>
                        <a class='btn btn-default' href="<%=request.getContextPath()%>/item"><i class='fa fa-undo'></i>&nbsp; Cancelar</a>
                    </div>
                </s:form>
            </div> 
            <s:include value="footer.jsp" />
        </div>
    </body>

</html>
