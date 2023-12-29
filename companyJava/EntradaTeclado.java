package empresa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Esta classe foi desenhada para facilitar a entrada de dados
 * pelo teclado. Basicamente ela implementa fun��es para
 * ler strings, inteiros e doubles. 
 * Ela n�o faz verifica��es se o que foi digitado realmente
 * � o esperado.
 * @author delamaro
 *
 */
public class EntradaTeclado {
	/**
	 * Esse atributo � usado para crar-se um Reader a partir da entrada padr�o.	
	 */
	static private InputStreamReader isr = new InputStreamReader(System.in);

	/**
	 * Usado para criar um BufferedReader a partir da entrada padr�o;
	 */
	static private BufferedReader br = new BufferedReader(isr);
		
	/**
	 * Le um string digitado pelo teclado, at� que seja pressionado
	 * um enter. Ou seja, le a linha toda.
	 * @return o string que foi digitado pelo usu�rio.
	 * @throws IOException Essa exce��o � lan�ada quando o m�todo n�o consegue ler o
	 * string a partir do teclado. 
	 */
	public static String leString() throws IOException {
		String x;
		x = br.readLine();
		return x;

	}

	/**
	 * Le um string do teclado (uma linha toda) e tenta transform�-lo num inteiro. 
	 * Por�m n�o faz qualquer verifica��o sobre a validade do dado digitado.
	 * @return  o valor inteiro digitado pelo usu�rio. 
	 * @throws IOException Lan�ada ao chamar leString
	 * @throws NumberFormatException Lan�ada ao tentar converter o String lido em n�mero inteiro
	 */
	public static int leInt() throws IOException, NumberFormatException  {
		String x = leString();
		return Integer.parseInt(x);
	}

	/**
	 * Le um string do teclado (uma linha toda) e tenta transform�-lo num double. 
	 * Por�m n�o faz qualquer verifica��o sobre a validade do dado digitado.
	 * @return  o valor double digitado pelo usu�rio. 
	 * @throws IOException Lan�ada ao chamar leString
	 * @throws NumberFormatException Lan�ada ao tentar converter o String lido em n�mero double
	 */

	public static double leDouble() throws IOException, NumberFormatException {
		String x = leString();
		return Double.parseDouble(x);

	}
}