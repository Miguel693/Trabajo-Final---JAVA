

public class Recursion {
  public static void mostrarPromedio(Alumno[][] mat, int i){
    if( i < 7){
      System.out.println(calcularPromedio(mat, i, 0));
      mostrarPromedio(mat, i+1);  
    }
  }
  public static double calcularPromedio( Alumno[][] mat, int i, int j){
    double prom = 0;
    if( j < 30){
      if(mat[i][j] != null)
        prom += calcularPromedio(mat, i, j+1) + mat[i][j].getPromedio();
      else
        prom += calcularPromedio(mat, i, j+1);
    }
    if( j == 0){
      int cont = contAlumnos(mat, i, 0);
      prom /= cont;
    }
    return prom;
  }
  public static int contAlumnos(Alumno[][] mat, int i, int j){
    int cont = 0;
    if( j < 30){
      if( mat[i][j] != null)
        cont += 1 + contAlumnos(mat, i, j+1);
    }
    return cont;
  }

  public static int contVacantes(Alumno[][] mat, int i, int j){
    int cont = 0;
    if( i < 7 ){
      if( j < 30){
        if(mat[i][j] == null)
          cont = 1 ;
        cont += contVacantes(mat, i, j+1);
      }
      cont += contVacantes(mat, i+1, 0);
    }
    return cont;
  }
}
