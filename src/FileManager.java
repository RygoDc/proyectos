import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public String ruta;
    public ArrayList<Figura> figuras;

    public FileManager(String ruta, ArrayList<Figura> figuras) {
        this.ruta = ruta;
        this.figuras = figuras;
    }

    public boolean Exists(){
        File f = new File(ruta);
        return f.exists();
    }

    public void importFromFile(){
        try{
            FileReader fileReader = new FileReader(ruta);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] datos = linea.split(" ");
                if(datos.length <4 || !datos[datos.length-1].startsWith("#")){
                    System.out.println("Figura no valida");
                    continue;
                }
                String tipo = datos[0];
                int x = Integer.parseInt(datos[1]);
                int y = Integer.parseInt(datos[3]);
                String color = datos[datos.length-1];

                switch (tipo.toLowerCase()){
                    case "rectangulo":
                        int ancho = Integer.parseInt(datos[2]);
                        int alto = Integer.parseInt(datos[4]);

                        figuras.add(new Rectangulo(x,y,color,ancho,alto));
                        break;
                    case "circulo":
                        int radio = Integer.parseInt(datos[2]);

                        figuras.add(new Circulo(x,y,color,radio));
                        break;
                    case "cuadrado":
                        int lado = Integer.parseInt(datos[2]);

                        figuras.add(new Cuadrado(x,y,color,lado));
                        break;
                    default:
                        System.out.println("Figura no encontrada");
                        break;
                }
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
