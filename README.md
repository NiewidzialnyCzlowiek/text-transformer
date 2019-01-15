# Text transformer

![Build Status](https://travis-ci.org/NiewidzialnyCzlowiek/text-transformer.svg?branch=master)
![Semver](http://img.shields.io/SemVer/1.2.0.png)

[Documentation](https://niewidzialnyczlowiek.github.io/text-transformer/)



This is a university project for Software Engineering classes. The project consists of a server application written in Java and a web client. The server application is a RESTful API. More information about specifics of the API requests are included in [API.md file](API.md).


# Running the project
1. `git pull https://github.com/NiewidzialnyCzlowiek/text-transformer`
2. `cd text-transformer`
3. `mvn clean install && java -jar target/text-transformer-1.2.0.jar`
4. `cd web-client`
5. open `index.html` with double click in web browser

# Podsumowanie sprintu 3
1. Rejestr sprintu 3 znajduje się tutaj: https://github.com/NiewidzialnyCzlowiek/text-transformer/projects/3
2. Testy z mockami znajdują się w folderze `test/groovy/`. Zostały wykonane z wykorzystaniem biblioteki `Spock` która umożliwia
łatwe testowanie behawioralne oraz zapewnia interfejs do obsługi mocków.
3. Proces uruchomienia aplikacji znajduje się w sekcji **Running the project**.
4. Aplikacja obsługuje teraz dwa nowe rodzaje transformacji: To Code, która zamienia znaki w tekście na ich kody w kodowaniu UTF-8, oraz Word Reverse, która odwraca kolejność liter w poszczególnych słowach, zachowawszy kolejność samych słów.
5. Wprowadzono następujące usprawnienia po stronie frontendu: dodano przycisk automatycznego kopiowania wyniku transformacji do schowka; dodano opisy transformacji; umożliwiono wybór losowej transformacji z listy
6. Zdefiniowano cele pomiarowe związane z jakością oprogramowania zgodnie z GQM. Pomiar wybranych metryk znajduje się w [pliku](https://github.com/NiewidzialnyCzlowiek/text-transformer/blob/master/Pomiar%20jakos%CC%81ci%20oprogramowania.pdf)
7. Przeprowadzono 3 testy za pomocą narzędzia JMetrics. Pliki związane z testami znajdują się w [tym folderze](https://github.com/NiewidzialnyCzlowiek/text-transformer/tree/master/JMeter%20testing)

## Testy JMetrics
### test 1 - 10 wątków, zastosowane wszystkie rodzaje transformacji
  * [summary report](https://github.com/NiewidzialnyCzlowiek/text-transformer/blob/master/JMeter%20testing/test1-report.xlsx)
  ![test1 response time](https://github.com/NiewidzialnyCzlowiek/text-transformer/blob/master/JMeter%20testing/test1-resp-time.png)
  ![test1 response vs threads](https://github.com/NiewidzialnyCzlowiek/text-transformer/blob/master/JMeter%20testing/test1-resp-vs-thr.png)
  ![test1 transactions per second](https://github.com/NiewidzialnyCzlowiek/text-transformer/blob/master/JMeter%20testing/test1-trans-per-sec.png)
### test 2 - 2000 wątków, z opóźnieniem
  * [summary report](https://github.com/NiewidzialnyCzlowiek/text-transformer/blob/master/JMeter%20testing/test2-report.xlsx)
  ![test2 response time](https://github.com/NiewidzialnyCzlowiek/text-transformer/blob/master/JMeter%20testing/test2-resp-time.png)
  ![test2 response vs threads](https://github.com/NiewidzialnyCzlowiek/text-transformer/blob/master/JMeter%20testing/test2-resp-vs-thr.png)
 ![test2 transactions per second](https://github.com/NiewidzialnyCzlowiek/text-transformer/blob/master/JMeter%20testing/test2-trans-per-sec.png)
### test 3 - 2000 wątków, bez opóźnienia
  * [summary report](https://github.com/NiewidzialnyCzlowiek/text-transformer/blob/master/JMeter%20testing/test3-report.xlsx)
  ![test3 response time](https://github.com/NiewidzialnyCzlowiek/text-transformer/blob/master/JMeter%20testing/test3-resp-time.png)
  ![test3 response vs threads](https://github.com/NiewidzialnyCzlowiek/text-transformer/blob/master/JMeter%20testing/test3-resp-vs-thr.png)
  ![test3 transactions per second](https://github.com/NiewidzialnyCzlowiek/text-transformer/blob/master/JMeter%20testing/test3-trans-per-sec.png)
