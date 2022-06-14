package com.exceptions;
import java.util.List;
import java.util.Random;

public class Module {
    public static List<String> SUPPORTED_CURRENCIES = List.of("USD", "EUR", "JPY", "CHF");


    public String processPayment(int paymentAmount, String currency, String clientID)
            throws InvalidPaymentCurrencyException, InvalidPaymentAmountException, BankProcessingFailedException {

        if (!SUPPORTED_CURRENCIES.contains(currency)) {
            throw new InvalidPaymentCurrencyException(String.format("Currency %s not supported", currency));
        }

        if (paymentAmount <= 0) {
            throw new InvalidPaymentAmountException("Negative or zero payment amount");
        }

        return requestBankProcessing(paymentAmount);

    }

    public static String requestBankProcessing(int paymentAmount) throws BankProcessingFailedException {
        // Some bank communication magic here
        Random random = new Random();
        int statusCode = random.nextInt(10);
        if (statusCode > 5) {
            throw new BankProcessingFailedException(String.format("Bank returned result code %s", statusCode));
        }
        return "trx_4knfsf4gs412355";
    }

    public static void main(String[] args) throws BankProcessingFailedException {
        System.out.println("\nBankProcessing1: Please input paymentAmount 20");
        System.out.println("BankProcessing1 is started.");
        try {
            requestBankProcessing(20);
            System.out.println("BankProcessing1 already finished.");
            System.out.println("ProcessPayment1 is absent.");
        } catch (BankProcessingFailedException e1) {
            System.out.println("RequestBankProcessing1 failed. Exception1: " + e1.getMessage());
        }

    }
}
