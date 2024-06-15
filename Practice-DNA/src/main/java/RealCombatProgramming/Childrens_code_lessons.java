package RealCombatProgramming;

import java.util.Scanner;

public class Childrens_code_lessons {
    Scanner sc = new Scanner(System.in);
    float pi = 3.141593F;

    public void exercise1(){
        float S, V, R;
        System.out.print("Nhap dien tich: ");
        S = sc.nextFloat();
        R = (float) Math.sqrt(S / (4 * pi));
        V = (float) ((4.0 / 3.0) * pi * Math.pow(R, 3));
        // Nên nhớ sử dụng .0 khi dùng kiểu dữ liệu float
        // Nếu không IDE sẽ nghĩ nó là kiểu dữ liệu Int và chia ra số int

        // bài toán trên có thể làm như thế này:
        // (4.0 / 3.0) * pi * Math.pow(Math.sqrt(S / (4 * pi)), 3)
        System.out.println("Ket qua la: " + V);
    }

    public void exercise2(){
        //bài tập này cần phải nhớ công thức toán
        float xA, yA, xB, yB;
        System.out.println("A(xA, yA): ");
        xA = sc.nextFloat();
        yA = sc.nextFloat();
        System.out.println("B(xB, yB): ");
        xB = sc.nextFloat();
        yB = sc.nextFloat();
        System.out.println("AB: " +
                (Math.sqrt((xB - xA) * (xB - xA) + (yB - yA) * (yB - yA))));
    }

    public void exercise3(){
        //bài tập này cần phải nhớ công thức toán
        double xC, yC, R, xM, yM, d;
        System.out.println("Nhap toa do tam C(xC, yC): ");
        xC = sc.nextDouble();
        yC = sc.nextDouble();
        System.out.println("Nhap vao ban kinh R: ");
        R = sc.nextDouble();
        System.out.println("Nhap toa do M(xM, yM): ");
        xM = sc.nextDouble();
        yM = sc.nextDouble();

        d =  R * R - ( ( xM - xC ) * ( xM - xC ) + ( yM - yC ) * ( yM - yC ) );
        if (d > 0)
            System.out.println("M nam trong C()");
        else if (d < 0)
            System.out.println("M nam ngoai C()");
        else
            System.out.println("M nam tren C()");
    }

    public static void main(String[] args){
        Childrens_code_lessons main = new Childrens_code_lessons();
        main.exercise3();
    }
}
