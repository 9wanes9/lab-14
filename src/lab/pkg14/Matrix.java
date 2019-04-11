package lab.pkg14;
import java.util.ArrayList;
import java.util.Random;

public class Matrix {
    
ArrayList<ArrayList<Float>> matrixFl=new ArrayList<ArrayList<Float>>();
    Float replacement;
    Float average1;
    Float average2;
    public Matrix(int index,int min,int max){
        System.out.println("\r\nМатрица с рандомными значениями в заданном диапазоне:");
        init(index,min,max);
        print(index);
        getGeneralDiag(index);
        getSecondaryDiag(index);
        replacement=average1;
        if(average1<average2)
         replacement=average2;
            setItemValue(index/2,index/2,replacement);
            System.out.println("\r\nМатрица с замененным центральным элементом:");
            print(index);
    }
    void init(int index,int min,int max){
        Random rnd = new Random();
        int size=max - min + 1;
        for(int i=0;i<index;i++){
            matrixFl.add(i,new ArrayList<>());
        }
        for(int r=0;r<index;r++){
            for(int c=0;c<index;c++){
                matrixFl.get(r).add((float)(min+rnd.nextInt(size)+Math.random()));
            }
        }
    }
    void print(int index){
        for(int r=0;r<index;r++){
            System.out.println();
            for(int c=0;c<index;c++){
               System.out.printf("%08.4f ", matrixFl.get(r).get(c));
               //  System.out.printf("%03.0f ", matrixFl.get(r).get(c));
            }
        }
    }
    public void getGeneralDiag(int index) {
        Float Sum=0.0F;
        for(int i=0;i<index;i++) {
            Sum+=matrixFl.get(i).get(i);
        }
        average1=Sum/index;
        System.out.println("\r\n\nСреднее значение главной диагонали: "+ average1);
    }
    public void getSecondaryDiag(int index) {
        Float Sum=0.0F;
        for(int i=0;i<index;i++) {
            Sum+=matrixFl.get(i).get(index-i-1);
        }
        average2=Sum/index;
        System.out.println("\r\nСреднее значение побочной диагонали: "+ average2);
    }
    public Float setItemValue(int x,int y,float value){
       return matrixFl.get(x).set(y,value);
    }
    public Float getItemValue(int x,int y){
     return matrixFl.get(x).get(y);
    }

}
