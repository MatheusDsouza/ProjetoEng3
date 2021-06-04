<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

            <br />
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-flex">

                        <table class="table">

                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
                                    <th scope="col">RA</th>
                                    <th scope="col">Nome</th>
                                    <th scope="col">Turma</th>
                                    <th scope="col">Professor da Turma</th>
                                    <th scope="col">Nome do Pai</th>
                                    <th scope="col">Nome da Mãe</th>
                                    <th scope="col">Rua</th>
                                    <th scope="col">Cidade</th>
                                    <th scope="col">Estado</th>
                                    <th scope="col">Telefone</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${alunos}" var="aluno" end="${alunos.size() - 2}">
                                    <tr>
                                        <td>
                                            <form method="GET" action="FormEditarAluno">
                                            	<input type="hidden" id="idAluno" name="idAluno" value="${aluno.getId()}">
                                                <button type="submit" id="REDIRECIONAMENTO" name="REDIRECIONAMENTO" class="btn btn-outline-warning">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square"
                                                        viewBox="0 0 16 16">
                                                        <path
                                                            d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z">
                                                        </path>
                                                        <path fill-rule="evenodd"
                                                            d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z">
                                                        </path>
                                                    </svg>
                                                </button>
                                            </form>
                                        </td>
                                        <td>
                                            <form method="POST" action="ExcluirAluno">
                                                <input type="hidden" id="idAluno" name="idAluno" value="${aluno.getId()}">
                                                <button id="OPERACAO" name="OPERACAO" value="EXCLUIR" type="submit" class="btn btn-outline-danger">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash"
                                                        viewBox="0 0 16 16">
                                                        <path
                                                            d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z">
                                                        </path>
                                                        <path fill-rule="evenodd"
                                                            d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z">
                                                        </path>
                                                    </svg>
                                                </button>
                                            </form>
                                        </td>

                                        <td><c:out value="${aluno.getRa()}" /></td>
                                        <td><c:out value="${aluno.getNome()}" /></td>
                                        <td><c:out value="${aluno.getTurma().getTurma()}" /></td>
                                        <td><c:out value="${aluno.getTurma().getProfessor().getNome()}" /></td>
                                        <td><c:out value="${aluno.getNomePai()}" /></td>
                                        <td><c:out value="${aluno.getNomeMae()}" /></td>
                                        <td><c:out value="${aluno.getEndereco().getLogradouro()}" /></td>
                                        <td><c:out value="${aluno.getEndereco().getCidade().getCidade()}" /></td>
                                        <td><c:out value="${aluno.getEndereco().getCidade().getEstado().getUf()}" /></td>
                                        <td><c:out value="${aluno.getTelefone()}" /></td>
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