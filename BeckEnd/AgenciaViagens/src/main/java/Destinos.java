import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Destinos {
	public Destinos() throws SQLException {
		Scanner entrada = new Scanner(System.in);
		System.out.println("-------------GERENCIAR DESTINOS------------------------");
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
			getDestino(valor);
			valor = 0;
			break;
		case 3:
			System.out.print("Digite nome do destino :");
			entrada.nextLine();
			String nome = entrada.nextLine();
			System.out.print("Preparando nova viagem para "+nome+" Digite a descricao :");
			String descricao = entrada.nextLine();
			System.out.print("Digite o valor : R$");
			float preco = entrada.nextInt();
			setdestinos(nome, descricao, preco);
			nome = "";
			descricao = "";
			break;
		case 2:
			getdestinos();
			break;
		case 1:
			System.out.println("Qual ID do destino?");
			int id = entrada.nextInt();
			update(id);
			break;
		
		}
		
	}

	public static void setdestinos(String nome,String descricao, Float valor) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/agenciaviagens";
		Connection conn = DriverManager.getConnection(url, "root", "32384545");
		try {
			PreparedStatement ps = conn.prepareStatement("insert into destinos values(default, ?, ?, ?);");
			ps.setString(1, nome);
			ps.setString(2, descricao);
			ps.setFloat(3, valor);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao conectar " + e);
		} finally {
			System.out.println("Destino cadastrado com sucesso!");
			conn.close();
		}
	}

	private static void getdestinos() throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/agenciaviagens";
		Connection conn = DriverManager.getConnection(url, "root", "32384545");

		try {
			Statement ps = conn.createStatement();
			ResultSet ex = ps.executeQuery("SELECT * FROM agenciaviagens.destinos");
			while (ex.next()) {
				System.out.println("Id: " + ex.getInt("idDestino") + " Nome: " + ex.getString("nome"));
			}
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao conectar " + e);
		} finally {
			System.out.println("Busca finalizada!");
			conn.close();
		}
	}
	private static void getDestino(int id) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/agenciaviagens";
		Connection conn = DriverManager.getConnection(url, "root", "32384545");

		try {
			Statement ps = conn.createStatement();
			ResultSet ex = ps.executeQuery("SELECT * FROM agenciaviagens.destinos where idDestino =" + id);
			while (ex.next()) {
				System.out.println("Id: " + ex.getInt("idDestino") + " Nome: " + ex.getString("nome"));
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
		getDestino(id);
		System.out.println("Para continuar aperte enter...");
		Scanner entrada = new Scanner(System.in);
		entrada.nextLine();
		
		System.out.print("Novo destino :");
		String nome = entrada.nextLine();
		System.out.print("Descrição do novo destino : :");
		String descricao = entrada.nextLine();
		System.out.print("Quanto vai custar? R$");
		String valor = entrada.nextLine();
		
		try {
			PreparedStatement ps = conn.prepareStatement("update destinos set nome = ?, descricao = ?, valor = ? where idDestino = ?;");
			ps.setString(1, nome);
			ps.setString(2, descricao);
			ps.setString(3, valor);
			ps.setInt(4, id);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao conectar " + e);
		} finally {
			System.out.println("Mudanças no destino foram efetuadas com sucesso!");
			conn.close();
		}
	}
}
