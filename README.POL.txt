1) Opis programu
Aplikacja będzie umożliwiała segregowanie plików. Program tworzy strukturę katalogów:
- HOME
- DEV
- TEST

W momencie pojawienia się w katalogu HOME pliku w zależności od rozszerzenia przeniesie go do folderu wg następujących reguł
- plik z rozszerzeniem .jar, którego godzina utworzenia jest parzysta przenosimy do folderu DEV
- plik z rozszerzeniem .jar, którego godzina utworzenia jest nieparzysta przenosimy do folderu TEST
- plik z rozszerzeniem .xml, przenosimy do folderu DEV

Dodatkowo w nowo stworzonym pliku /home/count.txt przechowywana jest liczba przeniesionych plików (wszystkich i w podziale na
katalogi), plik przechowuje aktualną liczbę przetworzonych plików.


2) Jak uruchomić program
- Należy komendą "cd" w programie CMD przejść do katalogu zawierającego plik "pom.xml". 
- Musimy wpierw mieć skonfigurowane środowisko Maven oraz Java JDK
- By uruchomić program należy wpisać w CMD "java \src\main\java\Main.java"

Katalogiem startowym jest "C:\" w którym automatycznie tworzony jest folder "BASE_FOLDER" a w nim prowadzone są operacje opisane w ćwiczeniu.
