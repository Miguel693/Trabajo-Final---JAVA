public class Alumno {
  private int legajo;
  private String nombre;
  private String apellido;
  private int grado;
  private double promedio;


  //Constructores
  public Alumno(int legajo, String nombre,  String apellido, int grado, double promedio){
    this.legajo   = legajo;
    this.nombre   = nombre;
    this.apellido = apellido;
    this.grado    = grado;
    this.promedio = promedio;
  }

  public Alumno(int legajo){
    this.legajo   = legajo;
    this.nombre   = "";
    this.apellido = "";
    this.grado    = 0;
    this.promedio = 0;
  }

  public Alumno(Alumno alumno){
    this.legajo = alumno.getLegajo();
    this.nombre = alumno.getNombre();
    this.apellido = alumno.getApellido();
    this.grado = alumno.getGrado();
    this.promedio = alumno.getPromedio();
  }
  // Getters
  public int getLegajo(){
    return this.legajo;
  }

  public String getNombre(){
    return this.nombre;
  }

  public String getApellido(){
    return this.apellido;
  }

  public int getGrado(){
    return this.grado;
  }

  public double getPromedio(){
    return this.promedio;
  }

  public String toString(){
    return this.legajo+" | "+this.apellido+" | "+this.nombre+" | "+this.grado+" | "+this.promedio+"\n";
  }

  public boolean equals(Alumno alumno){
    return (this.legajo == alumno.getLegajo());
  }
  // Setters
  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  public void setApellido(String apellido){
    this.apellido = apellido;
  }

  public void setGrado(int grado){
    this.grado = grado;
  }

  public void setPromedio(double promedio){
    this.promedio = promedio;
  }

  // Methods
  
  public void promover(){
    this.grado += 1;
  }
  public void repetir(){
    this.grado -= 1;
  }

}
