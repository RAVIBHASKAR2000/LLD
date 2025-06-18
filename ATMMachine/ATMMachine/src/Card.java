
import  java.util.*;

import java.time.LocalDate;

public  class Card {
    String id;
    String accountId;
    String cardNumber;
    String pin; // encrypted
    LocalDate expiryDate;

    public boolean validateCard(String inputPin) {
        // In real system, decrypt and compare
        return this.pin.equals(inputPin);
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
}