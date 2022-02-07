import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Compras {
	public Compras() throws SQLException {
		Scanner entrada = new Scanner(System.in);
		System.out.println("-------------GERENCIAR COMPRAS------------------------");
		System.out.println("Editar Venda [1]");
		System.out.println("Listar Vendas [2]");
		System.out.println("Realizar Vendas [3]");
		System.out.println("Buscar venda Id [4]");
		System.out.println("------------------------------------------------------");
		int valor = 0;
		valor = entrada.nextInt();
		switch (valor) {
		case 4: 
			System.out.println("Digite seu id");
			valor = entrada.nextInt();
			getcompras(valor);
			valor = 0;
			break;
		case 3:
			System.out.print("Digite o ID do cliente :");
			int cliente = entrada.nextInt();
			System.out.print("Digite o ID do destino :");
			int destino = entrada.nextInt();
			setcompras(cliente, destino);
			break;
		case 2:
			getcompras();
			break;
		case 1:
			System.out.println("Qual (ID) da compra ?");
			int id = entrada.nextInt();
			update(id);
			break;
		
		}
		
	}

	public static void setcompras(int cliente, int destino) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/agenciaviagens";
		Connection conn = DriverManager.getConnection(url, "root", "32384545");
		try {
			PreparedStatement ps = conn.prepareStatement("insert into compras values(default, ?, ?);");
			ps.setInt(1, cliente);
			ps.setInt(2, destino);
			ps.execute();
			System.out.println("Compra realizada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao conectar " + e);
		} finally {
			
			conn.close();
		}
	}

	private static void getcompras() throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/agenciaviagens";
		Connection conn = DriverManager.getConnection(url, "root", "32384545");

		try {
			Statement ps = conn.createStatement();
			ResultSet ex = ps.executeQuery("select * from listavendas;");
			while (ex.next()) {
				System.out.println("Id: " + ex.getInt("idCompra") + " Id Cliente: " + ex.getString("id") + " Email " + ex.getString("email")+ " Id Destino " + ex.getString("IdDestino")+ " Destino " + ex.getString("nome"));
			}
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao conectar " + e);
		} finally {
			System.out.println("Busca finalizada!");
			conn.close();
		}
	}
	private static void getcompras(int id) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/agenciaviagens";
		Connection conn = DriverManager.getConnection(url, "root", "32384545");

		try {
			Statement ps = conn.createStatement();
			ResultSet ex = ps.executeQuery("SELECT * FROM agenciaviagens.compras where idCompra =" + id);
			while (ex.next()) {
				System.out.println("Id: " + ex.getInt("idCompra") + " Id Cliente: " + ex.getString("idCliente") + " Id Destino " + ex.getString("idDestino"));
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
		getcompras(id);
		System.out.println("Para continuar aperte enter...");
		Scanner entrada = new Scanner(System.in);
		entrada.nextLine();
		
		System.out.print("Novo cliente (ID) :");
		int cliente = entrada.nextInt();
		System.out.print("Novo destino (ID) :");
		int	destino = entrada.nextInt();
		
		try {
			PreparedStatement ps = conn.prepareStatement("update compras set idCliente = ?, idDestino = ? where idCompra = ?;");
			ps.setInt(1, cliente);
			ps.setInt(2, destino);
			ps.setInt(3, id);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao conectar " + e);
		} finally {
			System.out.println("Mudan�as no destino foram efetuadas com sucesso!");
			conn.close();
		}
	}
}
