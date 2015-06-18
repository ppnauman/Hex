##Hex -peli
Hex on Piet Heinin ja John Nashin kehittämä kahden pelaajan strateginen lautapeli, jota pelataan kuusikulmioista muodostuvalla pelilaudalla. Kumpikin pelaaja lisää vuorollaan pelilaudalle pelaajan värillä merkityn kuusikulmion. Pelin voittaja on pelaaja, joka ensimmäisenä yhdistää pelilaudan vastakkaiset sivut kuusikulmioidensa välityksellä toisiinsa.

Lisätietoja pelistä http://en.wikipedia.org/wiki/Hex_%28board_game%29

Harjoitustyössä toteutetaan yksinkertainen 11x11 laudalla pelattava kahden pelaajan Hex mahdollisine laajennuksineen (kts. alla).

###Pelaajat

Peliin osallistuu kaksi pelaajaa.

###Pelaajien toiminnot

* lue peliohjeet
* syötä käyttäjänimi
* valitse väri
* aseta kuusiokulmio laudalle omalla vuorolla
* aloita uusi peli tai lopeta pelaaminen

###Järjestelmän toiminnot

* logiikka pitää kirjaa pelitilanteesta ja vuoroista
* julistaa pelin voittajan (union-find tietorakenne)
* graafinen käyttöliittymä piirtää pelilaudan
* valvoo sääntöjen noudattamista

###Aiheen jatkokehitysmahdollisuuksia

* pelimahdollisuus tekoälyä vastaan (mahdollisesti eri vaikeustasoja)
* pelaajatilastot nimen perusteella (tiedostossa)
* mahdollisuus pelata erikokoisilla pelilaudoilla. nyt pelilaudan
 kokoa ei ole 'kovakoodattu' eli olisi mahdollista valita erikokoinen
 lauta, mikäli käyttöliittymään tehtäisi tätä varten valikko/ComboBox
 ja varmistettaisi, että piirtyvä pelilauta ei ylitä näytön kokoa.


##Ohjelman rakenne

###Pelilogiikka/rakenne

Luokka Pelilauta.java ylläpitää tietoa tilanteesta pelilaudalla. Pelilauta
koostuu Monikulmioista (Monikulmio.java), jotka voivat olla Kuusikulmioita
(Kuusikulmio.java) tai niitä reunustavia viisikulmioita (Viisikulmio.java).

Pelillä on aina kaksi pelaajaa (Pelaaja.java), joilla on nimi ja väri,
jolla he pelaavat. Pelilauta tuntee monikulmioidensa lisäksi pelaajien
käyttämät värit.

Pelin ratkeamista tarkkailee luokka Tarkastaja.java.
Tarkastaja pitää sisällääm union find-tietorakenteen, jossa yksiulotteisen
taulukon paikat vastaavat pelilaudan Monikulmioita siten, että pelilaudan
vasemmassa yläkulmassa olevan ruudun indeksi on 0 ja siitä eteenpäin indeksi
kasvaa mentäessä oikealle, rivi kerrallaan. Lähtötilanteessa jokainen
pelilaudan ruutu kuuluu omaan monikulmioiden 'ketjuun'. Kun laudalle asetetaan
vierekkäsiin ruutuihin samanvärisiä kuusikulmioita, Tarkastaja liittää
kyseiset ruudut samaan 'ketjuun'. Mikäli laudan vastakkaisilla reunoilla
olevat viisikulmiot kuuluvat samaan ketjuun, on peli ratkennut.

Luokka Peli.java koordinoi peliä. Se on ns. fasaadi -luokka ja toteuttaa
pelin käyttöliittymälle näkyvän rajapinnan (Hex-rajapinta). Peli.java ei ole
tarkoituksellisti kovin itsenäinen olio, vaan se hyödyntää Pelilautaa
ja Tarkastajaa luoden mahdollisimman yksinkertaisen rajapinnan käyttöliittymän
ja logiikan välille. Näin käyttöliittymää on mahdollista vaihtaa melko
yksinkertaisesti käyttäen rajapinnan metodeja, jolloin logiikkaan ei tarvitse
tehdä muutoksia. Vastaavasti käyttöliittymää ei tarvitse muuttaa logiikkaa
muutettaessa, mikäli pidetään huolta, että logiikkaolio toteuttaa
HexPinta -rajapinnan.

###Käyttöliittymä/rakenne

Graafisessa käyttöliittymässä on kolme päänäkymää. PeliAlkaa.java on
käyttäjälle ensimmäisenä avautuva ikkuna, jossa annetaan pelaajien nimet
ja valitaan värit. PelaaNapinKunntelija.java on tähän näkymään liittyvä
tapahtumankuuntelija, joka käynnistää pelin ja luo itse peli-ikkunan
(Kayttoliittyma.java). Myös VarikentanKuuntelija.java ja TektiKentanRajoitin.
java liittyvät tämän näkymän toimintaan.

Kayttoliittyma-näkymä piirtää KuusikRuutu -olioista koostuvan pelilaudan.
Ruudut ovat jatkettuja JButton-olioita, jotka on aseteltu kehykseen
absoluuttisella asettelulla. Käyttöliittymän peliruutuja kuuntelevat
tapahtumankuuntelijat (KuusikRuudunKuuntelija.java) hoitavat kuusikulmioiden
asettamisen ja pelitilanteen tarkkailun kommunikoiden pelilogiikan kanssa
tuntemansa rajapintaolion välityksellä.

Pelin ratkettua avautuu PeliPaattynyt.java luokan kuvaama näkymä,
jossa pelaajat voivat valita uuden pelin tai lopettaa pelaamisen. Näitä
toimintoja varten ovat kuuntelijaluokat UudelleenNapinKuuntelija.java ja
LopetusNapinKuuntelija.java. 
