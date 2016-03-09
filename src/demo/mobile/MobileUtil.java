package demo.mobile;

import java.util.Arrays;
import java.util.HashSet;

public class MobileUtil {
	// 中国移动 China Mobile Communication Corp
	private final static String[] cmcc = ISPEnum.CMCC.getMobileNoHeads();
	// 中国联通 China Unicom;
	private final static String[] cu = ISPEnum.CU.getMobileNoHeads();
	// 中国电信 China Telecom
	private final static String[] ct = ISPEnum.CT.getMobileNoHeads();

	public static HashSet<String> getISP(String[] arr) {
		HashSet<String> set = new HashSet<String>();
		set.addAll(Arrays.asList(arr));
		return set;
	}

	public static HashSet<String> getCMCC() {
		return getISP(cmcc);
	}

	public static HashSet<String> getCU() {
		return getISP(cu);
	}

	public static HashSet<String> getCT() {
		return getISP(ct);
	}

	/**
	 * 判断传入的参数号码为哪家运营商
	 * 
	 * @param mobile
	 * @return 运营商枚举
	 */
	public static ISPEnum getISP(String mobile) {
		if (mobile == null || mobile.trim().length() != 11) {
			return ISPEnum.ERR;
		}
		String mobileHead = mobile.trim().substring(0, 3);
		HashSet<String> cmcc = getCMCC();
		if (cmcc.contains(mobileHead)) {
			return ISPEnum.CMCC;
		}
		HashSet<String> cu = getCU();
		if (cu.contains(mobileHead)) {
			return ISPEnum.CU;
		}
		HashSet<String> ct = getCT();
		if (ct.contains(mobileHead)) {
			return ISPEnum.CT;
		}
		return ISPEnum.OTHER;
	}

	public static void main(String[] arg) {
		ISPEnum isp = MobileUtil.getISP("13666616724");
		System.out.println(isp.getName());
	}
}
