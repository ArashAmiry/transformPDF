
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImageConverterTest {
    @Test
    void convertPDFToImage_ShouldReturn_FilesThatAreImages(){
        ImageConverter.convertPDF("C:/Users/Arash/Desktop/CVARASHV2.pdf");
    }
}
