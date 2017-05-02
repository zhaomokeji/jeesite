--------pinyin4j---------
http://pinyin4j.sourceforge.net/
Pinyin4j是一个流行的Java库，支持中文字符和拼音之间的转换。拼音输出格式可以定制。
多音字处理区分不好

----jpinyin---------- 支持自定义字典处理多音字
https://github.com/stuxuhai/jpinyin
 JPinyin是一个汉字转拼音的Java开源类库，在PinYin4j的功能基础上做了一些改进。

【JPinyin主要特性】
1、准确、完善的字库；
Unicode编码从4E00-9FA5范围及3007（〇）的20903个汉字中，JPinyin能转换除46个异体字（异体字不存在标准拼音）之外的所有汉字；
2、拼音转换速度快；
经测试，转换Unicode编码从4E00-9FA5范围的20902个汉字，JPinyin耗时约100毫秒。
3、多拼音格式输出支持；
JPinyin支持多种拼音输出格式：带音标、不带音标、数字表示音标以及拼音首字母输出格式；
4、常见多音字识别；
JPinyin支持常见多音字的识别，其中包括词组、成语、地名等；
5、简繁体中文转换

【使用示例】

Maven

       com.github.stuxuhai
       jpinyin
       1.0
    
String str = "你好世界";
PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITH_TONE_MARK); // nǐ,hǎo,shì,jiè
PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITH_TONE_NUMBER); // ni3,hao3,shi4,jie4
PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITHOUT_TONE); // ni,hao,shi,jie
PinyinHelper.getShortPinyin(str); // nhsj



-----py4j--------没试用 没看到有音调
 https://github.com/TiFG/py4j
http://blog.csdn.net/top_code/article/details/39641615