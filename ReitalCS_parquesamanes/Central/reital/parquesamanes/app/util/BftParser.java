package reital.parquesamanes.app.util;


public class BftParser
{

    public BftParser()
    {
    }

    public static String parseCodigoToDecimal(String unCodigo)
    {
        int codigoTarjetaInt = Integer.decode("#" + unCodigo).intValue();
        int codigoImpresoTarjeta = 65535 - codigoTarjetaInt;
        String codigoImpresoStr = String.valueOf(codigoImpresoTarjeta);
        if(codigoImpresoStr.trim().length() == 1)
            codigoImpresoStr = "0000" + codigoImpresoStr;
        else
        if(codigoImpresoStr.trim().length() == 2)
            codigoImpresoStr = "000" + codigoImpresoStr;
        else
        if(codigoImpresoStr.trim().length() == 3)
            codigoImpresoStr = "00" + codigoImpresoStr;
        else
        if(codigoImpresoStr.trim().length() == 4)
            codigoImpresoStr = "0" + codigoImpresoStr;
        return codigoImpresoStr;
    }
}