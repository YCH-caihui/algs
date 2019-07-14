
//二分法查找
public class BinarySearch {

    public BinarySearch() {

    }

    public static int indexOf(int[] a,int key) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(key < a[mid]) hi = mid - 1;
            else if
            (key > a[mid]) lo = mid + 1;
            else return mid;
        }

        return  -1;
    }

//    public static int in(int [] a, int key) {
//        int lo = 0;
//        int hi = a.length - 1;
//
//        while(lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            if(key < a[mid]) hi = mid - 1;
//            else if(key > a[mid]) lo = mid + 1;
//            else  return mid;
//        }
//
//        return -1;
//    }

    public static void main(String[] argc) {
        int a[] = {1,2,3,4,5,6,7,8,9,10};
        int index = indexOf(a, 9);
        System.out.println(index+"");
    }

}
