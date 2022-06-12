package exceptions;

import java.util.List;
import java.util.Random;

public class Module {
    public static List<String> SUPPORTED_CURRENCIES = List.of("USD", "EUR", "JPY", "CHF");


    public static String processPayment(int paymentAmount, String currency, String clientID) throws exceptions.InvalidPaymentCurrencyException, exceptions.InvalidPaymentAmountException, exceptions.BankProcessingFailedException {

        if (!SUPPORTED_CURRENCIES.contains(currency)) {
            throw new InvalidPaymentCurrencyException(String.format("Currency %s is not supported", currency));
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
            throw new BankProcessingFailedException("Process payment error. Wrong clientID. Try another one.");
        }
        return "trx_4knfsf4gs412355";
    }

    public static void main(String[] args) throws BankProcessingFailedException {
        System.out.println("Please input paymentAmount 20");
        try {
            requestBankProcessing(20);
            System.out.println("BankProcessing already finished.");
        } catch (BankProcessingFailedException e1) {
            System.out.println("Exception1 RequestBankProcessing failed: " + e1.getMessage());
        }
        //        System.out.println("Your BankProcessing already finished.");
        System.out.println("Please input paymentAmount -1");
        try {
            requestBankProcessing(-1);
            System.out.println("Process payment error.Wrong payment amount.");
        } catch (BankProcessingFailedException e2) {
            System.out.println("Exception2 requestBankProcessing failed: " + e2.getMessage());
        }
        System.out.println("Please input paymentAmount 300 USA, clientID:1");
        try {
            processPayment(300, "USA", "1");
            System.out.println("Your processPayment1 was Successfull");
        } catch (BankProcessingFailedException e3) {
            System.out.println("Exception3 requestBankProcessing failed: " + e3.getMessage());
        } catch (InvalidPaymentCurrencyException e4) {
            System.out.println("Exception4 requestBankProcessing failed: " + e4.getMessage());
        } catch (InvalidPaymentAmountException e5) {
            System.out.println("Process payment error.Wrong payment amount.");
        }
        System.out.println("Please input paymentAmount -20 JPY");
        try {
            processPayment(-20, "JPY", "834");
            System.out.println("Your processPayment2 was Successfull");
        } catch (InvalidPaymentAmountException e4) {
            System.out.println("Exception5 Invalid PaymentAmount: " + e4.getMessage());
        } catch (BankProcessingFailedException e5) {
            System.out.println("Exception6 requestBankProcessing failed: " + e5.getMessage());
        } catch (InvalidPaymentCurrencyException e) {
            e.printStackTrace();
        }
        System.out.println("Please input paymentAmount 0 EUR");
        try {
            processPayment(0, "EUR", "834");
            System.out.println("Your processPayment2 was Successfull");
        } catch (InvalidPaymentAmountException e6) {
            System.out.println("Exception6 Invalid PaymentAmount: " + e6.getMessage());
        } catch (BankProcessingFailedException e7) {
            System.out.println("Exception7 requestBankProcessing failed: " + e7.getMessage());
        } catch (InvalidPaymentCurrencyException e) {
            e.printStackTrace();
        }
        System.out.println("Please input paymentAmount 300 INR");
        try {
            processPayment(300, "INR", "753");
            System.out.println("Your processPayment3 was Successfull");
        } catch (BankProcessingFailedException e8) {
            System.out.println("Exception8 requestBankProcessing failed: " + e8.getMessage());
        } catch (InvalidPaymentCurrencyException e9) {
            System.out.println("Exception9 Invalid PaymentCurrency: " + e9.getMessage());
        } catch (InvalidPaymentAmountException e) {
            e.printStackTrace();
        }
    }
}
