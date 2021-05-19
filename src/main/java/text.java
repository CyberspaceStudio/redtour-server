import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.jaxrs.FastJsonAutoDiscoverable;
import com.qingyuan.redtour.pojo.Attraction;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lmx
 * @Date 2021/5/19 21:27
 * @Version 1.0
 */
public class text {
    public static void main(String[] args) {
        List<String> pictureUrl = new ArrayList<>();
        pictureUrl.add("http://xxx");
        pictureUrl.add("http://xxxx");
        pictureUrl.add("http://xxxxx");
        System.out.println(JSON.toJSONString(pictureUrl));
    }
}
