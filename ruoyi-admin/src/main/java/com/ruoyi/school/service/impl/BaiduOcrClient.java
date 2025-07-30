package com.ruoyi.school.service.impl;

import com.baidu.aip.ocr.AipOcr;
import com.ruoyi.school.service.IAppEventService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.school.service.IBaiduOcrClient;
import java.util.HashMap;

@Service
public class BaiduOcrClient implements IBaiduOcrClient
{
        private static final String APP_ID = "119644487";
    private static final String API_KEY = "y5JNS1Hwrtj73B04SZ1uKeZH";
    private static final String SECRET_KEY = "zmFN4oMrdQ7PV9KTthxMZaSOTqsnjeAS";

    private final AipOcr client;

    public BaiduOcrClient() {
        client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
    }

    @Override
    public JSONObject scanImage(String imagePath) {
        return client.basicGeneral(imagePath, new HashMap<>());
    }

    @Override
    public JSONObject scanImage(byte[] imageBytes) {
        return client.basicGeneral(imageBytes, new HashMap<>());
    }

    @Override
    public JSONObject scanImage(MultipartFile file) throws Exception {
        byte[] bytes = file.getBytes();
        return client.basicGeneral(bytes, new HashMap<>());
    }
}
