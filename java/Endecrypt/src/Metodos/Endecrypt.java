/**
 *###################################################################################
 *##///////////////////////////////////////////////////////////////////////////////##
 *##|        ___       ___       ___       ___       ___        ___       ___     |##
 *##|       /\__\     /\__\     /\__\     /\  \     /\__\      /\  \     /\__\    |##
 *##|      /:/  /    /:/ _/_   /:| _|_   /::\  \   /:/  /__   /::\  \   /:/  /__  |##
 *##|     /:/  /    /:/ /\__\ /::|/\  \ /:/\:\__\ /:/  /\  \ /:/\:\__\ _|:|_/\__\ |##
 *##|    /:/  /    /:/ /:/  //:::::/  //:/ /:/  / |:| /:/  //:/ /:/  //:__::_/__/ |##
 *##|    \:\  \    \:\/:/  / \/|::/  / \:\/:/  /  |:|/:/  / \:\/:/  / \/_|:|__\   |##
 *##|     \:\__\    \::/  /    |:/  /   \::/  /   |:::/  /   \::/  /     /:/  /   |##
 *##|      \/__/     \/__/     \/__/     \/__/    \__/__/     \/__/      \/__/    |##
 *##|                                                                             |##
 *##///////////////////////////////////////////////////////////////////////////////##
 *###################################################################################
 * @adaptation: Lunovox <rui.gravata@gmail.com>
 * @version → TMW-Maker(2012-05-25)
 * @description → Programa de tratamento de arquivos
 * @licence → GNU GPL v3: http://www.gnu.org/licenses/gpl.html
 * @skype → lunovox
 * @msn → rui.gravata@hotmail.com
 * @gTalk → rui.gravata@gmail.com
 * @source: http://www.guj.com.br/java/103638-encriptar--desencriptar-senhas
 */
package Metodos;

import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Endecrypt {
	public static String getEncriptado(String text) /*throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException/***/{
		try{
			return (new BASE64Encoder()).encodeBuffer(text.getBytes()).trim(); // Codifica os bytes usando Base64
		} catch (Exception ex) {
			Logger.getLogger(Endecrypt.class.getName()).log(Level.SEVERE, null, ex);
			return ""; //Caso falhe
		}
	}
	public static String getDecriptado(String text) /*throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, IOException/**/ {
		try{
			return new String((new BASE64Decoder()).decodeBuffer(text)).trim(); // Codifica os bytes usando Base64
		} catch (Exception ex) {
			Logger.getLogger(Endecrypt.class.getName()).log(Level.SEVERE, null, ex);
			return ""; //Caso falhe
		}
	}

	public static void main(String[] args) /*throws NoSuchAlgorithmException, UnsupportedEncodingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IOException/**/{
		if(args.length>=1 && args[0].toLowerCase().indexOf("--exemplo")>=0){
			Endecrypt endecrypt;
			//String Senha = "";
			String Senha = "Um teste de codificação e decodificação";
			//String Senha = "OpenWorld";
			//String Senha = "Lunovox: \nTeste de Quebra de linha. ";
			//String Senha = "Lunovox - Teste de Texto Gigante: rkljd lfgj dljkhjlgk jldfg hlkdfhçldf hlk dflghkldlkç dfghl dfjg lk dfhlfkd hldfjlkfg jldfjlkfglkdfjghldf jglkjfdghlkdgjldfj ghlkfd gkljflj hlfdj l lkf gldf jhfjkd lkhgjdfgl fdlkgj fl j";
			System.out.println("######### EXECUTANDO EXEMPLO #############################################################");
			endecrypt  = new Endecrypt();
			System.out.println("Senha1(Encriptado): '" + Endecrypt.getEncriptado(Senha)+"'");
			System.out.println("Senha1(Decriptado): '" + endecrypt.getDecriptado(endecrypt.getEncriptado(Senha))+"'");

			endecrypt  = new Endecrypt();
			System.out.println("");
			System.out.println("Senha1(Encriptado): '" + endecrypt.getEncriptado(Senha)+"'");
			System.out.println("Senha1(Decriptado): '" + endecrypt.getDecriptado(endecrypt.getEncriptado(Senha))+"'");
			System.out.println("##########################################################################################");
		}
	}
}
