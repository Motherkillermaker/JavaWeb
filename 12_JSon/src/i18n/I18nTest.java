package i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author CJYong
 * @create 2021-08-06 16:44
 */
public class I18nTest {

    @Test
    public void testLocale() {
        // 获取你系统默认的语言。国家信息
         Locale locale = Locale.getDefault();
         System.out.println(locale);

        //可用的国家语言
//         for (Locale availableLocale : Locale.getAvailableLocales()) {
//         System.out.println(availableLocale);
//         }

        // 获取中文，中文的常量的 Locale 对象
        System.out.println(Locale.CHINA);

        // 获取英文，美国的常量的 Locale 对象
        System.out.println(Locale.US);
    }

    @Test
    public void testI18n(){

        // 得到我们需要的 Locale 对象
        Locale locale = Locale.CHINA;

        // 通过指定的 basename 和 Locale 对象，读取 相应的配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
        System.out.println("username：" + bundle.getString("username"));
        System.out.println("password：" + bundle.getString("password"));
        System.out.println("Sex：" + bundle.getString("sex"));
        System.out.println("age：" + bundle.getString("age"));
    }
}
