package sparse;

public class main {

    public static void main(String[] argc) {

        int[][] array = new int[11][11];
        array[2][3] = 100;
        array[10][3] = 666;

        for(int pa[] : array) {
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


        for(int pa[] : sparseArray) {
            for(int value : pa) {
                System.out.printf("  %d  ", value);
            }

            System.out.println("  ");
        }



    }
}
