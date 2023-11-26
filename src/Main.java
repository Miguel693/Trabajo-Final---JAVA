import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Alumno[][] mat = new Alumno[7][30];
    String alumnotxt = Reader.readFile("ListaAlumnos.txt");
    Methods.cargarMatriz(mat, alumnotxt);
    Methods.display(mat, "promedio");
    Quicksort.matriz(mat, "apellido");
    Methods.display(mat, "promedio");
  }

  public static void menu(){
    Alumno[][] alumno   = new Alumno[7][30];
    Alumno[] graduado = new Alumno[500];
    String alumnoTxt = Reader.readFile("ListaAlumnos.txt");
    String repitenteTxt = Reader.readFile("desaprobados.txt");
    String ingresanteTxt = Reader.readFile("ingresantes.txt");

    Methods.cargarMatriz(alumno, alumnoTxt);
    Methods.mostrarGrado(alumno, 1,"legajo");

    Scanner sc = new Scanner(System.in);
    boolean fin = false;
    char op;
    String param;
    int legajo;
    System.out.println("1 . Pasar de grado");
    System.out.println("2 . Mostrar alumnos");
    System.out.println("3 . Mostrar egresados");
    System.out.println("4 . Motrar promedios");
    System.out.println("5 . Encontrar alumno");
    System.out.println("6 . Añadir ingresantes");
    System.out.println("7 . Registrar alumno de forma manual");
    System.out.println("8 . Finalizar");
    while(!fin){

      op = sc.next().charAt(0);
      switch (op) {
        case '1':
          Methods.pasarDeGrado(alumno, graduado, repitenteTxt, ingresanteTxt);
          System.out.println("Mostrar datos?");
          System.out.println("1 . Solo matriz de alumnos");
          System.out.println("2 . Solo arreglo de egresados");
          System.out.println("3 . Ambos ");
          param = sc.next();
          if(param.equals("1")){
            param = datosMostrar();
            Methods.display(alumno,param);
          }else if(param.equals("2")){
            param = datosMostrar();
            Methods.display(graduado,param);
          }else if(param.equals("3")){
            param = datosMostrar();
            Methods.display(alumno,param);
            Methods.display(graduado,param);
          }else{
            System.out.println("Opcion invalida");
          }
          break;
        case '2':
          param = datosMostrar();
          Methods.display(alumno, param);

          break;
        case '3':
          
          param = sc.next();
          Methods.display(graduado, param);
          break;
        case '4':
          Recursion.mostrarPromedio(alumno, 0);
          break;
        case '5':
          System.out.println("Ingrese un legajo");
          legajo = sc.nextInt();
          System.out.println("Encontrado: "+
            Methods.encontrarAlumno(alumno, legajo)
          );
          break;
        case '6':
          // Methods.ingresar(alumno, ingresanteTxt);
          break;
        case '7':
          break;
        case '8':
          fin = true;
          break;
      
        default:
          System.out.println("Caracter ingresado invalido");
          break;
      }
    }

    
    sc.close();
  }

  public static String datosMostrar(){
    Scanner sc = new Scanner(System.in);
    String cad;
    System.out.println("Elija que desea mostrar: ");
    System.out.println("1 . Legajo");
    System.out.println("2 . Apellido");
    System.out.println("3 . Nombre");
    System.out.println("5 . Promedio");
    System.out.println("6 . Todo");
    cad = sc.next();
    sc.close();
    return cad;
  }
}
