import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Coneccao {
	public Coneccao() throws SQLException {
		Scanner entrada = new Scanner(System.in);
		System.out.println("-------------GERENCIAR CLIENTES------------------------");
		System.out.println("Update [1]");
		System.out.println("Listar [2]");
		System.out.println("Cadastrar [3]");
		System.out.println("Buscar Id [4]");
		System.out.println("------------------------------------------------------");
		int valor = 0;
		valor = entrada.nextInt();
		switch (valor) {
		case 4: 
			System.out.println("Digite seu id");
			valor = entrada.nextInt();
			getPessoa(valor);
			valor = 0;
			break;
		case 3:
			System.out.println("Digite seu nome");
			entrada.nextLine();
			String nome = entrada.nextLine();
			System.out.println("Olá "+nome+" Digite seu email");
			String email = entrada.nextLine();
			System.out.println("Digite seu cpf");
			int cpf = entrada.nextInt();
			System.out.println("Digite seu senha");
			entrada.nextLine();
			String senha = entrada.nextLine();
			setclientes(nome, email, cpf, senha);
			nome = "";
			cpf = 0;
			senha = "";
			email = "";
			break;
		case 2:
			getclientes();
			break;
		case 1:
			System.out.println("Qual seu ID?");
			int id = entrada.nextInt();
			update(id);
			break;
		
		}
		
	}

	public static void setclientes(String nome,String email, int cpf, String senha) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/agenciaviagens";
		Connection conn = DriverManager.getConnection(url, "root", "32384545");
		try {
			PreparedStatement ps = conn.prepareStatement("insert into clientes values(default, ?,?, ?, ?);");
			ps.setString(1, nome);
			ps.setString(2, email);
			ps.setInt(3, cpf);
			ps.setString(4, senha);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao conectar " + e);
		} finally {
			System.out.println("Cliente cadastrado!");
			conn.close();
		}
	}

	private static void getclientes() throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/agenciaviagens";
		Connection conn = DriverManager.getConnection(url, "root", "32384545");

		try {
			Statement ps = conn.createStatement();
			ResultSet ex = ps.executeQuery("SELECT * FROM agenciaviagens.clientes");
			while (ex.next()) {
				System.out.println("Id: " + ex.getInt("id") + " Nome: " + ex.getString("nome"));
			}
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao conectar " + e);
		} finally {
			System.out.println("Busca finalizada!");
			conn.close();
		}
	}
	private static void getPessoa(int id) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/agenciaviagens";
		Connection conn = DriverManager.getConnection(url, "root", "32384545");

		try {
			Statement ps = conn.createStatement();
			ResultSet ex = ps.executeQuery("SELECT * FROM agenciaviagens.clientes where id =" + id);
			while (ex.next()) {
				System.out.println("Id: " + ex.getInt("id") + " Nome: " + ex.getString("nome"));
			}
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao conectar " + e);
		} finally {
			System.out.println("Busca finalizada!");
			conn.close();
		}
	}
	private static void update(int id) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/agenciaviagens";
		Connection conn = DriverManager.getConnection(url, "root", "32384545");
		getPessoa(id);
		System.out.println("Para continuar aperte enter...");
		Scanner entrada = new Scanner(System.in);
		entrada.nextLine();
		
		System.out.print("Novo nome :");
		String nome = entrada.nextLine();
		System.out.print("Novo email :");
		String email = entrada.nextLine();
		
		try {
			PreparedStatement ps = conn.prepareStatement("update clientes set nome = ?, email = ? where id = ?;");
			ps.setString(1, nome);
			ps.setString(2, email);
			ps.setInt(3, id);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao conectar " + e);
		} finally {
			System.out.println("Mudanças foram efetuadas com sucesso!");
			conn.close();
		}
	}
}
