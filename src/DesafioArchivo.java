import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class DesafioArchivo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese nombre directorio:");
        String nomdirectorio = sc.nextLine();

        System.out.println("Ingrese nombre archivo:");
        String nomarchivo = sc.nextLine();

        File directorio = new File("src/"+ nomdirectorio);
        File archivo = new File(directorio + "/" + nomarchivo + ".txt");

        crearArchivo(directorio, archivo);

    }
    public static void crearArchivo(File directorio, File archivo)
       {
           ArrayList<String> lista = new ArrayList<String>();
           lista.add("Perro");
           lista.add("Gato");
           lista.add("Juan");
           lista.add("Daniel");
           lista.add("Juan");
           lista.add("Gato");
           lista.add("Perro");
           lista.add("Camila");
           lista.add("Daniel");
           lista.add("Camila");

        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.printf("Directorio %s creado\n", directorio);
                try {
                    archivo.createNewFile();
                    System.out.printf("archivo %s creado\n", archivo);

                    FileWriter fileW = new FileWriter(archivo);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileW);

                    for (Iterator<String> it = lista.iterator();it.hasNext();){

                        String element = (String)it.next();
                        bufferedWriter.write(element);
                        bufferedWriter.newLine();
                        it.remove();
                    }
                    bufferedWriter.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Error al crear directorio");
            }
        } else {
            System.out.println("El directorio ya existe");
        }
    }
}
