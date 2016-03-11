package demo.io;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class FileIO {
	public void inputstreamtofile(InputStream ins, File file)
			throws IOException {
		OutputStream os = new FileOutputStream(file);
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
			os.write(buffer, 0, bytesRead);
		}
		os.close();
		ins.close();
	}

	public static ByteArrayInputStream getImageStream(BufferedImage bi) {
		ByteArrayInputStream is = null;

		ByteArrayOutputStream bs = new ByteArrayOutputStream();

		ImageOutputStream imOut;
		try {
			imOut = ImageIO.createImageOutputStream(bs);

			ImageIO.write(bi, "jpg", imOut);

			is = new ByteArrayInputStream(bs.toByteArray());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return is;
	}
}
