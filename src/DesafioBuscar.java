import java.io.*;
import java.util.Scanner;

public class DesafioBuscar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese nombre directorio:");
        String nomdirectorio = sc.nextLine();

        System.out.println("Ingrese nombre archivo:");
        String nomarchivo = sc.nextLine();

        System.out.println("Ingrese texto a buscar:");
        String texto = sc.nextLine();

        File directorio = new File("src/"+ nomdirectorio);
        File archivo = new File(directorio + "/" + nomarchivo + ".txt");

        buscarTexto(archivo, texto);

    }
    public static void buscarTexto( File archivo, String texto) {
        try {
            if (archivo.exists()) {
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                String data = br.readLine();
                int contador =0;
                while (data != null) {
                    if (data.equals (texto) ){
                        contador ++;
                    }
                    data = br.readLine();
                }
                System.out.printf("cantidad de repeticiones del texto -> %d\n",contador);
                br.close();
            } else {
                System.out.println("El archivo ingresado no existe");
            }

        } catch (Exception e) {
            System.out.println("Excepcion leyendo archivo: " + e);
        }
    }
}
