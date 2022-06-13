package exceptions;

import java.util.List;
import java.util.Random;

public class Module {
    public static List<String> SUPPORTED_CURRENCIES = List.of("USD", "EUR", "JPY", "CHF");


    public static String processPayment(int paymentAmount, String currency, String clientID) throws exceptions.InvalidPaymentCurrencyException, exceptions.InvalidPaymentAmountException, exceptions.BankProcessingFailedException {

        if (!SUPPORTED_CURRENCIES.contains(currency)) {
            throw new InvalidPaymentCurrencyException(String.format("Currency %s is not supported. Chose avaliable " +
                            "currency from the list.",
                    currency));
        }

        if (paymentAmount <= 0) {
            throw new InvalidPaymentAmountException("Opps. Negative or zero payment amount");
        }
        return requestBankProcessing(paymentAmount);

    }

    public static String requestBankProcessing(int paymentAmount) throws BankProcessingFailedException {
        // Some bank communication magic here
        Random random = new Random();
        int statusCode = random.nextInt(10);
        if (statusCode > 5) {
            throw new BankProcessingFailedException("Process payment error. Wrong clientID. Please try again later.");
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
//                System.out.println("Your BankProcessing already finished.");
//        System.out.println("Please input paymentAmount -1");
//        try {
//            requestBankProcessing(-1);
//            System.out.println("Process payment error.Wrong payment amount.");
//        } catch (BankProcessingFailedException e2) {
//            System.out.println("Exception2 requestBankProcessing failed: " + e2.getMessage());
//        }
        System.out.println("\nBankProcessing2: Please input paymentAmount 300 USA, clientID:1");
        System.out.println("BankProcessing2 is started.");
        try {
            requestBankProcessing(300);
            System.out.println("BankProcessing2 was successful. ProcessPayment2 is started.");
            processPayment(300, "USA", "1");
            System.out.println("ProcessPayment2 was Successfull");
        } catch (BankProcessingFailedException e1) {
            System.out.println("RequestBankProcessing2 failed. Exception1: " + e1.getMessage());
//        } catch (BankProcessingFailedException e2) {
//            System.out.println("ProcessPayment1 failed. Exception2: " + e2.getMessage());
        } catch (InvalidPaymentCurrencyException e3) {
            System.out.println("ProcessPayment2 failed. Exception3: " + e3.getMessage());
        } catch (InvalidPaymentAmountException e4) {
            System.out.println("ProcessPayment2 failed. Exception4: "+ e4.getMessage());
//                    Process payment exception. Wrong payment amount.");
        }
        System.out.println("\nBankProcessing3: Please input paymentAmount -20 JPY");
        System.out.println("BankProcessing3 is started.");
        try {
            requestBankProcessing(-20);
            System.out.println("BankProcessing3 was successful. ProcessPayment3 is started.");
            processPayment(-20, "JPY", "834");
            System.out.println("ProcessPayment3 was Successfull");
        } catch (BankProcessingFailedException e1) {
            System.out.println("RequestBankProcessing failed. Exception1: " + e1.getMessage());
        } catch (InvalidPaymentAmountException e5) {
            System.out.println("ProcessPayment3 failed. Exception5: " + e5.getMessage());
//        } catch (BankProcessingFailedException e6) {
//            System.out.println("ProcessPayment2 failed. Exception6: " + e6.getMessage());
        } catch (InvalidPaymentCurrencyException e) {
            e.printStackTrace();
        }
        System.out.println("\nBankProcessing4: Please input paymentAmount 0 EUR");
        System.out.println("BankProcessing4 is started.");
        try {
            requestBankProcessing(0);
            System.out.println("BankProcessing4 was successful. ProcessPayment4 is started.");
            processPayment(0, "EUR", "834");
            System.out.println("ProcessPayment4 was Successfull");
        } catch (InvalidPaymentAmountException e7) {
            System.out.println("ProcessPayment4 failed. Exception7: " + e7.getMessage());
        } catch (BankProcessingFailedException e8) {
            System.out.println("ProcessPayment4 failed. Exception8: " + e8.getMessage());
        } catch (InvalidPaymentCurrencyException e) {
            e.printStackTrace();
        }
        System.out.println("\nBankProcessing5: Please input paymentAmount 300 INR");
        System.out.println("BankProcessing5 is started.");
        try {
            requestBankProcessing(300);
            System.out.println("BankProcessing5 was successful. ProcessPayment5 is started.");
            processPayment(300, "INR", "753");
            System.out.println("Your processPayment5 was Successfull");
        } catch (BankProcessingFailedException e9) {
            System.out.println("ProcessPayment5 failed. Exception9: " + e9.getMessage());
        } catch (InvalidPaymentCurrencyException e10) {
            System.out.println("ProcessPayment5 failed. Exception10: " + e10.getMessage());
        } catch (InvalidPaymentAmountException e) {
            e.printStackTrace();
        }
        System.out.println("\nBankProcessing6: Please input paymentAmount 100 CHF");
        System.out.println("BankProcessing6 starts with correct parameter values.");
        try {
            requestBankProcessing(100);
            System.out.println("BankProcessing6 was successful. ProcessPayment6 is started.");
            processPayment(100, "CHF", "153");
            System.out.println("Your processPayment6 was Successfull");
        } catch (BankProcessingFailedException e11) {
            System.out.println("ProcessPayment6 failed. Exception11: " + e11.getMessage());
        } catch (InvalidPaymentCurrencyException e12) {
            System.out.println("ProcessPayment6 failed. Exception12: " + e12.getMessage());
        } catch (InvalidPaymentAmountException e) {
            e.printStackTrace();
        }
    }
}
