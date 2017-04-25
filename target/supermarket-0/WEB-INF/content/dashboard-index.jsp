<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <s:include value="header.jsp" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/metro-ui/css/metro-custom.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/metro-ui/css/metro-icons.css">
        <title>Trabalho</title>
    </head>
    <body> 
        <div class="col-md-12">
            <ol class="breadcrumb">
                <li class="active">Home</li>
            </ol>
            <div class="row">
                <div class="conteudo">
                    <div class="col-lg-12 col-md-12">
                        <h3 class="page-title">Menu</h3>
                    </div>
                    <div class="col-md-12 "  style="margin-bottom: 15px; ">
                        <a href="<%=request.getContextPath()%>/consultar">
                            <div class=" col-md-6 " style="">
                                <div class="col-md-12 bg-amber fg-white" style="">
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    <h1>
                                        <div class="tile-content iconic centro" style="padding-top: 30px;">
                                            <span class="fa fa-search"></span>
                                        </div>
                                    </h1>
                                    <h3>
                                        <div class="tile-label centro">Consultar</div>
                                    </h3>
                                    </br>
                                    </br>
                                    </br>
                                </div> 
                            </div> 
                        </a>
                        <a href="<%=request.getContextPath()%>/item">
                            <div class=" col-md-6 row" style="  ">
                                <div class=" col-md-12 bg-darkBlue fg-white" style="  ">
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    <h2>
                                        <div class="tile-content iconic centro" style="padding-top: 30px;">
                                            <span class="fa fa-tags"></span>
                                        </div>
                                    </h2>
                                    <h3>
                                        <div class="tile-label centro">Itens</div>
                                    </h3>
                                    </br>
                                    </br>
                                    </br>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-12"  style="margin-bottom: 15px; ">
                        <a href="<%=request.getContextPath()%>/shop">
                            <div class=" col-md-6" style=" ">
                                <div class=" col-md-12 bg-darkCrimson fg-white" style=" ">
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    <h1>
                                        <div class="tile-content iconic centro" style="padding-top: 30px;">
                                            <span class="fa fa-cart-plus"></span>
                                        </div>
                                    </h1>
                                    <h3>
                                        <div class="tile-label centro">Realizar Compra</div>
                                    </h3>
                                    </br>
                                    </br>
                                    </br>
                                </div>
                            </div>
                        </a>
                        <a href="<%=request.getContextPath()%>/show-list">
                            <div class=" col-md-6 row">
                                <div class=" col-md-12 bg-darkGreen fg-white " style=" ">
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    <h2>
                                        <div class="tile-content iconic centro" style="padding-top: 30px;">
                                            <span class="fa fa-list-alt"></span>
                                        </div>
                                    </h2>
                                    <h3>
                                        <div class="tile-label centro">Compras</div>
                                    </h3>
                                    </br>
                                    </br>
                                    </br>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <s:include value="footer.jsp" />
    </div>
</body>
</html>
