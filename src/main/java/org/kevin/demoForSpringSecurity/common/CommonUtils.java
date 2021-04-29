package org.kevin.demoForSpringSecurity.common;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

/**
 * @author Kevin.Z
 * @version 2020-03-12
 */
public class CommonUtils {
    private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final static DateTimeFormatter dtf_ = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");

    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String replaceLineCharacter(String str){
        return str.replaceAll("[\\n]", "<br/>");
    }

    public static String replaceBlank(String str){
        return str.replaceAll("[\\s]", "");
    }

    public static String securityPwdEncoder(String pwd){
        PasswordEncoder pwdEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return pwdEncoder.encode(pwd);
    }

    public static LocalDateTime parseStr2LocalDateTime(String ldtStr, boolean starts){
        if(starts){
            ldtStr += " 00:00:00";
        } else {
            ldtStr += " 23:59:59";
        }

        return LocalDateTime.parse(ldtStr, dtf);
    }

    public static LocalDateTime parse2LocalDateTimeWithT(String timeStr){
        if(timeStr != null){
            return LocalDateTime.parse(timeStr, dtf_);
        }
        return null;
    }

    public static String LocalDateTime2String(LocalDateTime ldt){
        return dtf_.format(ldt);
    }

    public static String convertSpecialCharacter(String str){
        str = str.replaceAll(":","-");
        str = str.replaceAll("\\.","-");
        str = str.replaceAll("\\s", "-");

        return str;
    }

    public static Date LocalDateTime2Date(LocalDateTime ldt){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = ldt.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }

}
