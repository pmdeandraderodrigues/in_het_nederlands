Het probleem:
"Stel, je woont in een straat waar de huizen in één lange rij staan. Ze hebben allemaal aaneengesloten,
oplopende huisnummers. Beginnende bij het eerste huis met nummer 1, dan nummer 2, loop dit zo op tot
het laatste huis. Je besluit een wandeling te gaan maken vanuit jouw huis (ergens in die rij met huizen)
richting het eerste huis met nummer 1. Ondertussen tek je de huisnummers van de huizen die je ziet
bij elkaar op, zonder je eigen huisnummer mee te tellen.
De volgende dag doe je hetzelfde, maar nu richting het laatste huis in de straat. Opnieuw wandel je
langs de huizen en tel je de huisnummers die je ziet bij elkaar op. En warempel: het resultaat is 
hetzelfde als de optelsom van gister! Dat kan geen toevaal zijn. Meteen besluit je dat al jouw toekomstige
huizen aan dezelfde conditie moeten voldoen als je huidige huis. Dat betekent natuurlijk wel dat je
voor iedere verhuizing goed moet uitkijken. Op welk huisnummer moet je gaan wonen? En welk nummer moet
het laatste huis in de straat hebben, zodat het aan het bovenstaande scenario voldoet?
(...)
Je algoritme moet minimaal de eerste twintig paren eigen huisnummer/laatste huisnummer in de straat 
genereren." (bron: Java Magazine, juli/augustus 2014)

De oplossing:
De reeks van huisnummers van (1) tot en met (huisnummer-1) zijn niks minder dan de eerste (huisnummer-1) 
termen van een rekenkundige rij die met 1 begint en waar elk nieuwe term resulteert van het optellen 
van 1 aan de vorige term. Een rekenkundige rij is een al eeuwen bekend concept in de wiskunde. Het is dus
niet verbazingwekkend dat er ooit iemand een formule vastgelegd heeft die het makkelijker maakt om deze 
optelsom te berekenen. In plaats van één per één de termen op te tellen kunnen we dus gebruik maken van 
deze formule (zie: http://nl.wikipedia.org/wiki/Rekenkundige_rij). De formule geeft aan dat de optelsom 
van de eerste (n) termen van de reeks 1, 2, 3, ..., huisnummer-1 is de eerste term (1) plus de laatste 
(huisnummer-1), dit gedeeld door 2 en keer het aantal termen (huisnummer-1). In wiskundige termen:
(1 + huisnummer - 1) / 2 * (huisnummer - 1). 
Dezelfde formule kan toegepast worden aan de reeks huizen van (huisnummer+1) tot en met (laatste huisnummer).
Het resultaat is: (huisnummer+1 + laatste_huisnummer) / 2 * (laatste_huisnummer - huisnummer).

We zijn op zoek naar combinaties huisnummer / laatste_huisnummer waar het resultaat van de eerste formule
(de optelsom van de huisnummers tot het huisnummer) en het resultaat van de tweede formule (de optelsom van 
de huisnummers na huisnummer) gelijk zijn:
(1 + huisnummer - 1) / 2 * (huisnummer - 1) = (huisnummer+1 + laatste_huisnummer) / 2 * (laatste_huisnummer - huisnummer)

We kunnen deze vergelijking versimpelen in een aantal stappen met toepassing van wat wiskunde. Hier volgen die:

(1 + huisnummer - 1) / 2 * (huisnummer - 1) = (huisnummer+1 + laatste_huisnummer) / 2 * (laatste_huisnummer - huisnummer) <=>
(huisnummer) / 2 * (huisnummer - 1) = (huisnummer+1 + laatste_huisnummer) / 2 * (laatste_huisnummer - huisnummer) <=>
(huisnummerˆ2 - huisnummer) / 2 = (huisnummer+1 + laatste_huisnummer) / 2 * (laatste_huisnummer - huisnummer) <=>
(huisnummerˆ2 - huisnummer) / 2 = ((huisnummer+1) * (laatste_huisnummer - huisnummer) + laatste_huisnummer * (laatste_huisnummer - huisnummer)) / 2 <=>
(huisnummerˆ2 - huisnummer) / 2 = ((huisnummer * laatste_huisnummer - huisnummerˆ2 + laatste_huisnummer - huisnummer) + (laatste_huisnummerˆ2 - huisnummer * laatste_huisnummer)) / 2 <=>
huisnummerˆ2 - huisnummer = huisnummer * laatste_huisnummer - huisnummerˆ2 + laatste_huisnummer - huisnummer + laatste_huisnummerˆ2 - huisnummer * laatste_huisnummer <=>
huisnummerˆ2 = huisnummer * laatste_huisnummer - huisnummerˆ2 + laatste_huisnummer + laatste_huisnummerˆ2 - huisnummer * laatste_huisnummer <=>
0 = huisnummer * laatste_huisnummer - 2 * huisnummerˆ2 + laatste_huisnummer + laatste_huisnummerˆ2 - huisnummer * laatste_huisnummer <=>
0 = - 2 * huisnummerˆ2 + laatste_huisnummer + laatste_huisnummerˆ2 <=>
laatste_huisnummerˆ2 + laatste_huisnummer - 2 * huisnummerˆ2 = 0 <=>
laatste_huisnummer = (-1 +/- wortel_van(1ˆ2 - 4 * 1 * (-2 * huisnummerˆ2))) / 2 <=>
laatste_huisnummer = (-1 +/- wortel_van(1 + 8 * huisnummerˆ2)) / 2

Aangezien het huisnummer van een huis altijd een positief getal is, hebben we:
laatste_huisnummer = (-1 + wortel_van(1 + 8 * huisnummerˆ2)) / 2

Hoe kunnen we dan de oplossing berekenen?
We gaan één per één getalen in de reeks 1, 2, 3, ... toekennen aan huisnummer. Voor elk van deze berekenen we de 
waarde van laatste_huisnummer aan de hand van de versimpelde formule. Als de waarde die we krijgen een natuurlijk 
getal is, dus geen getal met decimalen plekken, hebben we een oplossing gevonden. Als we op dezelfde wijze door 
blijven gaan, zullen we veel meer oplossingen vinden. 
Deze algoritme is één op één vertaald naar een oplossing in Java.
   
Welke output produceert de code?
- Per rij wordt een oplossing getoond met het nummer van de oplossing, het huisnummer en het laatste huisnummer. 
  Hieronder zijn de eerste twintig oplossingen die de code heeft geproduceerd: 

1: 1 1
2: 6 8
3: 35 49
4: 204 288
5: 1189 1681
6: 6930 9800
7: 40391 57121
8: 235416 332928
9: 1372105 1940449
10: 7997214 11309768
11: 46611179 65918161
12: 85225144 120526554
13: 101219572 143146091
14: 139833537 197754484
15: 178447502 252362877
16: 194441930 274982414
17: 210436358 297601951
18: 217061467 306971270
19: 233055895 329590807
20: 255675432 361579663  

Om de code meer oplossingen te laten genereren is het een kwestie van de waarde van de constante MAX_AANTAL_GEWENSTE_OPLOSSINGEN
aan te passen.


Wat heb ik nodig op mijn machine om de code uit te voeren?
- Maven 3 en Java 8 

Hoe build ik de code?
- Open een command prompt (op windows) of een terminal (op linux/Mac OS) 
  en ga naar de folder waar het bestand pom.xml te vinden is. 
  Voer dan het volgende commando:
  mvn clean install

Hoe kan ik de code uitvoeren en de oplossingen van het probleem zien?
- Voer nu het volgende commando uit in de command prompt / terminal:
  mvn exec:java