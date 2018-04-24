package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.Part;

/**
 * 
 * @author Yohan_Marie
 */

public class Upload {

    public static boolean upload(Part part, String repertoireDestination, String nomFichier) throws IOException{
        
        int read = 0;
        final byte[] BYTES = new byte[1024];
        final String PATH = repertoireDestination;

        OutputStream out = null;
        InputStream filecontent = null;

        try {
           
            // Crée le dossier de stockage s'il n'existe pas.
            
            File uploadFolder = new File(PATH);
            if(!uploadFolder.exists()){
                uploadFolder.mkdirs();
            }
            
            out = new FileOutputStream(new File(PATH + File.separator + nomFichier));
            filecontent = part.getInputStream();

            while ((read = filecontent.read(BYTES)) != -1) {
                out.write(BYTES, 0, read);
            }
      
        } catch (FileNotFoundException fileNotFound){
            return false;
       
        } catch (IOException io){
            return false;
      
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
        }
        return true;
    }
}
