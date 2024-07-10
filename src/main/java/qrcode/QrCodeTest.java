package qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class QrCodeTest {
    public static void main(String[] args) throws WriterException, IOException {
        var qrCodeWriter = new QRCodeWriter();
        var bitMatrix = qrCodeWriter.encode("https://preprod.myinvois.hasil.gov.my/SY1Q4H7X7792E2MQYCB5TPZH10/share/ZPRS3Y3ZNPDBTDAGYCB5TPZH10guxeuU1717678812", BarcodeFormat.QR_CODE,
               100,100 );


        ByteArrayOutputStream imgOutputStream = new ByteArrayOutputStream();
        MatrixToImageConfig con = new MatrixToImageConfig( 0xFF000002 , 0xFFFF ) ;

        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", imgOutputStream,con);
        var encodedString = Base64.getEncoder().encodeToString(imgOutputStream.toByteArray());
        System.out.println(encodedString.length());
        System.out.println("data:image/png;base64,"+encodedString);
    }
}
