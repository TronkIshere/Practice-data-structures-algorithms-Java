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

    public void exercise6(){
        System.out.println("Nhap a, b, c: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int t = 0;

        /* a < b thì hoán chuyển, vậy a >= b */
        if ( a < b ) { t = a; a = b; b = t; }
        /* a < c thì hoán chuyển, vậy a >= c, kết quả a lớn nhất */
        if ( a < c ) { t = a; a = c; c = t; }
        /* b < c thì hoán chuyển, vậy b >= c, kết quả c nhỏ nhất */
        if ( b < c ) { t = b; b = c; c = t; }

        System.out.println("Tang dan: " + c + " " + b + " " + a);
    }

    public void exercise7(){
        System.out.println("Nhap a, b: ");
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        float x = 0;
        if (a != 0) {
            x = -b / a;
            System.out.println("X: " + x);
        } else {
            System.out.println("Phuong trinh vo nghiem");
        }
    }

    public void exercise8(){
        double a, b, c, result;
        System.out.println("Nhap a, b, c: ");
        a = sc.nextFloat();
        b = sc.nextFloat();
        c = sc.nextFloat();
        result = 0;
        double delta = Math.pow(b, 2) - 4 * a * c;
         if(delta > 0){
             if(delta == 0){
                 result = -b/2*a;
                 System.out.println("X1 = X2 = " + result);
             } else {
                double x1 = (-b + Math.sqrt(delta)) / 2 * a;
                double x2 = (-b - Math.sqrt(delta)) / 2 * a;
                 System.out.println("X1: " + x2 + "\nX2: " + x1);
             }
         }
         else
            System.out.println("Phuong trinh vo nghiem");
    }

    //Ví dụ trong đề bị sai
    public void exercise10(){
        System.out.println("Nhap vao SIN (9 so): ");
        int nums = sc.nextInt();
        int s1 = 0, s2 = 0;
        int checkDigit = nums % 10;
        nums = nums / 10;

        while(nums != 0){
            if(nums % 10 >= 5) {
                int temp = nums % 10 * 2;
                while (temp != 0){
                    s2 += (temp % 10);
                    temp = temp / 10;
                }
            } else {
                s2 += nums % 10;
            }
            nums = nums / 10;

            s1 += nums % 10;
            nums = nums / 10;
        }
        if((s1 + s2 + checkDigit) % 10 == 0)
            System.out.println("Sin Hop le");
        else
            System.out.println("Sin khong hop le");
    }

    public static void main(String[] args){
        Childrens_code_lessons main = new Childrens_code_lessons();
        main.exercise10();
    }
}
