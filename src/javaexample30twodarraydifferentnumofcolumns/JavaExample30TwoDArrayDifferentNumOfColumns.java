package javaexample30twodarraydifferentnumofcolumns;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaExample30TwoDArrayDifferentNumOfColumns {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //----------------------------------------------------------------------
        int[] a = {1, 2, 3, 4, 5};
        System.out.print("One dimensional array: ");
        PrintOneDimArray(a);
        PrintOneItemFrom1DArray(a, a.length + 5);
        System.out.println();

        //----------------------------------------------------------------------
        
        int[][] b = {{1, 2, 3},
        {4, 5, 6, 7, 8, 9},
        {10, 11},
        {12, 13, 14, 15}
        };
        System.out.println("Two dimensional array: ");
        PrintTwoDimArray(b);
        System.out.println();
        
        //----------------------------------------------------------------------
        try{
        int[][] c = new int[3][];
        c[0]=new int[5]; 
        c[1]=new int[2];
        c[2]=new int[1];
        c[3]=new int[3]; // here we get an exception
        c[0][0]=1;
        c[0][1]=1;
        c[0][2]=1;
        c[0][3]=1;
        c[0][4]=1;
        //c[0][5]=1;
        //c[0][6]=1;
        c[1][0]=1;
        c[1][1]=1;
        c[2][0]=1;
        System.out.println("Two dimensional array: ");
        PrintTwoDimArray(c);
        System.out.println();
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e.toString());
        }
        //----------------------------------------------------------------------
        
        int[] arrayMeasures = TwoDArrayMeasures(in);
        int[][] arr=GetTwoDimArray( in,  arrayMeasures);
        System.out.println("Two dimensional array: ");
        PrintTwoDimArray(arr);
        System.out.println();
        
        //----------------------------------------------------------------------
        
        int[][] z=new int[3][];
        z[0]=new int[] {1,2,3,4,5};
        z[1]=new int[] {6,7};
        z[2]=new int[] {8,9,10 };
        
        int[][] y=new int[][] {{10,11},{12,13,14},{15,16,17}};
        
        System.out.println("Your array is....");
        PrintTwoDimArray(z);
        System.out.println("Your array is....");
        PrintTwoDimArray(y);
         

    }//end main()

    private static int[] Get1DArray(Scanner input, int len) {
        int[] res = null;
        try {
            if (len <= 0) {
                throw new IllegalArgumentException("Array length can not be zero or negative");
            }
            res = new int[len];
            for (int i = 0; i < res.length; i++) {
                res[i] = GetInteger(input);
                input.nextLine();
            }
            return res;
        }// end try
        catch (IllegalArgumentException e) {
            input.nextLine();
            System.out.println(e.toString());
            System.out.print("Enter array-length: ");
            int a = input.nextInt();
            input.nextLine();
            return Get1DArray(input, a);
        } catch (InputMismatchException e) {
            input.nextLine();
            System.out.println(e.toString());
            return Get1DArray(input, len);
        }
    }// end Get1DArray(Scanner input, int len)

    private static int[][] GetTwoDimArray(Scanner input, int[] measures) {

        try {
            int row = measures.length;

            int[][] result = new int[row][];

            int tempCol;
            for (int i = 0; i < measures.length; i++) {

                tempCol = measures[i];
                result[i] = Get1DArray(input, tempCol);
            }// end for
            return result;
        } catch (Exception e) {
            input.nextLine();
            System.out.println(e.toString());
            measures = TwoDArrayMeasures(input);
            return GetTwoDimArray(input, measures);
        }
    }// end GetTwoDimArray(Scanner input, int[] measures)

    private static int[] TwoDArrayMeasures(Scanner input) {
        try {
            System.out.print("Enter number of rows: ");

            int rows = GetInteger(input);
            input.nextLine();

            int[] result = new int[rows];
            for (int i = 0; i < result.length; i++) {
                System.out.print("Enter number of columns of row#" + i + " : ");

                result[i] = GetInteger(input);
                input.nextLine();
            }
            return result;
        } catch (Exception e) {
            input.nextLine();
            System.out.println(e.toString());
            return TwoDArrayMeasures(input);
        }
    }

    private static int GetInteger(Scanner input) {
        int res = 0;
        try {
            res = input.nextInt();
            if (res <= 0) {
                throw new InputMismatchException("zero or negative number!");
            }
            return res;
        } catch (Exception e) {
            input.nextLine();
            System.out.println(e.toString());
            return GetInteger(input);
        }
    }

    private static void PrintTwoDimArray(int[][] bigArray) {
        for (int i = 0; i < bigArray.length; i++) {

            for (int j = 0; j < bigArray[i].length; j++) {
                System.out.print(bigArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void PrintOneDimArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void PrintOneItemFrom1DArray(int[] array, int index) {
        int temp = 0;
        try {
            temp = array[index];
            System.out.println("Item with index (" + index + ") is: " + temp);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("There is no item with *index: " + index);
        }
    }
}
