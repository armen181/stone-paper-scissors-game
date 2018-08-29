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

    public PostAnswer(String message, int yourBalance, int yourWinBalance) {
        this.message = message;
        this.yourBalance = yourBalance;
        this.yourWinBalance = yourWinBalance;
    }
}
