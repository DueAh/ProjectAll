package AlgorthmSort;

public class InsertionSort {
    static void printArray(int i, int a[]){
        System.out.printf("%d: ",i);
        for (int x:a){
            System.out.printf("%d ",x);
        }
        System.out.println();}
    static void InsertionSort(int a[]){
        for(int i=1;i<a.length;i++){
            int temp = a[i];
            int j=i-1;
            while (j>=0 && a[j]>temp){
                a[j+1] = a[j];
                j--;
            }printArray(i,a);
            a[j+1] = temp;

        }
    }
    //  int index;
    //          int val;
    //          for(int i=1;i<a.length;i++){
    //              index = i;
    //              val = a[i];
    //              while (index>0 && a[index-1]>val){
    //                  a[index] = a[index-1];
    //                  index--;
    //              }
    //              a[index] = val;
    public static void main(String[] args) {
int a[] = {5,3,2,7,8,1,2};
    InsertionSort(a);
    }
}
