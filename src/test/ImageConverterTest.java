import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ImageConverterTest {
    @Test
    void convertPDFToImage_ShouldReturn_FilesThatAreImages(){
        ImageConverter imageConverter = new ImageConverter();

        File directory = new File("C:\\Users\\Arash\\IdeaProjects\\transformPDF\\src\\main\\convertedFiles");
        imageConverter.convertPDF("C:/Users/Arash/Desktop/peer.pdf");

        try {
            assertEquals(5, directory.list().length);
            FileUtils.cleanDirectory(directory);
            assertTrue(FileUtils.isEmptyDirectory(directory));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
