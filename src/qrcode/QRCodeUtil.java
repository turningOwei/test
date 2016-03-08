package qrcode;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeUtil {
	private static final String CHARSET = "utf-8";
	private static final String FORMAT_NAME = "JPG";
	// 二维码尺寸
	private static final int QRCODE_SIZE = 200;
	// LOGO宽度
	private static final int WIDTH = 50;
	// LOGO高度
	private static final int HEIGHT = 50;

	private static BufferedImage createImage(String content, String imgPath,
			boolean needCompress, Integer qrCodeSize, Integer logoImageWidth,
			Integer logoImageHeight) throws Exception {
		qrCodeSize = qrCodeSize == null || qrCodeSize < QRCODE_SIZE ? QRCODE_SIZE
				: qrCodeSize;
		logoImageWidth = logoImageWidth == null || logoImageWidth < WIDTH ? WIDTH
				: logoImageWidth;
		logoImageHeight = logoImageHeight == null || logoImageHeight < HEIGHT ? HEIGHT
				: logoImageHeight;
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
				BarcodeFormat.QR_CODE, qrCodeSize, qrCodeSize, hints);
		int width = bitMatrix.getWidth();
		int height = bitMatrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000
						: 0xFFFFFFFF);
			}
		}
		if (imgPath == null || "".equals(imgPath)) {
			return image;
		}
		// 插入图片
		QRCodeUtil.insertImage(image, imgPath, needCompress, qrCodeSize,
				logoImageWidth, logoImageHeight);
		return image;
	}

	private static BufferedImage createImage(String content,
			InputStream logoIn, boolean needCompress, Integer qrCodeSize,
			Integer logoImageWidth, Integer logoImageHeight) throws Exception {
		qrCodeSize = qrCodeSize == null || qrCodeSize < QRCODE_SIZE ? QRCODE_SIZE
				: qrCodeSize;
		logoImageWidth = logoImageWidth == null || logoImageWidth < WIDTH ? WIDTH
				: logoImageWidth;
		logoImageHeight = logoImageHeight == null || logoImageHeight < HEIGHT ? HEIGHT
				: logoImageHeight;
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
				BarcodeFormat.QR_CODE, qrCodeSize, qrCodeSize, hints);
		int width = bitMatrix.getWidth();
		int height = bitMatrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000
						: 0xFFFFFFFF);
			}
		}
		// 插入图片
		QRCodeUtil.insertImage(image, logoIn, needCompress, qrCodeSize,
				logoImageWidth, logoImageHeight);
		return image;
	}

	private static void insertImage(BufferedImage source, InputStream logoIn,
			boolean needCompress, Integer qrCodeSize, Integer logoImageWidth,
			Integer logoImageHeight) throws IOException {
		Image src = ImageIO.read(logoIn);

		int width = src.getWidth(null);
		int height = src.getHeight(null);
		if (needCompress) { // 压缩LOGO
			if (width > logoImageWidth) {
				width = logoImageWidth;
			}
			if (height > logoImageHeight) {
				height = logoImageHeight;
			}
			Image image = src.getScaledInstance(width, height,
					Image.SCALE_SMOOTH);
			BufferedImage tag = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			src = image;
		}
		// 插入LOGO
		Graphics2D graph = source.createGraphics();
		int x = (qrCodeSize - width) / 2;
		int y = (qrCodeSize - height) / 2;
		graph.drawImage(src, x, y, width, height, null);
		Shape shape = new RoundRectangle2D.Float(x, y, width, height, 6, 6);
		graph.setStroke(new BasicStroke(3f));
		graph.draw(shape);
		graph.dispose();
	}

	private static void insertImage(BufferedImage source, String imgPath,
			boolean needCompress, Integer qrCodeSize, Integer logoImageWidth,
			Integer logoImageHeight) throws Exception {
		File file = new File(imgPath);
		if (!file.exists()) {
			System.err.println("" + imgPath + "   该文件不存在！");
			return;
		}
		Image src = ImageIO.read(new File(imgPath));
		int width = src.getWidth(null);
		int height = src.getHeight(null);
		if (needCompress) { // 压缩LOGO
			if (width > logoImageWidth) {
				width = logoImageWidth;
			}
			if (height > logoImageHeight) {
				height = logoImageHeight;
			}
			Image image = src.getScaledInstance(width, height,
					Image.SCALE_SMOOTH);
			BufferedImage tag = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			src = image;
		}
		// 插入LOGO
		Graphics2D graph = source.createGraphics();
		int x = (qrCodeSize - width) / 2;
		int y = (qrCodeSize - height) / 2;
		graph.drawImage(src, x, y, width, height, null);
		Shape shape = new RoundRectangle2D.Float(x, y, width, height, 6, 6);
		graph.setStroke(new BasicStroke(3f));
		graph.draw(shape);
		graph.dispose();
	}

	/*
	 * public static void encode(String content, String imgPath, String
	 * destPath, boolean needCompress, Integer qrCodeSize) throws Exception {
	 * BufferedImage image = QRCodeUtil.createImage(content, imgPath,
	 * needCompress, qrCodeSize); mkdirs(destPath); String file = new
	 * Random().nextInt(99999999) + ".jpg"; ImageIO.write(image, FORMAT_NAME,
	 * new File(destPath + "/" + file)); }
	 */

	public static void mkdirs(String destPath) {
		File file = new File(destPath);
		// 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
	}

	public static void encode(String content, String imgPath,
			OutputStream output, boolean needCompress, Integer qrCodeSize,
			Integer logoImageWidth, Integer logoImageHeight) throws Exception {
		BufferedImage image = QRCodeUtil.createImage(content, imgPath,
				needCompress, qrCodeSize, logoImageWidth, logoImageHeight);
		ImageIO.write(image, FORMAT_NAME, output);
	}

	public static void encode(String content, OutputStream output,
			boolean needCompress, Integer qrCodeSize, Integer logoImageWidth,
			Integer logoImageHeight, InputStream input) throws Exception {
		BufferedImage image = QRCodeUtil.createImage(content, input,
				needCompress, qrCodeSize, logoImageWidth, logoImageHeight);
		ImageIO.write(image, FORMAT_NAME, output);
	}

	public static void encode(String content, OutputStream output,
			Integer qrCodeSize, Integer logoImageWidth, Integer logoImageHeight)
			throws Exception {
		QRCodeUtil.encode(content, null, output, false, qrCodeSize,
				logoImageWidth, logoImageHeight);
	}

	public static void encode(String content, OutputStream output,
			Integer qrCodeSize, Integer logoImageWidth,
			Integer logoImageHeight, InputStream input) throws Exception {
		QRCodeUtil.encode(content, output, true, qrCodeSize, logoImageWidth,
				logoImageHeight, input);
	}

	public static String decode(File file) throws Exception {
		BufferedImage image;
		image = ImageIO.read(file);
		if (image == null) {
			return null;
		}
		BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(
				image);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Result result;
		Hashtable hints = new Hashtable();
		hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
		result = new MultiFormatReader().decode(bitmap, hints);
		String resultStr = result.getText();
		return resultStr;
	}

	public static String decode(String path) throws Exception {
		return QRCodeUtil.decode(new File(path));
	}

	public static void main(String[] args) throws Exception {
		String text = "http://www.dans88.com.cn";
		/*
		 * QRCodeUtil.encode(text, "f:/MyWorkDoc/my180.jpg", "f:/MyWorkDoc",
		 * true, 90);
		 */
		System.out.println();
	}
}
