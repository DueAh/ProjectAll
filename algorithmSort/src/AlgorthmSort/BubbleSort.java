package AlgorthmSort;

public class BubbleSort {
    static void printArray(int i, int a[]){
        System.out.printf("%d: ",i);
        for (int x:a){
            System.out.printf("%d ",x);
        }
        System.out.println();
    }
    static void BubbleSort(int a[]){
        for(int i=0;i<a.length;i++){
            boolean isSorted= true;
            for(int j=0 ; j < a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    isSorted=false;
                    int temp= a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }

        printArray(i,a);
            if(isSorted) break;;
        }
    }
    public static void main(String[] args) {

int a[]={5,3,2,7,8,1,2};
BubbleSort(a);
    }
}
