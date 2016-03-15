package demo.io.parseProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ParseProperties {
	/**
	 * @Title: getProperties
	 * @Description: 主要在于路径 采用class生成所在路径(classpath) 以/开头就是classpath
	 * @param @return 设定文件
	 * @return Properties 返回类型
	 */
	public static Properties getProperties() {
		// 生成输入流
		InputStream ins = ParseProperties.class
				.getResourceAsStream("/config/sysParams.properties");
		// 生成properties对象
		Properties p = new Properties();
		try {
			p.load(ins);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * @Title: relativePath
	 * @Description: 相对路径 相对classpath
	 * @param 设定文件
	 * @return void 返回类型
	 */
	public static void relativePath() {
		// 生成输入流
		InputStream ins = ParseProperties.class
				.getResourceAsStream("../config/config.properties");
		// 生成properties对象
		Properties p = new Properties();
		try {
			p.load(ins);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 输出properties文件的内容
		System.out.println("name:" + p.getProperty("name"));
		System.out.println("password:" + p.getProperty("password"));
	}

	/**
	 * @Title: abosultePath
	 * @Description: 绝对路径
	 * @param 设定文件
	 * @return void 返回类型
	 */
	public static void abosultePath() {
		// 生成文件对象
		File pf = new File(System.getProperty("user.dir")
				+ "/src/config/config.properties");

		// 生成文件输入流
		FileInputStream inpf = null;
		try {
			inpf = new FileInputStream(pf);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 生成properties对象
		Properties p = new Properties();
		try {
			p.load(inpf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 输出properties文件的内容
		System.out.println("name:" + p.getProperty("name"));
		System.out.println("password:" + p.getProperty("password"));
	}

	public static void main(String args[]) {

	}
}
