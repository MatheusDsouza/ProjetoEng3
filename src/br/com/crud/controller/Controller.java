package br.com.crud.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.command.ConsultarCommand;
import br.com.crud.command.EditarCommand;
import br.com.crud.command.ExcluirCommand;
import br.com.crud.command.ICommand;
import br.com.crud.command.SalvarCommand;
import br.com.crud.model.EntidadeDominio;
import br.com.crud.model.Resultado;
import br.com.crud.vh.AlunoVH;
import br.com.crud.vh.IViewHelper;

public class Controller extends HttpServlet{

	private static final long serialVersionUID = 1L;

    Map<String, IViewHelper> vhs;
    Map<String, ICommand> cmd;
	
	Controller(){
		
		cmd = new HashMap<String, ICommand>();
        cmd.put("SALVAR", new SalvarCommand());
        cmd.put("EDITAR", new EditarCommand());
        cmd.put("CONSULTAR", new ConsultarCommand());
        cmd.put("EXCLUIR", new ExcluirCommand());
        
        vhs = new HashMap<String, IViewHelper>();
        vhs.put("/ProjEng3/SalvarAluno", new AlunoVH());
        vhs.put("/ProjEng3/ConsultarAluno", new AlunoVH());
        vhs.put("/ProjEng3/EditarAluno", new AlunoVH());
        vhs.put("/ProjEng3/ExcluirAluno", new AlunoVH());
        
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operacao = request.getParameter("OPERACAO");
        String uri = request.getRequestURI();

        Resultado resultado = new Resultado();

        IViewHelper vh = vhs.get(uri);
        ICommand command = cmd.get(operacao);

        EntidadeDominio ent = vh.getEntidade(request);

        resultado = command.executar(ent);

        vh.setView(resultado, request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operacao = request.getParameter("OPERACAO");
        String uri = request.getRequestURI();

        Resultado resultado = new Resultado();

        IViewHelper vh = vhs.get(uri);
        ICommand command = null;

        EntidadeDominio ent = vh.getEntidade(request);

        command = cmd.get(operacao);

        resultado = command.executar(ent);

        vh.setView(resultado, request, response);
	}
	
}
