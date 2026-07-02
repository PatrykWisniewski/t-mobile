package com.tmobile.steps;

import io.cucumber.java.pl.Kiedy;
import io.cucumber.java.pl.Wtedy;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class NbpApiSteps {

    private List<Map<String, Object>> ratesList;

    @Kiedy("Użytkownik pobiera aktualną tabelę kursów A z NBP API")
    public void fetchExchangeRates() {

        Response response = RestAssured
                .given()
                .baseUri("http://api.nbp.pl/api")
                .header("Accept", "application/json")
                .when()
                .get("/exchangerates/tables/A");


        System.out.println("Status code: " + response.getStatusCode());

        ratesList = response.jsonPath().getList("[0].rates");
        System.out.println("Pobrano: " + ratesList.size() + " kursów walut.");
    }

    @Wtedy("Wyświetl kurs dla waluty o kodzie: {string}")
    public void displayRateCodes(String currencyCode) {
        System.out.println("\nSzukanie kursu dla kodu waluty: " + currencyCode);

        for (Map<String, Object> rate : ratesList) {
            if (rate.get("code").toString().equalsIgnoreCase(currencyCode)) {
                System.out.println("Kurs dla " + currencyCode + " wynosi: " + rate.get("mid"));
                return;
            }
        }
        System.out.println("Nie znaleziono waluty o kodzie: " + currencyCode);
    }

    @Wtedy("Wyświetl kurs dla waluty o nazwie: {string}")
    public void displayRateNames(String currencyName) {
        System.out.println("\nSzukanie kursu dla nazwy waluty: " + currencyName);

        for (Map<String, Object> rate : ratesList) {
            if (rate.get("currency").toString().equalsIgnoreCase(currencyName)) {
                System.out.println("Kurs dla '" + currencyName + "' wynosi: " + rate.get("mid"));
                return;
            }
        }
        System.out.println("Nie znaleziono waluty o nazwie " + currencyName);
    }

    @Wtedy("Wyświetl waluty o kursie powyżej: {int}")
    public void displayRatesAboveLimit(int limit) {
        System.out.println("\nWaluty o kursie powyżej " + limit + ":");

        for (Map<String, Object> rate : ratesList) {
            double mid = Double.parseDouble(rate.get("mid").toString());
            if (mid > limit) {
                System.out.println("  - " + rate.get("currency") + " (" + rate.get("code") + "): " + mid);
            }
        }
    }

    @Wtedy("Wyświetl waluty o kursie poniżej: {int}")
    public void displayRatesBelowLimit(int limit) {
        System.out.println("\nWaluty o kursie poniżej " + limit + ":");

        for (Map<String, Object> rate : ratesList) {
            double mid = Double.parseDouble(rate.get("mid").toString());
            if (mid < limit) {
                System.out.println("  - " + rate.get("currency") + " (" + rate.get("code") + "): " + mid);
            }
        }
    }
}
