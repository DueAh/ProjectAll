package AlgorthmSort;

public class SelectionSort {
    static void printArray(int i, int a[]){
        System.out.printf("%d: ",i);
        for (int x:a){
            System.out.printf("%d ",x);
        }
        System.out.println();}
    static void selectionSort(int a[]){
        for(int i=0 ; i<a.length;i++){
            int minIndex=i;
            for(int j =i+1;j< a.length;j++){
                if(a[j]<a[minIndex]){
                    minIndex=j;
                }}
                if(minIndex!=i){
                    int temp = a[i];
                    a[i]=a[minIndex];
                    a[minIndex] = temp;
                }printArray(i,a);
            }

        }

    public static void main(String[] args) {
        int a[] = {5,3,2,7,8,1,2};
        selectionSort(a);
    }
}
