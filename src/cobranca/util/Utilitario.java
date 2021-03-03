package cobranca.util;

import java.util.Random;

public class Utilitario {
	
	public static boolean isNumeric (String s) {
		try {
			Long.parseLong(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static String geraCodigo() {
		
		Random random = new Random();
		
		String codigo = String.valueOf(random.nextInt(30000));
		return codigo;
	}
}