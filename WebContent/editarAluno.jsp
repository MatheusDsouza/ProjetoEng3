<%@page import="br.com.crud.model.Turma"%>
<%@page import="br.com.crud.dao.TurmaDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
        <title>Editar Aluno</title>
    </head>
    
    <body>

        <div class="container">
            <div class="row justify-content-center">
                <div class="col-6">

                    <form action="EditarAluno" method="POST">
						<input type="hidden" id="idAluno" name="idAluno" value="${aluno.getId()}">
						<input type="hidden" id="idEndereco" name="idEndereco" value="${aluno.getEndereco().getId()}">
                        <div class="form-group">
                            <label>RA</label>
                            <input type="text" class="form-control" id="raAluno" name="raAluno" value="${aluno.getRa()}" required="true">
                        </div>

                        <div class="form-group">
                            <label>Nome</label>
                            <input type="text" class="form-control" id="nomeAluno" name="nomeAluno" value="${aluno.getNome()}" required="true" value="teste">
                        </div>

                        <div class="form-group">
                            <label>Turma</label>
                            <br />
                            <select class="custom-select" id="turmaAluno" name="turmaAluno" required="true">
                                <option selected>${aluno.getTurma().getTurma()}</option>
                                <%
                                	TurmaDao turma = new TurmaDao();
                                	for (Turma t: turma.consultar()) {
                                		
                                %>
                                <option value="<%= t.getId()%>"><%= t.getTurma()%></option>
                                <%} %>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>Pai do Aluno</label>
                            <input type="text" class="form-control" id="paiAluno" name="paiAluno"  required="true" value="${aluno.getNomePai()}">
                        </div>

                        <div class="form-group">
                            <label>Mãe do Aluno</label>
                            <input type="text" class="form-control" id="maeAluno" name="maeAluno" value="${aluno.getNomeMae()}" required="true">
                        </div>

                        <div class="form-group">
                            <label>Telefone</label>
                            <input type="text" class="form-control" id="telefoneAluno" name="telefoneAluno" value="${aluno.getTelefone()}" required="true">
                        </div>

                        <div class="form-group">
                            <label>CEP</label>
                            <input type="text" class="form-control" id="cepAluno" name="cepAluno" value="${aluno.getEndereco().getCep()}" required="true">
                        </div>

                        <div class="form-group">
                            <label>Logradouro</label>
                            <input type="text" class="form-control" id="logradouroAluno" name="logradouroAluno"
                                value="${aluno.getEndereco().getLogradouro()}" required="true">
                        </div>

                        <div class="form-group">
                            <label>Cidade</label>
                            <input type="text" class="form-control" id="cidadeAluno" name="cidadeAluno" value="${aluno.getEndereco().getCidade().getCidade()}" required="true">
                        </div>

                        <div class="form-group">
                            <label>Estado</label>
                            <input required="true" type="text" class="form-control" id="estadoAluno" name="estadoAluno" value="${aluno.getEndereco().getCidade().getEstado().getUf()}">
                        </div>

                        <button id="OPERACAO" name="OPERACAO" value="EDITAR" type="submit" class="btn btn-primary">Editar Aluno</button>
                    </form>

                </div>
            </div>
        </div>




        <script type="javascript" src="assets/js/bootstrap.min.js"></script>
    </body>

    </html>