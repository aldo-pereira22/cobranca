package cobranca.util;

public class Utilitario {
	public static boolean isNumeric (String s) {
		try {
			Long.parseLong(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}