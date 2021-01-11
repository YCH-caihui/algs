package sparse;

import java.io.*;

public class main {

    public static void main(String[] argc) {

        int[][] array = new int[11][11];
        array[2][3] = 100;
        array[10][3] = 666;
        array[10][10] = 999;

        for(int[] pa : array) {
            for(int i : pa) {
                System.out.printf(" %d  ", i);
            }
            System.out.println(" ");
        }

        System.out.println("===========================================================");

        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            for(int k = 0; k < array[i].length; k++) {
                if(array[i][k] != 0) {
                    sum++;
                }
            }
        }

        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = sum;

        int index = 0;
        for(int i = 0; i < array.length; i++) {
            for(int k = 0; k < array[i].length; k++) {
                if(array[i][k] != 0) {
                    index++;
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = k;
                    sparseArray[index][2] = array[i][k];
                }
            }
        }


        for(int[] pa : sparseArray) {
            for(int value : pa) {
                System.out.printf("  %d  ", value);
            }

            System.out.println("  ");
        }

        System.out.println("===========================================================");

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("a.txt"));
            bufferedWriter.write((sum +1) + "\n" );
            bufferedWriter.write( 3  +"\n");
            for(int i = 0; i < sparseArray.length; i++) {
                for(int k = 0; k < sparseArray[i].length; k++) {
                    bufferedWriter.write(sparseArray[i][k]+"\n");
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("a.txt"));
            String rowStr =  bufferedReader.readLine();
            String column = bufferedReader.readLine();
            int[][] sparse = new int[Integer.parseInt(rowStr)][Integer.parseInt(column)];
            for(int i = 0; i < sparse.length; i++) {
                for(int k = 0; k < sparse[i].length; k++) {
                   sparse[i][k] = Integer.parseInt(bufferedReader.readLine());
                }
            }
            bufferedReader.close();

            for(int[] temp : sparse) {
                for(int value : temp) {
                    System.out.printf("  %d  ", value);
                }
                System.out.println("  ");
            }

            System.out.println("=======================================");

            int[][] reArray = new int[sparse[0][0]][sparse[0][1]];

            int count = sparse[0][2] + 1;
            for(int i = 1; i < count; i++) {
                reArray[sparse[i][0]][sparse[i][1]] = sparse[i][2];
            }

            for(int[] temp : reArray) {
                for(int value : temp) {
                    System.out.printf(" %d ", value);
                }
                System.out.println("  ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
