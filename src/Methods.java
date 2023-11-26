import java.util.Scanner;

public class Methods {

  public static void cargarMatriz(Alumno[][] mat, String data){
    String studentData;
    Alumno student;
    int[] arr = {0,0,0,0,0,0,0};
    int i, j;
    i = 0;
    while( i < mat.length && data.length() > 0){
      j = 0;
      while( j < mat[0].length && data.length() > 0){
        studentData = data.substring(0, data.indexOf(';'));
        student = getSingleStudent(studentData);
          if(arr[student.getGrado()-1] < mat[0].length){
            mat[student.getGrado()-1][arr[student.getGrado()-1]] = student;
            arr[student.getGrado()-1] += 1;
          }
        data = sliceData(data, ';');
        j += 1;
      }
      i += 1;
    }
  }
  
  public static void pasarDeGrado(Alumno[][] mat, Alumno[] gradArr, String repitentes, String ingresantes){
    int i = 0;
    int j = 0;
    int k = 0;
    int[] aux = {0,0,0,0,0,0,0};
    int legajo;
    Alumno[][] newMat = new Alumno[7][30];
    
    while(repitentes.length() > 0){
      legajo = Integer.parseInt(repitentes.substring(0, 4));
      repitentes = repitentes.substring(5,repitentes.length());
      for(i = 0; i < 7; i++){
        j = 30;
        while( j > 0 && mat[i][j] != null){
          if(mat[i][j] != null){
            if( mat[i][j].getLegajo() == legajo)
              mat[i][j].repetir();
          }
          j += 1;
        }
      }
    }

    for(i = 0; i < 7; i++){
      for( j = 0; j < 30; j++){
        if(mat[i][j] != null)
          mat[i][j].promover();
        else
          j = 30;
      }
    }

    for( i = 0; i < 7; i++){
      for( j = 30; j >= 0; j--){
        if(mat[i][j].getGrado() > 7){
          gradArr[k] = mat[i][j];
          mat[i][j] = null;
          k += 1;
        }
        else{
          if(aux[mat[i][j].getGrado()-1] < 30){
            newMat[mat[i][j].getGrado()-1][aux[mat[i][j].getGrado()-1]] = mat[i][j];
            aux[mat[i][j].getGrado()-1] += 1;
          }
        }
      }
    }
    emptyPlacesOrder(newMat);
    
    // display(newMat, "grado");

    ingresar(newMat, ingresantes);
    cloneMat(mat, newMat);
  }

  public static void ingresar(Alumno[][] mat, String ingresantes){
    Alumno alumno;
    boolean registrado;
    int[] cont = {0,0,0,0,0,0};
    int i;
    i = 0;
    while( ingresantes.length() > 0){
      i = 0;
      alumno = getSingleStudent(ingresantes);
      ingresantes = sliceData(ingresantes, ';');
      registrado = false;
      
      if( alumno.getGrado()==1 ){
        while(!registrado && i < 30){
          if(mat[0][i] == null){
            mat[0][i] = alumno;
            registrado = true;
          }
          i += 1;
        }
      }
      else if( cont[ alumno.getGrado()-2] < 3){
        while(!registrado && i < 30){
          
          if(mat[alumno.getGrado()-1][i] == null){
            cont[alumno.getGrado()-2] += 1;
            mat[alumno.getGrado()-1][i] = alumno;
            registrado = true;
          }
          i+=1;
          // displayCourse(mat, 6, "grado");
          
        }
      }
    }
    
    
  }




  public static Alumno getSingleStudent(String data){
    String nombre, apellido;
    int legajo,grado;
    double prom;
    apellido = getSubstring(data);
    data = sliceData(data,':');
    nombre = getSubstring(data);
    data = sliceData(data,':');
    legajo = Integer.parseInt(getSubstring(data));
    data = sliceData(data,':');
    grado = Integer.parseInt(getSubstring(data));
    data = sliceData(data,':');
    prom = Double.parseDouble(data.substring(0,1));
    return new Alumno(legajo,nombre,apellido,grado,prom);
  }

  public static String sliceData(String data, char c){
    return data.substring(data.indexOf(c)+1, data.length());
  }

  public static String getSubstring(String data){
    return data.substring(0,data.indexOf(':'));
  }


  public static void display(Alumno[][] mat, String param){
    for (int i = 0; i < mat.length; i++) {
      System.out.print((i+1)+"-");
      for (int j = 0; j < mat[0].length; j++) {
        if(mat[i][j] == null){
          // System.out.print("null|");
          if(j == 0){
            System.out.print("null|");
          }
          j = mat[0].length;
        }
        else{
          switch (param) {
            case "legajo": 
              System.out.print(mat[i][j].getLegajo()  +"|");
              break;
            case "apellido": 
              System.out.print(mat[i][j].getApellido()+"|");
              break;
            case "nombre": 
              System.out.print(mat[i][j].getNombre()  +"|");
              break;
            case "promedio": 
              System.out.print(mat[i][j].getPromedio()+"|");
              break;
            case "grado":
              System.out.print(mat[i][j].getGrado()+"   |");
              break;
            default:
              System.out.print(mat[i][j].toString());
              break;
          }
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void display(Alumno[] arr, String param){
    for( int i = 0; i < arr.length; i++){
      if(arr[i] == null)
        i = arr.length;
      else{
        switch (param) {
          case "legajo": 
            System.out.print(arr[i].getLegajo()  +"|");
            break;
          case "apellido": 
            System.out.print(arr[i].getApellido()+"|");
            break;
          case "nombre": 
            System.out.print(arr[i].getNombre()  +"|");
            break;
          case "promedio": 
            System.out.print(arr[i].getPromedio()+"|");
            break;
          case "grado":
            System.out.print(arr[i].getGrado()+"   |");
            break;
          default:
            System.out.print(arr[i].toString());
            break;
        }
      }
    }
    System.out.println();
  }
  
  public static void displayCourse(Alumno[][] arr, int course, String param){
    for( int i = 0; i < 30; i++){
      if( arr[course][i] != null)
      System.out.print(arr[course][i].getGrado() + "   |");
    }
    System.out.println();
  }

  public static void emptyPlacesOrder(Alumno[][] mat){
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length-1; j++) {
        for (int k = 0; k < mat[0].length-1-j; k++) {
          if(mat[i][k] == null && mat[i][k+1] != null){
            swap(mat, i, k);
          }
        }
      }
    }
  }

  public static void bubble(Alumno[][] mat, String param){
    boolean ordered = false;
    int j = 0;
    // if( ! (param.equals("legajo") || param.equals("apellido")) ) return;
    if( param.equals("legajo") || param.equals("apellido")){
      for (int i = 0; i < mat.length; i++) {
        while ( j < mat[0].length-1 && !ordered) {
          ordered = true;
          for (int k = 0; k < mat[0].length-1-j; k++) {
            if(mat[i][k] != null && mat[i][k+1] != null){
              switch (param) {
                case "legajo":
                  if( mat[i][k].getLegajo() > mat[i][k+1].getLegajo())
                    swap(mat, i, k);
                  break;
                case "apellido":
                  if( mat[i][k].getApellido().compareTo(mat[i][k+1].getApellido())>0)
                    swap(mat, i, k);
                  break;
              }
            }
          }
          j += 1;
        }
      }
    }
  }

  public static void mostrarGrado(Alumno[][] mat, int grado, String param){
    Alumno[] arr = new Alumno[30];
    for (int i = 0; i < 30; i++)
      arr[i] = mat[grado][i];
    for (int i = 0; i < arr.length-1; i++) {
      for (int j = 0; j < arr.length-1-i; j++) {
        if(arr[j] != null && arr[j+1] != null){
          switch (param) {
            case "nombre":
              if( arr[j].getNombre().compareTo(arr[j+1].getNombre()) > 0)
                swap(arr, j);
              break;
            case "apellido":
              if( (arr[j].getApellido().compareTo(arr[j+1].getApellido())) > 0)
                swap(arr, j);
              break;
            case "legajo":
              if( arr[j].getLegajo() > arr[j+1].getLegajo())
                swap(arr, j);
              break;
            case "promedio":
              if( arr[j].getPromedio() > arr[j+1].getPromedio())
                swap(arr, j);
              break;
          }
        }
      }
    }
    display(arr,param);
  }

  public static void swap(Alumno[][] mat, int i , int j){
    Alumno aux;
    aux = mat[i][j];
    mat[i][j] = mat[i][j+1];
    mat[i][j+1] = aux;  
  }

  public static void swap(Alumno[] arr, int i){
    Alumno aux = arr[i];
    arr[i]= arr[i+1];
    arr[i+1]= aux;
   
  }

  public static void cloneMat(Alumno[][] m1, Alumno[][] m2){
    if(m1.length != m2.length || m1[0].length != m2[0].length) return;
    for (int i = 0; i < m1.length; i++) {
      for (int j = 0; j < m1[0].length; j++)
        m1[i][j] = m2[i][j];
    }
  }

  public static boolean registrarNuevo(Alumno[][] mat){
    Scanner sc =new Scanner(System.in);
    boolean reg = false;
    int legajo, grado;
    String nombre, apellido;
    double prom; 

    System.out.println("Ingrese el legajo: ");
    legajo = sc.nextInt();
    System.out.println("Ingrese el nombre: ");
    nombre = sc.nextLine();
    System.out.println("Ingrese el apellido: ");
    apellido = sc.nextLine();
    System.out.println("Ingrese el grado: ");
    grado = sc.nextInt();
    System.out.println("Ingrese el promedio: ");
    prom = sc.nextDouble();
    Alumno alumno = new Alumno(legajo,nombre,apellido,grado,prom);
    for (int i = 0; i < 30; i++) {
      if( mat[grado][i] == null){
        mat[grado][i] = alumno;
        reg = true;
      }
    }
    sc.close();
    return reg;
  }

  public static String encontrarAlumno(Alumno[][] mat, int legajo){
    String pos = "no encontrado";
    boolean aux = false;
    int i = 0;
    int j = 0;
    while( i < 7 && !aux){
      while( j < 30 && !aux && mat[i][j] != null){
        if(mat[i][j].getLegajo() == legajo){
          pos = "("+String.valueOf(i) + "," + String.valueOf(j)+")";
          aux = true;
        }
        j += 1;
      }
      j = 0;
      i += 1;
    }
    return pos;
  }


}
