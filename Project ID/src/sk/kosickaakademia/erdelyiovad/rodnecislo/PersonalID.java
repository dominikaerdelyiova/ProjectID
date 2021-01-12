package sk.kosickaakademia.erdelyiovad.rodnecislo;

import java.util.Calendar;

public class PersonalID {
    public boolean checkId(String id) {
        if (id.length()<9 || id.length()>11)
            return false;
        int cDigits =0;
        for (int i =0;i< id.length(); i++) {
            if (Character.isDigit(id.charAt(i)))
                cDigits++;
        }
        if (cDigits<9 || cDigits>10)
            return false;
        if (id.length() == 11 && (cDigits != 10 || id.charAt(6) != '/'))
            return false;
        if (id.length() == 10 && cDigits == 9 && id.charAt(6) != '/')
            return false;
        //kontrola pohlavia | muz - 1;0, zena - 5;6 //
        if (id.charAt(2) != '0' && id.charAt(2) != '1' && id.charAt(2) != '5' && id.charAt(2) != '6')
            return false;

        if (cDigits == 9)
            id = id + '0';
        if (id.charAt(6) == '/')
            id = id.replace("/", "");

        if ((Long.parseLong(id) % 11) != 0) {
            System.out.println("Chyba! Rodne cislo nie je delitelne 11");
            return false;

        }

            int day, month, year;
            day = Integer.parseInt(id.substring(4, 6));
            month = Integer.parseInt(id.substring(2, 4));
            if (id.charAt(2) == '5' || id.charAt(2) == '6')
                month -= 50;
            year = 2000 + year;
            int currYear = Calendar.getInstance().get(Calendar.YEAR);


