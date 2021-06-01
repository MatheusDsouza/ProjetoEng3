<%@page import="br.com.crud.model.Turma"%>
<%@page import="br.com.crud.dao.TurmaDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
        <title>Cadastro de Aluno</title>
    </head>

    <body>


        <div class="container">
            <div class="row">
                <div class="col-6">

                    <form action="SalvarAluno" method="POST">

                        <div class="form-group">
                            <label>RA</label>
                            <input type="text" class="form-control" id="raAluno" name="raAluno" placeholder="RA do Aluno" required="true">
                        </div>

                        <div class="form-group">
                            <label>Nome</label>
                            <input type="text" class="form-control" id="nomeAluno" name="nomeAluno" placeholder="Nome do Aluno" required="true">
                        </div>

                        <div class="form-group">
                            <label>Turma</label>
                            <br />
                            <select class="custom-select" id="turmaAluno" name="turmaAluno">
                                <option selected>Selecione a turma do Aluno</option>
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
                            <input type="text" class="form-control" id="paiAluno" name="paiAluno" placeholder="Nome do Pai do Aluno" required="true">
                        </div>

                        <div class="form-group">
                            <label>Mãe do Aluno</label>
                            <input type="text" class="form-control" id="maeAluno" name="maeAluno" placeholder="Nome da Mãe do Aluno" required="true">
                        </div>

                        <div class="form-group">
                            <label>Telefone</label>
                            <input type="text" class="form-control" id="telefoneAluno" name="telefoneAluno" placeholder="Telefone do Aluno" required="true">
                        </div>

                        <div class="form-group">
                            <label>CEP</label>
                            <input type="text" class="form-control" id="cepAluno" name="cepAluno" placeholder="CEP do Aluno" required="true">
                        </div>

                        <div class="form-group">
                            <label>Logradouro</label>
                            <input type="text" class="form-control" id="logradouroAluno" name="logradouroAluno"
                                placeholder="Logradouro do Aluno" required="true">
                        </div>

                        <div class="form-group">
                            <label>Cidade</label>
                            <input type="text" class="form-control" id="cidadeAluno" name="cidadeAluno" placeholder="Cidade do Aluno" required="true">
                        </div>

                        <div class="form-group">
                            <label>Estado</label>
                            <input required="true" type="text" class="form-control" id="estadoAluno" name="estadoAluno" placeholder="Estado do Aluno">
                        </div>

                        <button id="OPERACAO" name="OPERACAO" value="SALVAR" type="submit" class="btn btn-primary">Cadastrar Aluno</button>
                    </form>

                </div>
            </div>
        </div>




        <script type="javascript" src="assets/js/bootstrap.min.js"></script>
    </body>

    </html>