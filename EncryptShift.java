
/**
 * Write a description of class EncryptShift here.
 * 
 * @author Nathan Stark 
 * @version Final Project CS 162
 */
public class EncryptShift extends Encrypt
{

    /**
     * Create a new Encryption with a given name.
     */
    public EncryptShift()
    {
    }

    /**
     * Apply this encryption.
     * 
     * @param  text  The String to be altered by ththe encryption.
     */
    public String apply(String encrypText)
    {

        text = encrypText.toLowerCase().replace('a','b').replace('c','d').replace('e','f').replace('g','h').replace('i','j').
        replace('k','l').replace('m','n').replace('o','p').replace('q','r').replace('s','t').
        replace('u','v').replace('w','x').replace('y','z');

        return text;

    }

}
