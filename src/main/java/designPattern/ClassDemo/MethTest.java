package designPattern.ClassDemo;

import com.google.common.base.Strings;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2/25 0025 17:30
 */
public class MethTest {
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MethTest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>();
//        int m = 19;
//        for (int j = 0; j < m; j++) {
//            list.add((int) (Math.random() * 10));
//        }
//        List<Integer> insertList;
//        int len = list.size();
//        for (int i = 0; i < len; i += 10) {
//            insertList = new ArrayList<>();
//            if (i + 10 > len) {
//                insertList = list.subList(i, len);
//                System.out.println("第:" + i + "次: " + insertList.size() + "个" + "----总长度: " + len + "个");
//            } else {
//                insertList = list.subList(i, i + 10);
//                System.out.println("第:" + i + "次: " + insertList.size() + "个" + "----总长度: " + len + "个");
//            }
//        }

        HttpClient httpclient = new DefaultHttpClient();

        HttpGet get = new HttpGet();
        URI url;
        try
        {
            String request = "https://c.api.weibo.com/2/search/statuses/limited.json?access_token=2.006hTzpD_md4REd50c3deafatha7ND&q=sap";

            url = new URI(request);
            get.setURI(url);
            HttpHost proxy = new HttpHost("proxy.wdf.sap.corp", 8080);
            httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

            HttpResponse response = httpclient.execute(get);

            HttpEntity entity = response.getEntity();
            if (entity == null)
            {
                System.out.println("response is null!");
                return;
            }
            InputStream instreams = entity.getContent();
            String str = convertStreamToString(instreams);
            System.out.println(str);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static String convertStreamToString(InputStream is)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


}
