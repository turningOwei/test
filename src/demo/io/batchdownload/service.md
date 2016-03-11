@Override
	public File getZipFile(List<QRCodeInfo> list) throws Exception {
		File zip = File.createTempFile(list.toString(), QRCodeUtil.FORMAT_NAME);
		FileOutputStream fos = new FileOutputStream(zip);
		ZipOutputStream zipOut = new ZipOutputStream(fos);
		for (QRCodeInfo qRCodeInfo : list) {
			GridFSDBFile logoIn = qRCodeInfoDao
					.getLogoImageByQRCodeUrl(qRCodeInfo.getQrcodeUrl());
			BufferedImage bufferedImage = null;
			File file = File.createTempFile(qRCodeInfo.getId(),
					QRCodeUtil.FORMAT_NAME);
			if (logoIn != null) {
				bufferedImage = QRCodeUtil.getBufferedImage(
						qRCodeInfo.getQrcodeUrl(), true,
						qRCodeInfo.getQrCodeImageSize(),
						qRCodeInfo.getLogoImageWidth(),
						qRCodeInfo.getLogoImageHeight(),
						logoIn.getInputStream());
			} else {
				bufferedImage = QRCodeUtil.getBufferedImage(
						qRCodeInfo.getQrcodeUrl(), true,
						qRCodeInfo.getQrCodeImageSize(),
						qRCodeInfo.getLogoImageWidth(),
						qRCodeInfo.getLogoImageHeight());
			}
			ImageIO.write(bufferedImage, QRCodeUtil.FORMAT_NAME, file);
			zipOut = IOUtils.zipFile(file, qRCodeInfo.getName() + "."
					+ QRCodeUtil.FORMAT_NAME, zipOut);
			file.delete();
		}
		zipOut.flush();
		zipOut.close();
		return zip;
	}
	
	
IOUtils
public class IOUtils {
	public static ZipOutputStream zipFile(File file, String fileName,
			ZipOutputStream zos) {
		try {
			FileInputStream fi = new FileInputStream(file);
			BufferedInputStream bins = new BufferedInputStream(fi, 512);
			// org.apache.tools.zip.ZipEntry 也行
			ZipEntry entry = new ZipEntry(fileName);
			zos.putNextEntry(entry);
			// 向压缩文件中输出数据
			int nNumber;
			byte[] buffer = new byte[512];
			while ((nNumber = bins.read(buffer)) != -1) {
				zos.write(buffer, 0, nNumber);
			}
			// 关闭创建的流对象
			bins.close();
			fi.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return zos;
	}

}