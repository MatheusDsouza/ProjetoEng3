<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
        <title>Consulta de Aluno</title>
    </head>

    <body>


        <div class="container">
            <div class="row justify-content-center">
                <div class="col-6">


                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">RA</th>
                                <th scope="col">Nome</th>
                                <th scope="col">Nome do Pai</th>
                                <th scope="col">Nome da Mãe</th>
                                <th scope="col">Telefone</th>
                            </tr>
                        </thead>

                        <tbody>
                        	<c:forEach items="${alunos}" var="aluno">
	                            <tr>
	                                <td><c:out value = "${aluno.getRa()}"/></td>
	                                <td><c:out value = "${aluno.getNome()}"/></td>
	                                <td><c:out value = "${aluno.getNomePai()}"/></td>
	                                <td><c:out value = "${aluno.getNomeMae()}"/></td>
                                    <td><c:out value = "${aluno.getTelefone()}"/></td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>

        <script type="javascript" src="assets/js/bootstrap.min.js"></script>
    </body>

    </html>