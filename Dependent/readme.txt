--------pinyin4j---------
http://pinyin4j.sourceforge.net/
Pinyin4j��һ�����е�Java�⣬֧�������ַ���ƴ��֮���ת����ƴ�������ʽ���Զ��ơ�
�����ִ������ֲ���

----jpinyin---------- ֧���Զ����ֵ䴦�������
https://github.com/stuxuhai/jpinyin
 JPinyin��һ������תƴ����Java��Դ��⣬��PinYin4j�Ĺ��ܻ���������һЩ�Ľ���

��JPinyin��Ҫ���ԡ�
1��׼ȷ�����Ƶ��ֿ⣻
Unicode�����4E00-9FA5��Χ��3007��������20903�������У�JPinyin��ת����46�������֣������ֲ����ڱ�׼ƴ����֮������к��֣�
2��ƴ��ת���ٶȿ죻
�����ԣ�ת��Unicode�����4E00-9FA5��Χ��20902�����֣�JPinyin��ʱԼ100���롣
3����ƴ����ʽ���֧�֣�
JPinyin֧�ֶ���ƴ�������ʽ�������ꡢ�������ꡢ���ֱ�ʾ�����Լ�ƴ������ĸ�����ʽ��
4������������ʶ��
JPinyin֧�ֳ��������ֵ�ʶ�����а������顢��������ȣ�
5����������ת��

��ʹ��ʾ����

Maven

       com.github.stuxuhai
       jpinyin
       1.0
    
String str = "�������";
PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITH_TONE_MARK); // n��,h��o,sh��,ji��
PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITH_TONE_NUMBER); // ni3,hao3,shi4,jie4
PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITHOUT_TONE); // ni,hao,shi,jie
PinyinHelper.getShortPinyin(str); // nhsj



-----py4j--------û���� û����������
 https://github.com/TiFG/py4j
http://blog.csdn.net/top_code/article/details/39641615