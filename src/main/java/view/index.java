package view;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;

import model.*;
import control.*;

@WebServlet("/index")
public class index extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		contato model = (contato) session.getAttribute("model");
		
		if (model == null) {
			Contato c = new Contato();
			try {
				model = c.ConsultaContato(c.retornaUltimoId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("model", model);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Contato c = new Contato();
		
		String action = request.getParameter("action");
		String txtId = request.getParameter("txtId");
		
		if (action != null) {
			contato model = null;
			switch (action) {
			case "anterior":
				int idAnterior = Integer.parseInt(txtId) - 1;
				model = c.ConsultaContato(idAnterior);
				break;
			case "proximo":
				int idProximo = Integer.parseInt(txtId) + 1;
				model = c.ConsultaContato(idProximo);
				break;
			case "primeiro":
				try {
					model = c.ConsultaContato(c.retornaPrimeiroId());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "ultimo":
				try {
					model = c.ConsultaContato(c.retornaUltimoId());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "novo":
				model = new contato();
				break;
			case "salvar":
				model = new contato();
				model.setId(Integer.parseInt(txtId));
				model.setNome(request.getParameter("txtNome"));
				model.setTelefone(request.getParameter("txtTelefone"));
				model.setEndereco(request.getParameter("txtEndereco"));
				model.setComplemento(request.getParameter("txtComplemento"));
				model.setCidade(request.getParameter("txtCidade"));
				model.setEstado(request.getParameter("txtEstado"));
				
				try {
					if (txtId.equals(null) || txtId.isEmpty() || txtId.equals("0")) {
						c.InserirContato(model);
						response.getWriter().println("<script>alert('"+ "Contato Cadastrado" + "');"
								+ " window.location='index.jsp';</script>");
						return;
					} else {
						c.AtualizaContato(model);
						response.getWriter().println("<script>alert('"+ "Contato Atualizado" + "');"
								+ " window.location='index.jsp';</script>");
						return;
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				break;
			case "excluir":
				try {
					c.ExcluiContato(Integer.parseInt(txtId));
					response.getWriter().println("<script>alert('" + "Contato Exluido" + "'); "+
					"window.location='index.jsp';</script>");
					return;
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
			
			if (model != null) {
				session.setAttribute("model", model);
			}
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
