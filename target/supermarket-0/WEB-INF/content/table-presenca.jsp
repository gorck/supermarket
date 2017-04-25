<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<table id="presenteTable" class="table table-striped table-condensed table-bordered">
    <thead>
        <tr>
            <th class="centro">Nome</th>
        </tr>
    </thead>
    <tbody>
        <s:if test="!alunoList.isEmpty()">
            <s:iterator value="alunoList" status="st">
                <tr>
                    <td achou="sim"><s:property value="nmAluno" /></td>
                </tr>
            </s:iterator>
        </s:if><s:else>
            <tr><td achou="nao" colspan="6">Nenhum aluno encontrado</td></tr>
        </s:else>
    </tbody>
</table>