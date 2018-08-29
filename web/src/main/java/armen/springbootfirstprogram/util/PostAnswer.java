package armen.springbootfirstprogram.util;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostAnswer {
    // == field ==

    private String message;
    private int yourBalance;
    private int yourWinBalance;
    private int compValue;
    private int yourValue;

    public PostAnswer(String message, int yourBalance, int yourWinBalance, int compValue, int yourValue) {
        this.message = message;
        this.yourBalance = yourBalance;
        this.yourWinBalance = yourWinBalance;
        this.compValue = compValue;
        this.yourValue = yourValue;
    }
}
