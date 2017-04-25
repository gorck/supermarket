<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<table id="presenteTable" class="table table-striped table-condensed table-bordered">
    <thead>
        <tr>
            <th class="centro"style="width: 5%">x</th>
            <th class="centro">Nome</th>
            <th class="centro"style="width: 20%">Ação</th>
        </tr>
    </thead>
    <tbody>
        <s:if test="!alunoList.isEmpty()">
            <s:iterator value="alunoList" status="st">
                <tr>
                    <td class="centro"><s:property value="%{#st.index+1}" /></td>
                    <td achou="sim"><s:property value="nmAluno" /></td>
                    <td class="centro">
                        <button class="btn btn-xs btn-danger" type="button" onclick="removeMatricula(<s:property value="idAluno" />)"><i class='fa fa-edit'></i>&nbsp; Remover</button>
                </tr>
            </s:iterator>
        </s:if><s:else>
            <tr><td achou="nao" colspan="6">Nenhum aluno encontrado</td></tr>
        </s:else>
    </tbody>
</table>