import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Struct struct = new Struct();
        Scanner scan = new Scanner(System.in);
        int sayi;
        int kacAdet = 0;
        String a;

        System.out.println("islem yapilacak stringi giriniz");
        a = scan.nextLine();
        for (int i = 0; i < a.length(); i++) {
            struct.ekle(a.toCharArray()[i]);
        }
        Struct.Dugum temp = struct.ilk;
        while (temp != null) {

            if (Character.isUpperCase(temp.karak)) {
                struct.kelimeBul(temp);
            } else if (temp.karak == '(') {
                struct.push1(1, String.valueOf(temp.karak));
                kacAdet = struct.kelimeBul(temp.sonra);
                for (int i = 0; i < kacAdet; i++) {
                    temp = temp.sonra;
                }
            }
            Struct.Stack1 tempS = struct.top1;
            if (temp.karak == ')') {
                while (!tempS.karakter1.equals("(")) {
                    Struct.Stack1 al = struct.Stack1Cıkar();
                    struct.push2(al.adet1, al.karakter1);
                    tempS = tempS.sonra1;
                }
                struct.pop1();
            }
            sayi = Character.getNumericValue(temp.karak);
            if (sayi > 0 && sayi <= 9) {
                if (struct.Stack2BosMu() == 0) {
                    Struct.Stack1 h = struct.Stack1Cıkar();
                    int adet = h.adet1 * sayi;
                    struct.push1(adet, h.karakter1);
                } else {
                    Struct.Stack2 h = struct.top2;
                    while (h != null) {
                        Struct.Stack2 m = struct.Stack2Cıkar();
                        int adet = m.adet2 * sayi;
                        struct.push1(adet, m.karakter2);
                        h = h.sonra2;
                    }
                }
            }
            temp = temp.sonra;
        }
        System.out.println("SONUC:");
        struct.listeleme1();
        System.out.println("****************************");
        System.out.println("2. Struct Son Durum:");
        struct.listeleme2();
    }


}

