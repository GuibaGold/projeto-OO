package util;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import proprietario.Veiculo;

public class util {
	
	public static double getDoubleValue(String string) {
			if ( "".equals(string) ) {
				return 0;
	    }
	    return Double.parseDouble(string);
			
	}
	
	public static int getIntegerValue(String string) {
		 if ( "".equals(string) ) {
		        return 0;
		    }
		    return Integer.parseInt(string);
	}
}
