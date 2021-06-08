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
                	
					
                	<h1>Editar Aluno</h1>
                	
                	<div class="text-danger">
						<c:if test="${not empty mensagem}">
					    	<c:out value="${mensagem}"/>
						</c:if>
					</div>
                	
                    <form action="EditarAluno" method="POST">
						<input type="hidden" id="idAluno" name="idAluno" value="${aluno.getId()}">
						<input type="hidden" id="idEndereco" name="idEndereco" value="${aluno.getEndereco().getId()}">
                        <div class="form-group">
                            <label class="mb-1">RA</label>
                            <input type="number" class="form-control" id="raAluno" name="raAluno" value="${aluno.getRa()}" required="true" maxlength="12">
                        </div>

                        <div class="form-group">
                            <label class="mb-1 mt-2">Nome</label>
                            <input type="text" class="form-control" id="nomeAluno" name="nomeAluno" value="${aluno.getNome()}" required="true" value="teste">
                        </div>

                        <div class="form-group">
                            <label class="mb-1 mt-2">Turma</label>
                            <br />
                            <select class="custom-select" id="turmaAluno" name="turmaAluno" required="true">
                             	<c:forEach items="${turmas}" var="turma">
                             		<c:choose>
	                             		<c:when test="${turma.getId() == aluno.getTurma().getId()}">
	                             			<option selected value="${turma.getId()}">${turma.getTurma()}</option>
	                             		</c:when>
	                             		<c:otherwise>
	                             			<option value="${turma.getId()}">${turma.getTurma()}</option>
	                             		</c:otherwise>
                             		</c:choose>
                                </c:forEach>
                                
                            </select>
                        </div>

                        <div class="form-group">
                            <label class="mb-1 mt-2">Pai do Aluno</label>
                            <input type="text" class="form-control" id="paiAluno" name="paiAluno"  required="true" value="${aluno.getNomePai()}">
                        </div>

                        <div class="form-group">
                            <label class="mb-1 mt-2">Mãe do Aluno</label>
                            <input type="text" class="form-control" id="maeAluno" name="maeAluno" value="${aluno.getNomeMae()}" required="true">
                        </div>

                        <div class="form-group">
                            <label class="mb-1 mt-2">Telefone</label>
                            <input type="text" class="form-control" id="telefoneAluno" name="telefoneAluno" value="${aluno.getTelefone()}" required="true">
                        </div>
						<div class="form-group">
                            <label class="mb-1 mt-2">Idade</label>
                            <input required="true" type="number" class="form-control" id="idadeAluno" name="idadeAluno" value="${aluno.getIdade()}" min="0" step="1" onkeydown="return event.keyCode !== 69">
                        </div>
                        <div class="form-group">
                            <label class="mb-1 mt-2">CEP</label>
                            <input type="text" class="form-control" id="cepAluno" name="cepAluno" value="${aluno.getEndereco().getCep()}" required="true">
                        </div>

                        <div class="form-group">
                            <label class="mb-1 mt-2">Logradouro</label>
                            <input type="text" class="form-control" id="logradouroAluno" name="logradouroAluno"
                                value="${aluno.getEndereco().getLogradouro()}" required="true">
                        </div>

                        <div class="form-group">
                            <label class="mb-1 mt-2">Cidade</label>
                            <input type="text" class="form-control" id="cidadeAluno" name="cidadeAluno" value="${aluno.getEndereco().getCidade().getCidade()}" required="true">
                        </div>

                        <div class="form-group">
                            <label class="mb-1 mt-2">Estado</label>
                            <input required="true" type="text" class="form-control" id="estadoAluno" name="estadoAluno" value="${aluno.getEndereco().getCidade().getEstado().getUf()}">
                        </div>
                        <br/>
                        <div class="row justify-content-between">
		                    <div class="col-1">
		               			 <a href="ConsultarAluno?OPERACAO=CONSULTAR" class="btn btn-outline-danger">Voltar</a>
				            </div>
				            <div class="col-1">
	                        	<button id="OPERACAO" name="OPERACAO" value="EDITAR" type="submit" class="btn btn-primary">Editar Aluno</button>
	                    	</div>
                    	</div>
                    </form>

                </div>
            </div>
        </div>
        <script type="javascript" src="assets/js/bootstrap.min.js"></script>
    </body>

    </html>