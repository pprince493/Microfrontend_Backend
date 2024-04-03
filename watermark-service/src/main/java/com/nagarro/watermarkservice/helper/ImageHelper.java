package com.nagarro.watermarkservice.helper;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@Component
public class ImageHelper {
    public byte[] addWatermarkToImage(MultipartFile imageFile, String location){
        byte[] imageBytes = null;
        try {
            BufferedImage image = ImageIO.read(imageFile.getInputStream());
            Graphics2D graphics2D = image.createGraphics();
            graphics2D.setColor(Color.RED);
            graphics2D.setFont(new Font("Arial", Font.BOLD, 18));
            String watermarkText = "Location: " + location;
            graphics2D.drawString(watermarkText, 10, 50);
            graphics2D.dispose();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            imageBytes = baos.toByteArray();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return imageBytes;
    }
    public byte[] addWatermarkToPDF(MultipartFile pdfFile, String location){
        byte[] pdfBytes = null;
        try (PDDocument document = PDDocument.load(pdfFile.getInputStream())) {
            int pageNum = 0;
            for (PDPage page : document.getPages()) {
                pageNum++;
                PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
                contentStream.setNonStrokingColor(Color.RED);
                String watermarkText = "Location: " + location;
                contentStream.beginText();
                contentStream.showText(watermarkText);
                contentStream.endText();
                contentStream.close();
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.save(baos);
            pdfBytes = baos.toByteArray();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return pdfBytes;
    }
    public String getFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < filename.length() - 1) {
            return filename.substring(dotIndex + 1).toLowerCase();
        }
        return "";
    }
}
