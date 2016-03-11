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
	
#业务层主要根据list中的实体对象的信息-即二维码信息生成zip文件。而zip是临时文件,bufferedImage-->临时文件写入zip#
#想通过file流写入zipoutputstream,貌似不行,前台下载后只能得到zip文件,其中的图片文件大小始终为0 kb,解决方案 图片设置为临时文件,写入zip临时文件,最好删除临时文件#
#参考QRCodeManagerController.java.md,没搞清楚删除zip文件为何在service层不能删除,最好想到那程序运行完再删除好了,在controller的try...catch...finally的finally删除#
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