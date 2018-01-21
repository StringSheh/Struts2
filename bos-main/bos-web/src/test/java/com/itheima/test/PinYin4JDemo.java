package com.itheima.test;

import org.junit.Test;

import com.itheima.bos.utils.PinYin4jUtils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

/**
 * 演示Pinyin4j的使用
 * 
 * @author lenovo
 *
 */
public class PinYin4JDemo {

	@Test
	public void test1() {
		String[] strArray = PinyinHelper.toHanyuPinyinStringArray('广');
		// 处理多音字
		for (String string : strArray) {
			System.out.println(string);
		}
	}

	// 去掉声调
	@Test
	public void test2() throws Exception {
		// 使用格式化类
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

		String[] strArray = PinyinHelper.toHanyuPinyinStringArray('广', format);
		// 处理多音字
		for (String string : strArray) {
			System.out.println(string);
		}
	}

	@Test
	public void test3() throws Exception {
		//广东省广州市天河区 -> gdgzth
		
		String province = "广东省";
		String city = "广州市";
		String district = "天河区";
		
		province = province.substring(0, province.length()-1);
		city = city.substring(0, city.length()-1);
		district = district.substring(0, district.length()-1);
		
		//province+city+district
		String[] headByString = PinYin4jUtils.getHeadByString(province+city+district);
		String shortcode = PinYin4jUtils.stringArrayToString(headByString);
		System.out.println(shortcode.toLowerCase());
	}
	
	
	@Test
	public void test4() throws Exception {
		//广州市 -> guangzhou
		
		String city = "广州市";
		
		city = city.substring(0, city.length()-1);
		
		String string = PinYin4jUtils.hanziToPinyin(city,"");
		System.out.println(string);
		
		
	}

}
