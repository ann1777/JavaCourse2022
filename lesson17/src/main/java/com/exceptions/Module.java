package com.exceptions;
import java.util.List;
import java.util.Random;

public class Module {
    public static List<String> SUPPORTED_CURRENCIES = List.of("USD", "EUR", "JPY", "CHF");


    public static String processPayment(int paymentAmount, String currency, String clientID)
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

    public static void main(String[] args) throws BankProcessingFailedException, InvalidPaymentCurrencyException, InvalidPaymentAmountException {
        System.out.println("\nBankProcessing1: Please input paymentAmount 20");
        System.out.println("BankProcessing1 is started.");
        try {
            requestBankProcessing(20);
            System.out.println("BankProcessing1 already finished.");
        } catch (BankProcessingFailedException e1) {
            System.out.println("BankProcessing1 failed. Exception1: " + e1.getMessage());
        }
        System.out.println("\nBankProcessing2: Please input paymentAmount -1");
        System.out.println("Ooops. Wrong amount.");
        try {
            requestBankProcessing(-1);
        } catch (BankProcessingFailedException e2) {
            System.out.println("BankProcessing2 failed. Exception2: Connection with bank is interrupted. " + e2.getMessage());
        }
        System.out.println("\nBankProcessing3: Please input paymentAmount 300 USA, clientID:1");
        System.out.println("BankProcessing3 is started.");
        try {
            requestBankProcessing(300);
            System.out.println("BankProcessing3 was successful. ProcessPayment2 is started.");
            processPayment(300, "USA", "1");
            System.out.println("ProcessPayment3 was Successfull");
        } catch (BankProcessingFailedException e3) {
            System.out.println("BankProcessing3 failed. Exception2: Connection with bank has interrupted. " + e3.getMessage());
        } catch (InvalidPaymentCurrencyException e4) {
            System.out.println("ProcessPayment3 failed. Exception3: " + e4.getMessage());
        }

    }
}
