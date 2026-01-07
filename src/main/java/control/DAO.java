package control;
import java.sql.*;

public class DAO {
	private Connection conn = null;
	private String url, sql, user, senha;
	
	public DAO() {
		url = "jdbc:mysql://localhost:3306/agenda";
		user = "root";
		//senha = "fitodb";
		senha = "";
	}
	public Connection abreConexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, senha);
			Statement stmt = conn.createStatement();
			sql = "SELECT * FROM contato";
			stmt.execute(sql);
			stmt.close();
			return conn;
		}
		catch(SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
			return null;
		}
	}
	public void fechaConexao() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Connection abreConsulta(String user, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
			return null;
		}
	}
}
