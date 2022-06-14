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
        System.out.println("BankProcessing1 is started with correct paymentAmount, without currency walue.");
        try {
            requestBankProcessing(20);
            System.out.println("BankProcessing1 already finished.");
        } catch (BankProcessingFailedException e1) {
            System.out.println("BankProcessing1 failed. Exception1: " + e1.getMessage());
        }
        System.out.println("\nBankProcessing2: Please input paymentAmount -1");
        System.out.println("BankProcessing1 is started with wrong paymentAmount, without currency walue.");
        try {
            requestBankProcessing(-1);
            System.out.println("BankProcessing2 already finished.");
        } catch (BankProcessingFailedException e2) {
            System.out.println("BankProcessing2 failed. Exception2: Connection with bank is interrupted. " + e2.getMessage());
        }
        System.out.println("\nBankProcessing3: Please input paymentAmount 300 USA, clientID:1");
        System.out.println("BankProcessing3 is started with wrong currency value.");
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
        System.out.println("\nBankProcessing4: Please input paymentAmount -20 JPY");
        System.out.println("BankProcessing4 is started with negative payment amount.");
        try {
            requestBankProcessing(-20);
            System.out.println("BankProcessing4 was successful. ProcessPayment3 is started.");
            processPayment(-20, "JPY", "834");
            System.out.println("ProcessPayment3 was Successfull");
        } catch (BankProcessingFailedException e1) {
            System.out.println("BankProcessing4 failed. Exception1: " + e1.getMessage());
        } catch (InvalidPaymentAmountException e5) {
            System.out.println("ProcessPayment3 failed. Exception5: " + e5.getMessage());
        }
        System.out.println("\nBankProcessing5: Please input paymentAmount 0 EUR");
        System.out.println("BankProcessing5 is started with zero payment amount.");
        try {
            requestBankProcessing(0);
            System.out.println("BankProcessing5 was successful. ProcessPayment4 is started.");
            processPayment(0, "EUR", "834");
            System.out.println("ProcessPayment5 was Successfull");
        } catch (InvalidPaymentAmountException e7) {
            System.out.println("ProcessPayment4 failed. Exception7: " + e7.getMessage());
        } catch (BankProcessingFailedException e8) {
            System.out.println("ProcessPayment4 failed. Exception8: " + e8.getMessage());
        }
        System.out.println("\nBankProcessing6: Please input paymentAmount 100 CHF");
        System.out.println("BankProcessing6 starts with correct parameter values.");
        try {
            requestBankProcessing(100);
            System.out.println("BankProcessing6 was successful. ProcessPayment6 is started.");
            processPayment(100, "CHF", "153");
            System.out.println("Your processPayment6 was Successfull");
        } catch (BankProcessingFailedException e1) {
            System.out.println("ProcessPayment6 failed. Exception2: Connection with bank has interrupted. " + e1.getMessage());
        }
    }
}
