import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageConverter implements IPDFConverter {

    public static void convertPDF(String pathToPDF){
        try {
            PDDocument document = PDDocument.load(new File(pathToPDF));
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            for (int page = 0; page < 1/*document.getNumberOfPages()*/; ++page)
            {
                BufferedImage bim = pdfRenderer.renderImage(page);
                // suffix in filename will be used as the file format
                ImageIOUtil.writeImage(bim, "Converted-" + (page+1) + ".png", 300);
            }
            document.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
