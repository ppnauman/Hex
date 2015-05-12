# Hex -peli

Hex on matemaatikko Piet Heinin kehittämä strateginen lautapeli, jota pelataan tavallisesti 11x11 kokoisella, kuusikulmioista muodostuvalla pelilaudalla. Pelaajat lisäävät laudalle vuorotellen omalla värillä merkittyjä  kuusikulmioita ja pyrkivät yhdistämään laudan vastakkaiset reunat kuusikulmioillaan. 

Lisätietoja http://en.wikipedia.org/wiki/Hex_%28board_game%29

##Pelaajat

Peliin osallistuu kaksi pelaajaa.

##Pelaajien toiminnot

	* lue peliohjeet
	* syötä käyttäjänimi
	* valitse väri
	* aseta kuusiokulmio laudalle (omalla vuorolla)

##Järjestelmän toiminnot

	* logiikka pitää kirjaa pelitilanteesta ja vuoroista
	* julistaa pelin voittajan (union-find tietorakenne)
	* graafinen käyttöliittymä piirtää pelilaudan
	* valvo sääntöjen noudattamista

##Mahdollisia aiheen laajennuksia

	* pelimahdollisuus tekoälyä vastaan (mahdollisesti eri vaikeustasoja)
	* pelaajatilastot nimen perusteella (tiedostossa)
	* mahdollisuus pelata erikokoisilla pelilaudoilla


