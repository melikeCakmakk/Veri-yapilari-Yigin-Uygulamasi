public class Struct {
    Stack1 top1 = null, gec1 = null;
    Stack2 top2 = null, gec2 = null;
    Dugum ilk = null, son = null;

    public void ekle(char karakter) {
        Dugum dugum = new Dugum(karakter);
        if (ilk == null) {
            ilk = dugum;
            son = dugum;
        } else {
            son.sonra = dugum;
            dugum.prev = son;
            son = dugum;
        }
    }

    void push1(int sayi, String d) {
        Stack1 stack1 = new Stack1(d, sayi);
        if (top1 == null) {
            top1 = stack1;
            top1.sonra1 = null;
        } else {
            stack1.sonra1 = top1;
            top1 = stack1;
        }
    }

    void pop1() {
        if (top1 == null) {
            System.out.println("Stack bos");
        } else {

            gec1 = top1.sonra1;
            top1 = gec1;
        }
    }

    Stack1 Stack1Cıkar() {
        gec1 = top1;
        top1 = top1.sonra1;
        return gec1;
    }

    Stack2 Stack2Cıkar() {
        gec2 = top2;
        top2 = top2.sonra2;
        return gec2;
    }

    int kelimeBul(Dugum temp) {
        String kelime = "";
        int sayac = 0;
        do {
            kelime = kelime + temp.karak;
            temp = temp.sonra;
            sayac++;
        }
        while (temp != null && temp.karak != '(' && temp.karak != ')' && temp.karak >= 'a' && temp.karak <= 'z' && !Character.isUpperCase(temp.karak));
        push1(1, kelime);
        return sayac;
    }

    void listeleme1() {
        gec1 = top1;

        if (top1 == null) {
            System.out.println("Stack bos sj");
        } else {
            while (gec1.sonra1 != null) {
                System.out.println(gec1.karakter1 + ":" + gec1.adet1);
                gec1 = gec1.sonra1;
            }
            System.out.println(gec1.karakter1 + ":" + gec1.adet1);
        }
    }

    void push2(int sayi, String ke) {
        Stack2 stack2 = new Stack2(ke, sayi);
        if (top2 == null) {
            top2 = stack2;
            top2.sonra2 = null;
        } else {
            stack2.sonra2 = top2;
            top2 = stack2;
        }
    }

    int Stack2BosMu() {
        if (top2 == null) {
            return 0;
        }
        return 1;
    }

    void listeleme2() {
        gec2 = top2;

        if (top2 == null) {
            System.out.println("Stack bos");
        } else {
            while (gec2.sonra2 != null) {
                System.out.println(gec2.karakter2 + ":" + gec2.adet2);
                gec2 = gec2.sonra2;
            }
            System.out.println(gec2.karakter2 + ":" + gec2.adet2);
        }
    }


    class Stack2 {

        String karakter2;
        int adet2;
        Stack2 sonra2;

        public Stack2(String karakter2, int adet2) {
            this.karakter2 = karakter2;
            this.adet2 = adet2;
            this.sonra2 = sonra2;
        }
    }


    class Stack1 {
        String karakter1;
        int adet1;
        Stack1 sonra1;

        public Stack1(String karakter1, int adet) {
            this.karakter1 = karakter1;
            this.adet1 = adet;
            this.sonra1 = sonra1;
        }
    }

    class Dugum {
        char karak;
        Dugum sonra, prev;

        public Dugum(char karak) {
            this.karak = karak;
            this.sonra = sonra;
            this.prev = prev;
        }
    }
}
