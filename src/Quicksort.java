
public class Quicksort {
  

    /**
   ** Quicksort para ordenar un arreglo. 
   */
  public static void array(Alumno[] arr, int i, int j){
    if( i < j){
      int index = partition(arr, i , j);
      array(arr, i, index-1);
      array(arr, index+1, j);
    }
  }

  public static int partition(Alumno[] arr, int low, int high){
    int pivot = arr[high].getLegajo();

    int i = ( low-1 );
    
    for (int j = low; j < high - 1; j++) {
      if( arr[j].getGrado() < pivot){
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, high);

    return ( i + 1 );
  }


  public static void swap(Alumno[] arr, int i, int j){
    Alumno temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


  /**
   ** Quicksort para ordenar una matriz. 
   */

  public static void matriz(Alumno[][] mat, String param, int row){
    if(row < mat.length){
      matriz(mat, 0, mat[0].length-1, row, param);
      matriz(mat,param,row + 1);
    }
  }

  public static void matriz(Alumno[][] mat, int low, int high, int row, String param){
      if( low < high ){
        int index = partition(mat, low, high, row, param);
        matriz(mat, low, index - 1, row, param);
        matriz(mat, index + 1, high, row, param);
      }
  }

  public static int partition( Alumno[][] mat, int low, int high, int row, String param){
    Alumno pivot = mat[row][high];
    int i = low - 1;
    for( int j = low; j < high; j++){
      if( mat[row][j] != null && pivot != null){
        switch (param) {
          case "promedio":
            if( mat[row][j].getPromedio() <= pivot.getPromedio()){
              i += 1;
              swap(mat, i, j, row);
            }
            break;
          case "apellido":
            if(mat[row][j].getApellido().compareTo(pivot.getApellido()) < 0){
              i += 1;
              swap(mat,i,j,row);
            }
            break;
          default:
            if(mat[row][j].getLegajo() <= pivot.getLegajo() ){
              i += 1;
              swap(mat, i, j, row);
            }
            break;
        }
      }else if(mat[row][j] != null && pivot == null){
        i+=1;
        swap(mat, i, j, row);
      }
    }
    swap(mat, i + 1, high, row);
    return i + 1;
  }

  public static void swap( Alumno[][] mat, int i, int j, int row){
    Alumno temp = mat[row][i];
    mat[row][i] = mat[row][j];
    mat[row][j] = temp;
  }






}
