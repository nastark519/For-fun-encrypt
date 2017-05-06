/**
 * Abstract class Encrypt - the Encrypt class will work similarly 
 * to the abstract class Filter in the imageviewer_final found in chapter 11.
 * That is that Encrypt provides a basic construct for other Encryption types.
 * 
 * @author Nathan Stark
 * @version Final Project CS 162
 */
public abstract class Encrypt
{
    protected String text;

    /**
     * Create a new Encryption with a given name.
     */
    public Encrypt()
    {
        
    }
    
    /**
     * Apply this encryption.
     * 
     * @param  text  The String to be altered by the encryption.
     */
    public abstract String apply(String encrypText);
}
