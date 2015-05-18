package hex.logiikka;

/**
 * Luokka tarkkailee pelin ratkeamista eli laudan reunalta toiselle ulottuvan
 * 6-kulmioiden ketjun muodostumista union-find rakenteen avulla.
 */
public class HexTarkastaja {

    private int[] ketjut;
    private int[] ketjujenKoot;
    private int laudanKoko;

    /**
     * Konstruktori asettaa pelilaudan kunkin kuusikulmion omaan
     * ketjuunsa, joiden koko on yksi. Lisäksi pelilautaa reunustavat
     * 'apuviisikulmiot', jotka asetetaan siten, että
     * kullakin laudan sivustalla olevat viisikulmiot kuuluvat omaan ketjuunsa.
     * Pelilaudan kulmissa sijaitsevat viisikulmiot asetetaan
     * vasemman/oikean laidan ketjuihin.
     */
    public HexTarkastaja(int laudanKoko) {
        this.laudanKoko = laudanKoko;
        this.ketjut = new int[(laudanKoko + 2) * (laudanKoko + 2)];
        this.ketjujenKoot = new int[this.ketjut.length];

        for (int i = 0; i < this.ketjut.length; i++) {
            this.ketjut[i] = i;
            this.ketjujenKoot[i] = 1;
        }
        alustaReunukset(laudanKoko);
    }

    //apumetodi alustaa union-find rakenteen
    private void alustaReunukset(int laudanKoko) {
        int sivunPituus = (laudanKoko + 2);

        for (int i = 0; i < ketjut.length; i++) {
            if (i % sivunPituus == 0) {
                yhdistaKetjut(i, 0);
            } else if (i % sivunPituus == sivunPituus - 1) {
                yhdistaKetjut(i, sivunPituus - 1);
            } else if (i < sivunPituus - 1) {
                yhdistaKetjut(i, 1);
            } else if (i > sivunPituus * (sivunPituus - 1)) {
                yhdistaKetjut(i, ketjut.length - sivunPituus + 1);
            }
        }
    }

    /**
     * Tutkii mihin ketjuun tietty pelilaudan kuusikulmio kuuluu.
     *
     * @param monikulmio Monikulmion paikka pelilaudalla.
     * @return ketju, johon parametrina annettu monikulmio kuuluu
     */
    public int loydaKetju(int monikulmio) {

        while (this.ketjut[monikulmio] != monikulmio) {
            monikulmio = this.ketjut[monikulmio];
        }
        return this.ketjut[monikulmio];
    }

    /**
     * Yhdistää toisiinsa ne union-find rakenteen ketjut, joihin parametreina
     * annettavat pelilaudan monikulmiot kuuluvat.
     *
     * @param monikulmio1
     * @param monikulmio2
     */
    public void yhdistaKetjut(int monikulmio1, int monikulmio2) {
        int ketju1 = loydaKetju(monikulmio1);
        int ketju2 = loydaKetju(monikulmio2);

        if (ketju1 != ketju2) {
            if (this.ketjujenKoot[ketju1] > this.ketjujenKoot[ketju2]) {
                this.ketjut[ketju2] = this.ketjut[ketju1];
                this.ketjujenKoot[ketju1] += this.ketjujenKoot[ketju2];
            } else {
                this.ketjut[ketju1] = this.ketjut[ketju2];
                this.ketjujenKoot[ketju2] += this.ketjujenKoot[ketju1];
            }
        }
    }

    /**
     * Tarkistaa onko peli ratkennut eli kuuluvatko ylemman ja alemman tai
     * oikean ja vasemman reunustan viisikulmiot samaan ketjuun. Jos pelaaja1 on
     * voittanut, paluuarvo on 1. Jos pelaaja2 on voittanut, paluuarvo on 2. Jos
     * peli ei ole vielä ratkennut, on paluuarvo 0.
     *
     * @return 0, 1 tai 2.
     */
    public int voittajanTarkistus() {
        if (loydaKetju(0) == loydaKetju(this.laudanKoko + 1)) {
            return 1;
        }
        if (loydaKetju(1) == loydaKetju(this.ketjut.length - 2)) {
            return 2;
        }
        return 0;
    }

    public int haeLaudanKoko() {
        return this.laudanKoko;
    }

    public int ketjunKoko(int monikulmio) {
        return this.ketjujenKoot[monikulmio];
    }

    /**
     * Palauttaa pelilaudalla olevien ketjujen tämänhetkiset koot testauksen
     * kannalta havainnollisena 2D -merkkijonoesityksenä.
     *git commai
     * @return union-find -ketjujen koot
     */
    public String ketjujenKoot() {
        StringBuilder koot = new StringBuilder();
        for (int i = 0; i < this.ketjujenKoot.length; i++) {
            koot.append(String.format("%4d", this.ketjujenKoot[i]));
            if (i % (this.laudanKoko + 2) == laudanKoko + 1) {
                koot.append("\n");
            }
        }
        return koot.toString();
    }

    /**
     * Palauttaa testauksen kannalta havainnollisen 2D -merkkijonoesityksen siitä,
     * mihin ketjuun kukin pelilaudan monikulmio kuuluu.
     *
     * @return union find -ketjut
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.ketjut.length; i++) {
            str.append(String.format("%4d", this.ketjut[i]));
            if (i % (this.laudanKoko + 2) == laudanKoko + 1) {
                str.append("\n");
            }
        }
        return str.toString();
    }
}
