package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    //TODO
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        //Sacamos el tamaño de cada elemento del array de 3 dimensiones
        int indexi = intArrayTri.length;
        int indexj = intArrayTri[0].length;
        int indexk = intArrayTri[0][0].length;

        //Creamos el array bidimensional que vamos a devolver
        //El tamaño es igual que los arrays de 2 dimensiones que forman el tridimensional
        int[][] bidimensionalArray = new int[indexj][indexk];

        //Creamos una variable para la suma de las posiciones
        int aplanarDimension = 0;

        //Recorremos el array bidimensional para asignar valores
        for (int j = 0; j < indexj; j++) {
            for (int k = 0; k < indexk; k++) {
            //Recorremos cada uno de los niveles del array tridimensional para los valores de j y k
                //Sumamos estos valores por cada nivel de profundidad del array de 3 dimensiones
                for (int i = 0; i < indexi; i++) {
                    aplanarDimension += intArrayTri[i][j][k];
                }
                bidimensionalArray[j][k] = aplanarDimension;
                aplanarDimension = 0;
            }
        }
        return bidimensionalArray;
    }


    // TODO
    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder sb = new StringBuilder();
        //Hacemos un append a sb por cada fila del array de dos dimensiones
        //En cada iteración del bucle for llamamos a la función stringFlatMatrixRow
        for (int i = 0; i < intArrayBi.length; i++) {
            sb.append(stringFlatMatrixRow(intArrayBi, i));
            if (i < intArrayBi.length - 1) { //Añadir salto de linea excepto al final
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    // TODO
    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < uniArray.length; i++) {
            sb.append(uniArray[i]);
            if (i < uniArray.length - 1) {  //Añadir espacio excepto al final
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    // TODO
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] unidimensionalArray = new int[columns];
        for (int i = 0; i < unidimensionalArray.length; i++) {
            unidimensionalArray[i] = (i+1);
        }
        return unidimensionalArray;
    }

    // TODO
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] bidimensionalArray = new int[rows][columns];
        //Declaramos un acumulador de tipo int para ir rellenando el array
        int acumulador = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                acumulador++;
                bidimensionalArray[i][j] = acumulador;

            }
        }
        return bidimensionalArray;
    }

    // TODO
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] tridimensionalArray = new int[depth][rows][columns];
        //Declaramos un acumulador de tipo int para ir rellenando el array
        int acumulador = 0;
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j <rows; j++) {
                for (int k = 0; k < columns; k++) {
                    acumulador++;
                    tridimensionalArray[i][j][k] = acumulador;
                }
            }
        }
        return tridimensionalArray;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
