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


    }
}
