
/**
 * Write a description of class BetterShiftEncrypt here.
 * 
 * @author Nathan Stark
 * @version For fun version 1.
 */
public class BetterShiftEncrypt extends Encrypt
{
    /**
     * Constructor for objects of class BetterShiftEncrypt
     */
    public BetterShiftEncrypt()
    {
    }

    /**
     * Apply this encryption.
     * 
     * @param  text  The String to be altered by ththe encryption.
     */
    public String apply(String encrypText)
    {
        StringBuilder changed;
        StringBuilder unchanged;

        unchanged = new StringBuilder(encrypText);
        changed = new StringBuilder(encrypText);

        int t = unchanged.length() - 1;

        for(int i = 0;i < t;i++){
            changed.setCharAt(i,unchanged.charAt(t-i));
        }

        text = changed.substring(0,t + 1);
        return text;

    }

}
