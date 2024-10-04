public class Animal {

    protected String nombre;
    protected int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void mostrarInfo(){
        System.out.println("Nombre: " +this.nombre + "; Edad: " +this.edad);
    }

    public void hacerSonido(){
        System.out.println("El animal hace sonidos");
    }
}
