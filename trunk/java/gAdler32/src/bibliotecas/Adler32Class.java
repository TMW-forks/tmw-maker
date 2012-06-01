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
 * @author → Lunovox <rui.gravata@gmail.com>
 * @version → 2012-06-01
 * @description → Biblioteca geradora de checksum adller32
 * @licence → GNU GPL v3: http://www.gnu.org/licenses/gpl.html
 * @msn → rui.gravata@hotmail.com
 * @gTalk → rui.gravata@gmail.com
 * @skype → lunovox
 * @PhoneIP: sip:lunovox@ekiga.net
 */
package bibliotecas;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.Adler32;

public class Adler32Class {

	public static String getAdler32CheckSumHexadecimal(String $Endereco) {
		return Long.toHexString( // ← Transforma Long em Hexadecimal
				  getAdler32CheckSumLong($Endereco));
	}
	public static long getAdler32CheckSumLong(String $Endereco) {
		Adler32 adler32 = new Adler32();
		adler32.reset();
		try {
			FileInputStream $Capsula = new FileInputStream($Endereco);
			while ($Capsula.available() > 0) {
				byte[] buffer = new byte[262144];	// buffer de 256 Kb
				int $Parte = $Capsula.read(buffer);
				if ($Parte > 0) {
					adler32.update(buffer, 0, $Parte);
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(Adler32Class.class.getName()).log(Level.SEVERE, null, ex);
		}
		return adler32.getValue(); // ← Faz do Checksum
	}

	public static void main(String[] args) {
		//System.out.println(" → " + getAdler32CheckSumHexadecimal("/home/lunovox/Desenvolvimento/TMW/updates/musicas_2010-11-13.zip"));
		//System.out.println(" → " + Long.toHexString(getAdler32CheckSumLong("/home/lunovox/Desenvolvimento/TMW/updates/musicas_2010-11-13.zip")));
	}
}
