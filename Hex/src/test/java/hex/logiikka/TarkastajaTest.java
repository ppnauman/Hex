package hex.logiikka;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TarkastajaTest {

    Tarkastaja t;

    public TarkastajaTest (){
    }

    @Before
    public void setUp() {
        t = new Tarkastaja(11);
    }

    @Test
    public void ketjutAlustetaanOikein11x11Testi() {
        String odotetutKetjut = ""
                + "   0   1   1   1   1   1   1   1   1   1   1   1  12\n"
                + "   0  14  15  16  17  18  19  20  21  22  23  24  12\n"
                + "   0  27  28  29  30  31  32  33  34  35  36  37  12\n"
                + "   0  40  41  42  43  44  45  46  47  48  49  50  12\n"
                + "   0  53  54  55  56  57  58  59  60  61  62  63  12\n"
                + "   0  66  67  68  69  70  71  72  73  74  75  76  12\n"
                + "   0  79  80  81  82  83  84  85  86  87  88  89  12\n"
                + "   0  92  93  94  95  96  97  98  99 100 101 102  12\n"
                + "   0 105 106 107 108 109 110 111 112 113 114 115  12\n"
                + "   0 118 119 120 121 122 123 124 125 126 127 128  12\n"
                + "   0 131 132 133 134 135 136 137 138 139 140 141  12\n"
                + "   0 144 145 146 147 148 149 150 151 152 153 154  12\n"
                + "   0 157 157 157 157 157 157 157 157 157 157 157  12\n"
                + "";
        assertEquals(odotetutKetjut, t.toString());
    }

    @Test
    public void ketjujenKootAlustetaanOikein11x11Testi() {

        String odotetutKoot = "  13  11   1   1   1   1   1   1   1   1   1   1  13\n"
                + "   1   1   1   1   1   1   1   1   1   1   1   1   1\n"
                + "   1   1   1   1   1   1   1   1   1   1   1   1   1\n"
                + "   1   1   1   1   1   1   1   1   1   1   1   1   1\n"
                + "   1   1   1   1   1   1   1   1   1   1   1   1   1\n"
                + "   1   1   1   1   1   1   1   1   1   1   1   1   1\n"
                + "   1   1   1   1   1   1   1   1   1   1   1   1   1\n"
                + "   1   1   1   1   1   1   1   1   1   1   1   1   1\n"
                + "   1   1   1   1   1   1   1   1   1   1   1   1   1\n"
                + "   1   1   1   1   1   1   1   1   1   1   1   1   1\n"
                + "   1   1   1   1   1   1   1   1   1   1   1   1   1\n"
                + "   1   1   1   1   1   1   1   1   1   1   1   1   1\n"
                + "   1  11   1   1   1   1   1   1   1   1   1   1   1\n";

        assertEquals(odotetutKoot, t.ketjujenKoot());

    }

    @Test
    public void kostruktoriAsettaaLaudanKoonOikein() {
        assertEquals(11, t.haeLaudanKoko());
    }

    @Test
    public void loydaKetjuTesti_1() {
        assertEquals(94, t.loydaKetju(94));
    }

    @Test
    public void loydaKetjuTesti_2() {
        assertEquals(157, t.loydaKetju(167));
    }

    @Test
    public void loydaKetjuTesti_3() {
        assertEquals(12, t.loydaKetju(168));
    }

    @Test
    public void yhdistaKetjutTesti_1() {
        t.yhdistaKetjut(138, 139);
        assertEquals(t.loydaKetju(138), t.loydaKetju(139));
    }

    @Test
    public void yhdistaKetjutTesti_2() {
        for (int i = 104; i < 116; i++) {
            t.yhdistaKetjut(i, i + 1);
        }
        assertEquals(t.loydaKetju(104), t.loydaKetju(116));
    }

    @Test
    public void yhdistaKetjutKokoTesti_1() {
        t.yhdistaKetjut(146, 157);
        assertEquals(12, t.ketjunKoko(157));
    }

    @Test
    public void yhdistaKetjutKokoTesti_2() {
        t.yhdistaKetjut(146, 133);
        t.yhdistaKetjut(133, 120);
        assertEquals(3, t.ketjunKoko(133));
    }

    @Test
    public void voittajanTarkistusTesti_1() {
        assertEquals(0, t.voittajanTarkistus());
    }

    @Test
    public void voittajanTarkistusTesti_2() {
        for (int i = 104; i < 116; i++) {
            t.yhdistaKetjut(i, i + 1);
        }
        assertEquals(1, t.voittajanTarkistus());
    }

    @Test
    public void voittajanTarkistusTesti_3() {
        for (int i = 2; i <= 145; i += 13) {
            t.yhdistaKetjut(i, i + 13);
        }
        assertEquals(2, t.voittajanTarkistus());
    }
}
