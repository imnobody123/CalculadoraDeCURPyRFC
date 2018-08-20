package com.example.joshua.calculadoradecurpyrfc;

public class CalcularCurp_y_Rfc {

    public String letrasApellidoP(String apellidop){
        String letra1 = (String.valueOf(apellidop.charAt(0))).toUpperCase();
        String letra2;

        if (letra1.equalsIgnoreCase("Ñ")) {
            letra1 = "x";
        }

        for (int x = 1; x < apellidop.length(); x++) {
            letra2 = String.valueOf(apellidop.charAt(x));
            if (letra2.equalsIgnoreCase("a") || letra2.equalsIgnoreCase("e") ||
                    letra2.equalsIgnoreCase("i") || letra2.equalsIgnoreCase("o") || letra2.equalsIgnoreCase("u")) {
                apellidop = (letra1 + letra2).toUpperCase();
                return apellidop;
            }
        }

        letra2 = "X";
        apellidop = letra1 + letra2;
        return apellidop;
    }

    public String letrasApellidoM(String apellidom){
        String letra1 = String.valueOf(apellidom.charAt(0));

        if(letra1.equalsIgnoreCase("Ñ")){
            letra1 = "X";
        }

        StringBuilder nuevoApellidoM = new StringBuilder();
        nuevoApellidoM.append(letra1);
        apellidom = nuevoApellidoM.toString().toUpperCase();

        return apellidom;
    }

    public String letrasNombre(String Nombre){
        String letraNombre = "";
        String letra1 = "";
        StringBuilder nuevoNombre = new StringBuilder();

        if (Nombre.contains(" ")){
            String [] partesNombre = Nombre.split(" ");
            String Nombre1 = partesNombre[0];
            String Nombre2 = partesNombre[1];

            if (Nombre1.equalsIgnoreCase("Maria") || Nombre1.equalsIgnoreCase("Jose")){
                letra1 = String.valueOf(Nombre2.charAt(0));
                if(letra1.equalsIgnoreCase("Ñ")){
                    letra1 = "Ñ";
                }

                nuevoNombre.append(letra1);
                letraNombre = nuevoNombre.toString().toUpperCase();

                return letraNombre;
            }else{
                letra1 = String.valueOf(Nombre1.charAt(0));

                if (letra1.equalsIgnoreCase("Ñ")){
                    letra1 = "Ñ";
                }
                nuevoNombre.append(letra1);
                letraNombre = nuevoNombre.toString().toUpperCase();

                return letraNombre;
            }
        }else{
            letra1 = String.valueOf(Nombre.charAt(0));

            if (letra1.equalsIgnoreCase("Ñ")){
                letra1 = "Ñ";
            }
            nuevoNombre.append(letra1);
            letraNombre = nuevoNombre.toString().toUpperCase();

            return letraNombre;
        }
    }

    public String digitosFechaN(String digitos){
        String[] partes = digitos.split("/");
        String parte1 = partes[0];
        int n1 = Integer.parseInt(parte1);
        if(n1 < 10){
            parte1 = "0" + String.valueOf(n1);
        }

        String parte2 = partes[1];
        int n2 = Integer.parseInt(parte2);
        if(n2 < 10){
            parte2 = "0" + String.valueOf(n2);
        }

        String parte3 = partes[2];
        char digito1 = parte3.charAt(2);
        char digito2 = parte3.charAt(3);
        StringBuilder nuevaParte3 = new StringBuilder();
        nuevaParte3.append(digito1);
        nuevaParte3.append(digito2);
        parte3 = nuevaParte3.toString();
        String nuevoValorDigitos = parte3 + parte2 + parte1;

        return nuevoValorDigitos;
    }

    public String letraSexo(String decision){
        String letraSexo = "";
        if(decision.equalsIgnoreCase("true")){
            letraSexo = "H";
        }else{
            letraSexo = "M";
        }
        return letraSexo;
    }

    public String letrasEntidad(String LetraEstado){
        if(LetraEstado.equalsIgnoreCase("Aguascalientes")){LetraEstado = "AS";}
        if(LetraEstado.equalsIgnoreCase("Baja California")){LetraEstado = "BC";}
        if(LetraEstado.equalsIgnoreCase("Baja California Sur")){LetraEstado = "BS";}
        if(LetraEstado.equalsIgnoreCase("Campeche")){LetraEstado = "CC";}
        if(LetraEstado.equalsIgnoreCase("Coahuila")){LetraEstado = "CL";}
        if(LetraEstado.equalsIgnoreCase("Colima")){LetraEstado = "CM";}
        if(LetraEstado.equalsIgnoreCase("Chiapas")){LetraEstado = "CS";}
        if(LetraEstado.equalsIgnoreCase("Ciudad de México")){LetraEstado = "DF";}
        if(LetraEstado.equalsIgnoreCase("Chihuahua")){LetraEstado = "CH";}
        if(LetraEstado.equalsIgnoreCase("Durango")){LetraEstado = "DG";}
        if(LetraEstado.equalsIgnoreCase("Guanajuato")){LetraEstado = "GT";}
        if(LetraEstado.equalsIgnoreCase("Guerrero")){LetraEstado = "GR";}
        if(LetraEstado.equalsIgnoreCase("Hidalgo")){LetraEstado = "HG";}
        if(LetraEstado.equalsIgnoreCase("Jalisco")){LetraEstado = "JC";}
        if(LetraEstado.equalsIgnoreCase("Estado de México")){LetraEstado = "MC";}
        if(LetraEstado.equalsIgnoreCase("Michoacán")){LetraEstado = "MN";}
        if(LetraEstado.equalsIgnoreCase("Morelos")){LetraEstado = "MS";}
        if(LetraEstado.equalsIgnoreCase("Nayarit")){LetraEstado = "NT";}
        if(LetraEstado.equalsIgnoreCase("Nuevo León")){LetraEstado = "NL";}
        if(LetraEstado.equalsIgnoreCase("Oaxaca")){LetraEstado = "OC";}
        if(LetraEstado.equalsIgnoreCase("Puebla")){LetraEstado = "PL";}
        if(LetraEstado.equalsIgnoreCase("Querétaro")){LetraEstado = "QT";}
        if(LetraEstado.equalsIgnoreCase("Quintana Roo")){LetraEstado = "QR";}
        if(LetraEstado.equalsIgnoreCase("San Luis Potosí")){LetraEstado = "SP";}
        if(LetraEstado.equalsIgnoreCase("Sinaloa")){LetraEstado = "SL";}
        if(LetraEstado.equalsIgnoreCase("Sonora")){LetraEstado = "SR";}
        if(LetraEstado.equalsIgnoreCase("Tabasco")){LetraEstado = "TC";}
        if(LetraEstado.equalsIgnoreCase("Tamaulipas")){LetraEstado = "TS";}
        if(LetraEstado.equalsIgnoreCase("Tlaxcala")){LetraEstado = "TL";}
        if(LetraEstado.equalsIgnoreCase("Veracruz")){LetraEstado = "VZ";}
        if(LetraEstado.equalsIgnoreCase("Yucatán")){LetraEstado = "YN";}
        if(LetraEstado.equalsIgnoreCase("Zacatecas")){LetraEstado = "ZS";}
        return LetraEstado;
    }

    public String consonantesApeP(String consoApeP){
        int i = 0;
        for(i = 0; i <= consoApeP.length(); i++){
            char conso = consoApeP.charAt(i);
            if(conso=='a'||conso=='e' ||conso=='i'||conso=='o'||conso=='u'||
                    conso=='A'||conso=='E' ||conso=='I'||conso=='O'||conso=='U'|| i == 0){

            }else{
                consoApeP = String.valueOf(conso).toUpperCase();
                if(consoApeP.equalsIgnoreCase("Ñ")){
                    consoApeP = "x";
                    return consoApeP;
                }
                return consoApeP;
            }
        }
        consoApeP = "X";
        return consoApeP;
    }

    public String consonantesApeM(String consoApeM){
        int i = 0;
        for(i = 0; i <= consoApeM.length(); i++){
            char conso = consoApeM.charAt(i);
            if(conso=='a'||conso=='e' ||conso=='i'||conso=='o'||conso=='u'||
                    conso=='A'||conso=='E' ||conso=='I'||conso=='O'||conso=='U'||i == 0){

            }else{
                consoApeM = String.valueOf(conso).toUpperCase();
                if(consoApeM.equalsIgnoreCase("Ñ")){
                    consoApeM = "x";
                    return consoApeM;
                }
                return consoApeM;
            }
        }
        consoApeM = "X";
        return consoApeM;
    }

    public String consonantesNombre(String consoNombre) {
        String NombreCompleto = consoNombre;
        if (NombreCompleto.contains(" ")) {
            String partesNombre[] = NombreCompleto.split(" ");
            String Nombre1 = partesNombre[0];
            String Nombre2 = partesNombre[1];
            if (Nombre1.equalsIgnoreCase("Maria") || Nombre1.equalsIgnoreCase("Jose")) {
                for (int x = 1; x < Nombre2.length(); x++) {
                    consoNombre = String.valueOf(Nombre2.charAt(x));
                    if (consoNombre.equalsIgnoreCase("a") || consoNombre.equalsIgnoreCase("e") || consoNombre.equalsIgnoreCase("i") || consoNombre.equalsIgnoreCase("o") ||
                            consoNombre.equalsIgnoreCase("u")) {

                    } else {
                        if (consoNombre.equalsIgnoreCase("Ñ")){
                            consoNombre = "x";
                        }
                        consoNombre = consoNombre.toUpperCase();
                        return consoNombre;
                    }
                }
            } else {
                for (int x = 1; x < Nombre1.length(); x++) {
                    consoNombre = String.valueOf(Nombre1.charAt(x));
                    if (consoNombre.equalsIgnoreCase("a") || consoNombre.equalsIgnoreCase("e") || consoNombre.equalsIgnoreCase("i") || consoNombre.equalsIgnoreCase("o") ||
                            consoNombre.equalsIgnoreCase("u")) {

                    } else {
                        if (consoNombre.equalsIgnoreCase("Ñ")){
                            consoNombre = "x";
                        }
                        consoNombre = consoNombre.toUpperCase();
                        return consoNombre;
                    }
                }
            }
        } else {
            for (int x = 1; x < NombreCompleto.length(); x++) {
                consoNombre = String.valueOf(NombreCompleto.charAt(x));
                if (consoNombre.equalsIgnoreCase("a") || consoNombre.equalsIgnoreCase("e") || consoNombre.equalsIgnoreCase("i") || consoNombre.equalsIgnoreCase("o") ||
                        consoNombre.equalsIgnoreCase("u")) {

                } else {
                    if (consoNombre.equalsIgnoreCase("Ñ")){
                        consoNombre = "x";
                    }
                    consoNombre = consoNombre.toUpperCase();
                    return consoNombre;
                }
            }
        }
        consoNombre = "X";
        return consoNombre;
    }

    public String HomoClave(String digitoNacimiento, String CURP){
        int multiplica = 0;
        int digitoVerificador = 0;
        String homoclave = "";
        String[] partes = digitoNacimiento.split("/");
        String letraAno = partes[2];
        int digitoNacConvertido = Integer.parseInt(letraAno);

        if(digitoNacConvertido >= 2000){
            letraAno = "A";
        }else {
            letraAno = "0";
        }

        String valores  = "0123456789ABCDEFGHIJKLMNxOPQRSTUVWXYZ";
        CURP = CURP + letraAno + "--";
        String CURP3 = "";

        for(int i = 18; i >= 0; i--){
            CURP3 = CURP3 + CURP.charAt(i);
        }

        for(int contador = 18; contador >= 2; contador--){
            for(int contador2 = 0; contador2 <= 36; contador2++){
                if(String.valueOf(valores.charAt(contador2)).equals(String.valueOf(CURP3.charAt(contador)))){
                    multiplica = contador * contador2;
                    digitoVerificador = digitoVerificador + multiplica;
                }
            }
        }
        digitoVerificador %= 10;
        if(digitoVerificador <= 0){
            digitoVerificador = 10;
        }
        digitoVerificador = 10 - digitoVerificador;
        homoclave = letraAno + String.valueOf(digitoVerificador);
        return homoclave;
    }

    public String ClaveHomonimiaRFC(String Nombre){
        char[] LetrasNombre = Nombre.toCharArray();
        String ValoresLetras = "";
        String ValorPalabra = "";
        int contador = Nombre.length();
        for(int i = 0; i < contador; i++){
            switch (LetrasNombre[i]){
                case ' ': ValoresLetras = "00"; break;
                case '0': ValoresLetras = "00"; break;
                case '1': ValoresLetras = "01"; break;
                case '2': ValoresLetras = "02"; break;
                case '3': ValoresLetras = "03"; break;
                case '4': ValoresLetras = "04"; break;
                case '5': ValoresLetras = "05"; break;
                case '6': ValoresLetras = "06"; break;
                case '7': ValoresLetras = "07"; break;
                case '8': ValoresLetras = "08"; break;
                case '9': ValoresLetras = "09"; break;
                case '&': ValoresLetras = "10"; break;
                case 'A': ValoresLetras = "11"; break;
                case 'B': ValoresLetras = "12"; break;
                case 'C': ValoresLetras = "13"; break;
                case 'D': ValoresLetras = "14"; break;
                case 'E': ValoresLetras = "15"; break;
                case 'F': ValoresLetras = "16"; break;
                case 'G': ValoresLetras = "17"; break;
                case 'H': ValoresLetras = "18"; break;
                case 'I': ValoresLetras = "19"; break;
                case 'J': ValoresLetras = "21"; break;
                case 'K': ValoresLetras = "22"; break;
                case 'L': ValoresLetras = "23"; break;
                case 'M': ValoresLetras = "24"; break;
                case 'N': ValoresLetras = "25"; break;
                case 'O': ValoresLetras = "26"; break;
                case 'P': ValoresLetras = "27"; break;
                case 'Q': ValoresLetras = "28"; break;
                case 'R': ValoresLetras = "29"; break;
                case 'S': ValoresLetras = "32"; break;
                case 'T': ValoresLetras = "33"; break;
                case 'U': ValoresLetras = "34"; break;
                case 'V': ValoresLetras = "35"; break;
                case 'W': ValoresLetras = "36"; break;
                case 'X': ValoresLetras = "37"; break;
                case 'Y': ValoresLetras = "38"; break;
                case 'Z': ValoresLetras = "39"; break;
                case 'Ñ': ValoresLetras = "40"; break;
            }
            ValorPalabra = ValorPalabra + ValoresLetras;
        }

        ValorPalabra = "0" + ValorPalabra;
        int num1 = 0, num2 = 0, multiplica = 1, sumaNumeros = 0;
        char[] numeros = ValorPalabra.toCharArray();

        for (int cont = 0; cont < numeros.length-1; cont++){
            num1 = Integer.parseInt(""+numeros[cont] + ""+numeros[cont+1]);
            num2 = Integer.parseInt(""+numeros[cont+1]);
            multiplica = num1 * num2;
            sumaNumeros = sumaNumeros + multiplica;
        }

        String resultado = String.valueOf(sumaNumeros);
        String tresDigitos1 = "";
        char[] digitos = resultado.toCharArray();
        for(int cont = digitos.length-1; cont >= digitos.length-3; cont--){
            tresDigitos1 = tresDigitos1 + digitos[cont];
        }

        char[] digitos2 = tresDigitos1.toCharArray();
        String tresDigitos2 = "";
        for (int cont = digitos2.length-1; cont >= 0; cont--) {
            tresDigitos2 = tresDigitos2 + digitos2[cont];
        }

        int digits = Integer.parseInt(tresDigitos2);
        int cociente = digits / 34;
        int residuo = digits % 34;
        String Homonimia = "";

        switch (cociente){
            case 0: Homonimia = "1"; break;
            case 1: Homonimia = "2"; break;
            case 2: Homonimia = "3"; break;
            case 3: Homonimia = "4"; break;
            case 4: Homonimia = "5"; break;
            case 5: Homonimia = "6"; break;
            case 6: Homonimia = "7"; break;
            case 7: Homonimia = "8"; break;
            case 8: Homonimia = "9"; break;
            case 9: Homonimia = "A"; break;
            case 10: Homonimia = "B"; break;
            case 11: Homonimia = "C"; break;
            case 12: Homonimia = "D"; break;
            case 13: Homonimia = "E"; break;
            case 14: Homonimia = "F"; break;
            case 15: Homonimia = "G"; break;
            case 16: Homonimia = "H"; break;
            case 17: Homonimia = "I"; break;
            case 18: Homonimia = "J"; break;
            case 19: Homonimia = "K"; break;
            case 20: Homonimia = "L"; break;
            case 21: Homonimia = "M"; break;
            case 22: Homonimia = "N"; break;
            case 23: Homonimia = "P"; break;
            case 24: Homonimia = "Q"; break;
            case 25: Homonimia = "R"; break;
            case 26: Homonimia = "S"; break;
            case 27: Homonimia = "T"; break;
            case 28: Homonimia = "U"; break;
            case 29: Homonimia = "V"; break;
            case 30: Homonimia = "W"; break;
            case 31: Homonimia = "X"; break;
            case 32: Homonimia = "Y"; break;
            case 33: Homonimia = "Z"; break;
        }

        switch (residuo){
            case 0: Homonimia = Homonimia + "1"; break;
            case 1: Homonimia = Homonimia + "2"; break;
            case 2: Homonimia = Homonimia + "3"; break;
            case 3: Homonimia = Homonimia + "4"; break;
            case 4: Homonimia = Homonimia + "5"; break;
            case 5: Homonimia = Homonimia + "6"; break;
            case 6: Homonimia = Homonimia + "7"; break;
            case 7: Homonimia = Homonimia + "8"; break;
            case 8: Homonimia = Homonimia + "9"; break;
            case 9: Homonimia = Homonimia + "A"; break;
            case 10: Homonimia = Homonimia + "B"; break;
            case 11: Homonimia = Homonimia + "C"; break;
            case 12: Homonimia = Homonimia + "D"; break;
            case 13: Homonimia = Homonimia + "E"; break;
            case 14: Homonimia = Homonimia + "F"; break;
            case 15: Homonimia = Homonimia + "G"; break;
            case 16: Homonimia = Homonimia + "H"; break;
            case 17: Homonimia = Homonimia + "I"; break;
            case 18: Homonimia = Homonimia + "J"; break;
            case 19: Homonimia = Homonimia + "K"; break;
            case 20: Homonimia = Homonimia + "L"; break;
            case 21: Homonimia = Homonimia + "M"; break;
            case 22: Homonimia = Homonimia + "N"; break;
            case 23: Homonimia = Homonimia + "P"; break;
            case 24: Homonimia = Homonimia + "Q"; break;
            case 25: Homonimia = Homonimia + "R"; break;
            case 26: Homonimia = Homonimia + "S"; break;
            case 27: Homonimia = Homonimia + "T"; break;
            case 28: Homonimia = Homonimia + "U"; break;
            case 29: Homonimia = Homonimia + "V"; break;
            case 30: Homonimia = Homonimia + "W"; break;
            case 31: Homonimia = Homonimia + "X"; break;
            case 32: Homonimia = Homonimia + "Y"; break;
            case 33: Homonimia = Homonimia + "Z"; break;
        }
        return Homonimia.toUpperCase();
    }

    public String digitoVerificador(String RfcSinHomonimia){
        char[] digitosClaveRfc = RfcSinHomonimia.toCharArray();
        String digtirfc = "";
        String datos = "";
        for(int cont = 0; cont < digitosClaveRfc.length; cont++){
            switch (digitosClaveRfc[cont]){
                case '0': digtirfc = "00"; break;
                case '1': digtirfc = "01"; break;
                case '2': digtirfc = "02"; break;
                case '3': digtirfc = "03"; break;
                case '4': digtirfc = "04"; break;
                case '5': digtirfc = "05"; break;
                case '6': digtirfc = "06"; break;
                case '7': digtirfc = "07"; break;
                case '8': digtirfc = "08"; break;
                case '9': digtirfc = "09"; break;
                case 'A': digtirfc = "10"; break;
                case 'B': digtirfc = "11"; break;
                case 'C': digtirfc = "12"; break;
                case 'D': digtirfc = "13"; break;
                case 'E': digtirfc = "14"; break;
                case 'F': digtirfc = "15"; break;
                case 'G': digtirfc = "16"; break;
                case 'H': digtirfc = "17"; break;
                case 'I': digtirfc = "18"; break;
                case 'J': digtirfc = "19"; break;
                case 'K': digtirfc = "20"; break;
                case 'L': digtirfc = "21"; break;
                case 'M': digtirfc = "22"; break;
                case 'N': digtirfc = "23"; break;
                case '&': digtirfc = "24"; break;
                case 'O': digtirfc = "25"; break;
                case 'P': digtirfc = "26"; break;
                case 'Q': digtirfc = "27"; break;
                case 'R': digtirfc = "28"; break;
                case 'S': digtirfc = "29"; break;
                case 'T': digtirfc = "30"; break;
                case 'U': digtirfc = "31"; break;
                case 'V': digtirfc = "32"; break;
                case 'W': digtirfc = "33"; break;
                case 'X': digtirfc = "34"; break;
                case 'Y': digtirfc = "35"; break;
                case 'Z': digtirfc = "36"; break;
                case ' ': digtirfc = "37"; break;
                case 'Ñ': digtirfc = "38"; break;
            }
            datos = datos + digtirfc;
        }

        char[] valDigitRfc = datos.toCharArray();
        //Valor asociado deacuerdo a los valores del switch
        int vi = 0;
        //Posición que ocupa el carácter tomado de derecha a izquierda, es
        //dercir P toma los valores de 1 a 12
        int pi = 13;
        int resultadoMulti = 0;
        int resultado = 0;
        String claveVerif = "";
        for(int cont = 0; cont < valDigitRfc.length-1;cont = cont + 2){
            vi = Integer.parseInt("" + valDigitRfc[cont] + "" + valDigitRfc[cont+1]);
            resultadoMulti = vi * pi;
            pi--;
            resultado = resultado + resultadoMulti;
        }

        resultado %= 11;

        if(resultado == 0){
            claveVerif = String.valueOf(0);
        }else if(resultado > 0){
            resultado = 11 - resultado;
            claveVerif = String.valueOf(resultado);
        }else if(resultado == 10){
            claveVerif = "A";
        }

        return claveVerif;
    }
}
