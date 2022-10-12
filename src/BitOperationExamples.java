public class BitOperationExamples {
    public static void main(String[] args) {

        schreibweiseZahlen();

        stringDarstellungZahlenformate();

        bitOperations();

        shiftOperations();


    }


    private static void schreibweiseZahlen() {

        System.out.println("*** mögliche Schreibweisen von Zahlen ***");
        int dec = 110; // no prefix --> decimal literal
        int bin = 0b1101110; // '0b' prefix --> binary literal
        int oct = 0156; // '0' prefix --> octal literal
        int hex = 0x6E; // '0x' prefix --> hexadecimal literal
        long maxLong = 0x7fff_ffff_ffff_ffffL;  //Underscore _ dient nur zur besseren Lesbarkeit
        byte nybbles = 0b0010_0101;
        long bytes = 0b11010010_01101001_10010100_10010010;

        System.out.println(oct); //Die Darstellung (Umwandlung zu String) erfolgt standardmäßig immer als Dezimalzahl
    }

    private static void stringDarstellungZahlenformate() {

        System.out.println("*** String zu int/long ***");
        int a = Integer.parseInt("183");
        int h = Integer.parseInt("B7", 16); // = ...(Zahl, Basis)
        int n1 = Integer.parseInt("10110111", 2);
        long n2 = Long.parseLong("10110111", 2);


        System.out.println("*** int/long zu String");
        String s1a = Integer.toString(n1, 2); // = ...(Zahl, Basis)
        String s2a = Long.toString(n2, 2); // = ...(Zahl, Basis)
        String s1b = Integer.toBinaryString(n1);
        String s1o = Integer.toOctalString(n1);
        String s1h = Integer.toHexString(n1);
        String s2b = Long.toBinaryString(n2);
        String s2o = Long.toOctalString(n2);
        String s2h = Long.toHexString(n2);
    }

    private static void bitOperations() {

        System.out.println("*** Bitoperations ***");

        // Das Ergebnis einer Bitoperation ist immer int oder long,
        // bei byte oder short muss gecastet werden.
        byte b1 = 0x1f;
        /* byte erg2 = b1 >> 1; */ // ->Syntax-Error, da b >> 1 vom typ int ist
        int erg = b1 >> 1;
        byte ergCast = (byte) (b1 >> 1);

        //Punkte im Kommentar dienen nur der besseren Lesbarkeit
        int a = 0xAF; // = 1010.1111
        int b = 0x3C; // = 0011.1100

        System.out.printf("a = %d (Hex: 0x%s, Binär: %s)\n", a, Integer.toHexString(a), Integer.toBinaryString(a));
        System.out.printf("b = %d (Hex: 0x%s, Binär: %s)\n", b, Integer.toHexString(b), Integer.toBinaryString(b));

        //Bitweises und: `&` → Beide Bits müssen 1 sein.
        int c = a & b;  // a =   1010.1111
        // b =   0011.1100
        // a&b = 0010.1100
        System.out.printf("a & b = %d (Hex: 0x%s, Binär: %s)\n", c, Integer.toHexString(c), Integer.toBinaryString(c));

        //Bitweises oder: `|` → Mindestens ein Bit muss 1 sein.
        int d = a | b;  // a =    1010.1111
        // b =    0011.1100
        // a|b = 1011.1111
        System.out.printf("a | b = %d (Hex: 0x%s, Binär: %s)\n", d, Integer.toHexString(d), Integer.toBinaryString(d));


        //Bitweises exklusiv oder (XOR): `^` → Genau ein Bit darf 1 sein.

        int e = a ^ b;  // a =   1010.1111
        // b =   0011.1100
        // a^b = 1001.0011
        System.out.printf("a ^ b = %d (Hex: 0x%s, Binär: %s)\n", e, Integer.toHexString(e), Integer.toBinaryString(e));

        //Bitweises invertieren: `~` → Jedes Bit wird umgedreht (0 -- 1)
        // beachte die führenden Nullen, da int 32 Bit hat:
        int f = ~a; // a = 0000.0000.0000.0000.0000.0000.1010.1111
        // f = 1111.1111.1111.1111.1111.1111.0101.0000

        System.out.printf("~a = %d (Hex: 0x%s, Binär: %s)\n", f, Integer.toHexString(f), Integer.toBinaryString(f));

    }

    private static void shiftOperations() {

        System.out.println("*** Shiftoperations ***");


        // nach Links schieben: `<<` → Schiebt die Bits um beliebig viele Stellen nach links
        int a = 0xff;   // a= 1111.1111
        int b = a << 4; // b= 1111.1111.0000 (=0xff0)

        System.out.printf("a << 4 = %d (Hex: 0x%s, Binär: %s)\n", b, Integer.toHexString(b), Integer.toBinaryString(b));

        // nach Rechts schieben: `>>` → Schiebt die Bits um beliebig viele Stellen nach rechts.
        // Dabei wird links immer das Vorzeichen (= das "linkeste" Bit) hereingeschoben.
        int c = 0x88aa11dd; // = 1000.1000.1010.1010.0001.0001.1101.1101
        int d = c >> 4;     // = 1111.1000.1000.1010.1010.0001.0001.1101 (= 0xf88aa11d)

        System.out.printf("c >> 4 = %d (Hex: 0x%s, Binär: %s)\n", d, Integer.toHexString(d), Integer.toBinaryString(d));

        int e = 0x77aa11dd; // = 0111.0111.1010.1010.0001.0001.1101.1101
        int f = e >> 4;     // = 0000.0111.0111.1010.1010.0001.0001.1101 (= 0x077aa11d = 0x77aa11d)

        System.out.printf("e >> 4 = %d (Hex: 0x%s, Binär: %s)\n", f, Integer.toHexString(f), Integer.toBinaryString(f));


        // nach Rechts schieben: `>>>` → Schiebt die Bits um beliebig
        //viele Stellen nach rechts (Dabei wird links immer 0 hereingeschoben.)
        int g = 0x88aa11dd; // = 1000.1000.1010.1010.0001.0001.1101.1101
        int h = g >>> 4;     // = 0000.1000.1000.1010.1010.0001.0001.1101 (= 0x088aa11d)
        System.out.printf("g >>> 4 = %d (Hex: 0x%s, Binär: %s)\n", h, Integer.toHexString(h), Integer.toBinaryString(h));

        int i = 0x77aa11dd; // = 0111.0111.1010.1010.0001.0001.1101.1101
        int j = i >>> 4; // = 0000.0111.0111.1010.1010.0001.0001.1101 (= 0x77aa11d)
        System.out.printf("i >>> 4 = %d (Hex: 0x%s, Binär: %s)\n", j, Integer.toHexString(j), Integer.toBinaryString(j));

    }

}
