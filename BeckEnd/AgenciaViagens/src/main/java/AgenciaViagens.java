import java.sql.SQLException;
import java.util.Scanner;

public class AgenciaViagens {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		int valor = 0;
		System.out.println("----------------BEM VINDO A BAHIA TURISMO--------------------");
		while(true) {
			if(valor >= 4) {
				break;
			}
		System.out.println("------------------------------------------");
		System.out.println("Para realizar uma venda digite [1]");
		System.out.println("Para consultar um cliente      [2]");
		System.out.println("Para consultar um destino      [3]");
		System.out.println("Qualquer outro numero para finalizar");
		System.out.println("------------------------------------------");
		Scanner entrada2 = new Scanner(System.in);
		valor = entrada2.nextInt();
		switch(valor) {
		case 1:
			Compras destinos = new Compras();
			break;
		case 2:
			Coneccao cliente = new Coneccao();
			break;
		case 3:
			Destinos destino = new Destinos();
			break;
		}
		
		}
		
		
	}

}
