package pawai.patne.util;


public class TkUtil {

	// チェック高速化のためのキャッシュ
	private static boolean isEmulatorChecked = false;
	private static boolean isEmulatorCache = false;
	
	public static boolean isEmulator() {
		
		if (!isEmulatorChecked) {
			// 未チェック(未キャッシュ)の場合にのみ実際にチェックする
//			isEmulatorCache = android.os.Build.MODEL.equals("sdk");
			isEmulatorCache = false;
			if (android.os.Build.DEVICE.equals("generic")) {
			     if (android.os.Build.BRAND.equals("generic")) {
			          isEmulatorCache = true;
			     }
			}
			isEmulatorChecked = true;
		}
		
		return isEmulatorCache;
	}

	

}
