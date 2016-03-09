package demo.mobile;

public enum ISPEnum {
	// 中国移动 China Mobile Communication Corp
	CMCC("1", "中国移动", new String[] { "134", "136", "137", "138", "139", "150",
			"151", "152", "157", "158", "159", "187", "188" }),
	// 中国联通 China Unicom;
	CU("2", "中国联通", new String[] { "130", "131", "132", "156", "185", "186" }),
	// 中国电信 China Telecom
	CT("3", "中国电信", new String[] { "133", "153", "180", "189" }),
	// 其他
	OTHER("0", "其他", new String[] {}),
	// 错误
	ERR("-1", "mobile参数为空或者手机号码长度不为11，错误！", new String[] {}),
	//
	SYS_ERR("-2", "未确定错误请联系管理员", new String[] {});
	private String key;
	private String name;
	private String[] mobileNoHeads;

	private ISPEnum(String key, String name, String[] mobileNoHeads) {
		this.key = key;
		this.name = name;
		this.mobileNoHeads = mobileNoHeads;
	}

	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public String[] getMobileNoHeads() {
		return mobileNoHeads;
	}

}
