package control;
import model.*;
import control.*;
import java.sql.*;
import java.util.*;

import control.DAO;

public class Contato {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs;
	private String sql;
	
	public Contato() {}
	
	public void InserirContato(contato c) throws SQLException {
		DAO database = new DAO();
		try {
			database.abreConexao();
			sql = "INSERT INTO contato (nome, telefone, endereco,"
					+ " complemento, cidade, estado) values (?, ?, ?, ?, ?, ?)";
			stmt = database.abreConexao().prepareStatement(sql);
			
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getTelefone());
			stmt.setString(3, c.getEndereco());
			stmt.setString(4, c.getComplemento());
			stmt.setString(5, c.getCidade());
			stmt.setString(6, c.getEstado());
			
			stmt.executeUpdate();
		}
		catch(SQLException e1) {
			System.out.println(e1.getMessage());
		}
		finally {
			if(stmt != null) {
				stmt.close();
			}
			database.fechaConexao();
		}
		
	}
	
	public contato ConsultaContato(int id) {
		contato cont = new contato();
		DAO database = new DAO();
		try {
			sql = "SELECT * FROM contato WHERE id ="+id;
			stmt = database.abreConexao().prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			cont.setCidade(rs.getObject("cidade").toString());
			cont.setComplemento(rs.getObject("complemento").toString());
			cont.setEndereco(rs.getObject("endereco").toString());
			cont.setEstado(rs.getObject("estado").toString());
			cont.setId(Integer.parseInt(rs.getObject("id").toString()));
			cont.setNome(rs.getObject("nome").toString());
			cont.setTelefone(rs.getObject("telefone").toString());
			
			return cont;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			database.fechaConexao();
		}
	}
	
	public void AtualizaContato(contato c) throws SQLException {
		DAO database = new DAO();
		try {
			database.abreConexao();
			sql = "UPDATE contato SET nome=?, telefone=?, endereco=?, "
					+ "complemento=?, cidade=?, estado=?, WHERE id=?";
			stmt = database.abreConexao().prepareStatement(sql);
			
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getTelefone());
			stmt.setString(3, c.getEndereco());
			stmt.setString(4, c.getComplemento());
			stmt.setString(5, c.getCidade());
			stmt.setString(6, c.getEstado());
			stmt.setInt(7, c.getId());
			
			stmt.executeUpdate();
		}
		catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		finally {
			if(stmt != null) {
				stmt.close();
			}
			database.fechaConexao();
		}
	}
	
	public void ExcluiContato(int id) throws SQLException {
		DAO database = new DAO();
		try {
			sql = "DELETE FROM CONTATO WHERE id = "+id;
			stmt = database.abreConexao().prepareStatement(sql);
			stmt.executeUpdate();
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			stmt.close();
			database.fechaConexao();
		}
	}
	
	public int retornaPrimeiroId() throws SQLException {
		DAO database = new DAO();
		sql = "SELECT MIN(id) FROM contato";
		try {
			stmt = database.abreConexao().prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			if (rs.getObject(1) != null) {
				return Integer.parseInt(rs.getObject(1).toString());
			}
			else {
				return 0;
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return 0;
		}
		finally {
			stmt.close();
			database.fechaConexao();
		}
	}
	
	public int retornaUltimoId() throws SQLException {
		DAO database = new DAO();
		sql = "SELECT MAX(id) FROM contato";
		try {
			stmt = database.abreConexao().prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			if (rs.getObject(1) != null) {
				return Integer.parseInt(rs.getObject(1).toString());
			}
			else {
				return 0;
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return 0;
		}
		finally {
			stmt.close();
			database.fechaConexao();
		}
	}
	
	public int ConsultaContatoTelefone(String Telefone) {
		DAO database = new DAO();

		try {
			sql="SELECT count(telefone) FROM contato WHERE Telefone = ?";
			stmt = database.abreConexao().prepareStatement(sql);
			stmt.setString(1, Telefone);
			rs = stmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			return count > 0 ? 1 : 0;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return 0;
		}
		finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			database.fechaConexao();
		}
	}
}
