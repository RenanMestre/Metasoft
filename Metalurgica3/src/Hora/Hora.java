package Hora;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hora {

    // Método para validar e formatar a hora
    public static String converterHora(String hora) {
        try {
            // Define o formato esperado da hora
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            sdf.setLenient(false); // Impede horários inválidos como "25:00"
            
            // Tenta converter a hora informada
            Date date = sdf.parse(hora);
            
            // Retorna a hora no formato correto
            return sdf.format(date);
        } catch (ParseException e) {
            // Retorna null em caso de erro no formato
            return null;
        }
    }
}
