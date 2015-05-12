# Hex -peli

Hex on matemaatikko Piet Heinin kehittämä kahden pelaajan strateginen lautapeli, jota pelataan kuusikulmioista muodostuvalla pelilaudalla. Kumpikin pelaaja lisää vuorollaan pelilaudalle pelaajan värillä merkityn kuusikulmion. Pelin voittaja on pelaaja, joka ensimmäisenä yhdistää pelilaudan vastakkaiset sivut kuusikulmioidensa välityksellä  toisiinsa.  

Lisätietoja pelistä http://en.wikipedia.org/wiki/Hex_%28board_game%29

Harjoitustyössä toteutetaan yksinkertainen 11x11 laudalla pelattava kahden pelaajan Hex mahdollisine laajennuksineen (kts. alla).

##Pelaajat

Peliin osallistuu kaksi pelaajaa.

##Pelaajien toiminnot

	* lue peliohjeet
	* syötä käyttäjänimi
	* valitse väri
	* aseta kuusiokulmio laudalle omalla vuorolla
	* (tarkastele pelaajakohtaisia tilastoja)

##Järjestelmän toiminnot

	* logiikka pitää kirjaa pelitilanteesta ja vuoroista
	* julistaa pelin voittajan (union-find tietorakenne)
	* graafinen käyttöliittymä piirtää pelilaudan
	* valvoo sääntöjen noudattamista

##Mahdollisia aiheen laajennuksia

	* pelimahdollisuus tekoälyä vastaan (mahdollisesti eri vaikeustasoja)
	* pelaajatilastot nimen perusteella (tiedostossa)
	* mahdollisuus pelata erikokoisilla pelilaudoilla


