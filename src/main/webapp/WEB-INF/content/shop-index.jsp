<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en"> 
    <head>
        <s:include value="header.jsp" />
        <title>Shop</title>
    </head>
    <body>

        <div class="col-md-12">
            <ol class="breadcrumb">
                <li><a href="<%=request.getContextPath()%>/dashboard">Home</a></li>
                <li class="active">Shop</li>
            </ol>
            <div class="row">
                <div class="conteudo">
                    <div class="col-lg-2 col-md-2">
                        <h3 class="page-title">Shop</h3>
                    </div>
                    </br>
                    <div class="col-md-10">
                        <div class="col-md-10">
                        </div>
                    </div>
                </div>
            </div>
            <s:include value="footer.jsp" />
    </body>
</html>
