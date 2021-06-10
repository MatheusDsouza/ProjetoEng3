<%@page import="br.com.crud.model.Turma"%>
<%@page import="br.com.crud.dao.TurmaDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
        <title>Cadastro de Aluno</title>

        <script >
            function retornar() {
                history.go(-1);
            }
        </script>
        
    </head>
    
    <body>

        <br/>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-6">

					<h1>Cadastrar Novo Aluno</h1><br/>
					<div class="text-danger">
						<c:if test="${not empty mensagem}">
					    	<c:out value="${mensagem}"/>
						</c:if>
					</div>
                    <form action="SalvarAluno" method="POST">

                        <div class="form-group">
                            <label class="mb-1 mt-2">RA</label>
                            <input type="text" class="form-control" id="raAluno" name="raAluno" placeholder="RA do Aluno" required="true" maxlength="12">
                        </div>

                        <div class="form-group">
                            <label class="mb-1 mt-2">Nome</label>
                            <input type="text" class="form-control" id="nomeAluno" name="nomeAluno" placeholder="Nome do Aluno" required="true">
                        </div>

                        <div class="form-group">
                            <label class="mb-1 mt-2">Turma</label>
                            <br />
                            <select class="custom-select" id="turmaAluno" name="turmaAluno" required="true">
                                <option selected value="">Selecione a turma do Aluno</option>
                                <c:forEach items="${turmas}" var="turma">                         		
	                             			<option value="${turma.getId()}">${turma.getTurma()}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label class="mb-1 mt-2">Pai do Aluno</label>
                            <input type="text" class="form-control" id="paiAluno" name="paiAluno" placeholder="Nome do Pai do Aluno" required="true">
                        </div>

                        <div class="form-group">
                            <label class="mb-1 mt-2">Mãe do Aluno</label>
                            <input type="text" class="form-control" id="maeAluno" name="maeAluno" placeholder="Nome da Mãe do Aluno" required="true">
                        </div>

                        <div class="form-group">
                            <label class="mb-1 mt-2">Telefone</label>
                            <input type="text" class="form-control" id="telefoneAluno" name="telefoneAluno" placeholder="Telefone do Aluno" required="true" maxlength="11">
                        </div>
                        
                        <div class="form-group">
                            <label class="mb-1 mt-2">Idade</label>
                            <input type="number" class="form-control" id="idadeAluno" name="idadeAluno" placeholder="Idade do Aluno" required="true" min="0" step="1" >
                        </div>

                        <div class="form-group">
                            <label class="mb-1 mt-2">CEP</label>
                            <input type="text" class="form-control" id="cepAluno" name="cepAluno" placeholder="CEP do Aluno" required="true" maxlength="8">
                        </div>

                        <div class="form-group">
                            <label class="mb-1 mt-2">Logradouro</label>
                            <input type="text" class="form-control" id="logradouroAluno" name="logradouroAluno"
                                placeholder="Logradouro do Aluno" required="true">
                        </div>

                        <div class="form-group">
                            <label class="mb-1 mt-2">Cidade</label>
                            <input type="text" class="form-control" id="cidadeAluno" name="cidadeAluno" placeholder="Cidade do Aluno" required="true">
                        </div>

                        <div class="form-group">
                            <label class="mb-1 mt-2">Estado</label>
                            <input required="true" type="text" class="form-control" id="estadoAluno" name="estadoAluno" placeholder="Estado do Aluno">
                        </div>
                        
                        <br/>
                        <div class="row justify-content-between">
                        
                            <div class="col-4">
                                <a href="javascript:retornar();" class="btn btn-outline-danger">Voltar</a>
                            </div>
                        
                            <div class="col-3">
                                <button id="OPERACAO" name="OPERACAO" value="SALVAR" type="submit" class="btn btn-primary">Cadastrar Aluno</button>
                            </div>

                        </div>

                    </form>

                </div>
            </div>
        </div>
        <br/>



        <script type="javascript" src="assets/js/bootstrap.min.js"></script>
    </body>

    </html>