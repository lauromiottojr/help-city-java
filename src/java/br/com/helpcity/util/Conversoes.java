package br.com.helpcity.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Conversoes {

    public static Date converterData(String data) throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        if (data == null || data.trim().equals("")) {
            return null;
        } else {
            Date date = fmt.parse(data);
            return date;
        }
    }

    public static String DataParaString(String data) throws ParseException {
        SimpleDateFormat entrada = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat saida = new SimpleDateFormat("dd/MM/yyyy");
        return saida.format(entrada.parse(data.toString()));
    }  
     
     public static String converterSHA(String senha) throws NoSuchAlgorithmException {
        if (senha != null) {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(senha.getBytes());

            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } else {
            return null;
        }
    }
}
