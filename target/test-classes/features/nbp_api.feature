# language: pl
Funkcja: Testowanie API Narodowego Banku Polskiego

  @api
  Scenariusz: Kursy walut
    Kiedy Użytkownik pobiera aktualną tabelę kursów A z NBP API
    Wtedy Wyświetl kurs dla waluty o kodzie: "USD"
    I Wyświetl kurs dla waluty o nazwie: "dolar amerykański"
    I Wyświetl waluty o kursie powyżej: 5
    I Wyświetl waluty o kursie poniżej: 3