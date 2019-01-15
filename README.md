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
