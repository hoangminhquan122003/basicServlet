/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.security.MessageDigest;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author Admin
 */
public class MaHoa {
    public static String toSHA1( String str){
        String salt="kjadfacna;sfakdqbkafdakndaadfalsnfassd";
        String result=null;
        str+=salt;
        try {
            byte[] databytes=str.getBytes("UTF-8");
            MessageDigest md=MessageDigest.getInstance("SHA-1");
            result=Base64.encodeBase64String(md.digest(databytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
