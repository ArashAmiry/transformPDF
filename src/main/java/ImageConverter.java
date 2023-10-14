import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.bytedeco.javacpp.FloatPointer;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;

public class ImageConverter implements IPDFConverter {

    private String directoryPath = "C:\\Users\\Arash\\IdeaProjects\\transformPDF\\src\\main\\convertedFiles\\";
    private String fileName = "Converted";
    public void convertPDF(String pathToPDF){
        try {
            PDDocument document = PDDocument.load(new File(pathToPDF));
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            convertAllPages(pdfRenderer, document);
            document.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void convertAllPages(PDFRenderer pdfRenderer, PDDocument document) throws IOException {
        for (int page = 0; page < document.getNumberOfPages(); ++page)
        {
            BufferedImage bim = pdfRenderer.renderImage(page);
            // suffix in filename will be used as the file format
            ImageIOUtil.writeImage(bim, directoryPath + fileName + "-" + (page+1) + ".png", 300);
        }
    }
}
