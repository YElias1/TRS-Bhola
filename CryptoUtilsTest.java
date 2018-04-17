package Crypto;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;


public class CryptoUtilsTest {
	public static void main(String[] args) {
	    String key = "Rehan is Batman."; //Phrase to encrypt file. Must be 16 bits.
		File inputFile = new File("document.txt"); //Path of file name
		File encryptedFile = new File("document.encrypted");//Path of where encrypted file will be created
   		File decryptedFile = new File("document.decrypted");//Path of where decrypted file will be created

   		encrypt(key,inputFile,encryptedFile); //encrypys input file
        //delete(inputFile);                    // delete input file
        decrypt(key,encryptedFile,decryptedFile); //decrypts encrypted
        //delete(encryptedFile);                    //delete encrypted

	}

	public static void encrypt(String key, File inputFile, File encryptedFile ){
        try {
            CryptoUtils.encrypt(key, inputFile, encryptedFile);

        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void decrypt(String key, File encryptedFile , File decryptedFile ){
        try {
            CryptoUtils.decrypt(key, encryptedFile, decryptedFile);

        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }




	public static void delete(File path){

	    try
    {
        Files.deleteIfExists(Paths.get(String.valueOf(path)));
    }
        catch(NoSuchFileException e)
    {
        System.out.println("No such file/directory exists");
    }
        catch(DirectoryNotEmptyException e)
    {
        System.out.println("Directory is not empty.");
    }
        catch(IOException e)
    {
        System.out.println("Invalid permissions.");
    }

        System.out.println("Deletion successful.");
    }

}
