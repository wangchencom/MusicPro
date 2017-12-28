package com.bfh.utils;

/**
 * @Author bfh
 * @Time 2017/11/17
 * @Description 获取真实路径工具类
 */
public class GetRealPathUitl {

	public static String getRealPath(String path) {

		String[] split = path.split("/upload/music/");
		String realPath = ConstUtil.REAL_FILE_PATH + split[1];
		return realPath;
	}
}
