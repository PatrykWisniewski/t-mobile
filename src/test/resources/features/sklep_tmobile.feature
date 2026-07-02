# language: pl
Funkcja: Wybranie telefonu z listy ofert

  @tmobile
  Scenariusz: Wybranie telefonu z listy ofert
    Kiedy Użytkownik przechodzi na stronę "https://www.t-mobile.pl/"
    Wtedy Strona główna jest widoczna

    Kiedy Z górnej belki użytkownik wybiera "Sklep"
    Wtedy Widoczna jest rozwijana lista menu

    Kiedy Użytkownik klika "Bez abonamentu" z sekcji "Smartfony"
    Wtedy Widoczna jest lista smartfonów

    Kiedy Użytkownik klika element z listy o nazwie "Samsung Galaxy S26 5G"
    Wtedy Widoczna jest strona produktu

    Kiedy Użytkownik klika "Dodaj do koszyka"
    Wtedy Widoczna jest strona koszyka, a cena zgadza się z ceną z produktu

    Kiedy Użytkownik przechodzi z powrotem na stronę główną T-Mobile
    Wtedy Użytkownik wraca na stronę główną

    Kiedy Użytkownik klika "Koszyk"
    Wtedy Widoczna jest strona koszyka, a koszyk zawiera dodane urządzenie