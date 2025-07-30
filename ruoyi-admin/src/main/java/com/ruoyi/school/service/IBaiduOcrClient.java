package com.ruoyi.school.service;

import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
public interface IBaiduOcrClient {
    /**
     * Recognize text from a local image file path
     * @param imagePath local image file path
     * @return recognition result as JSON
     */
    JSONObject scanImage(String imagePath);

    /**
     * Recognize text from image byte array
     * @param imageBytes image data as bytes
     * @return recognition result as JSON
     */
    JSONObject scanImage(byte[] imageBytes);

    /**
     * Recognize text from a MultipartFile image
     * @param file MultipartFile image
     * @return recognition result as JSON
     * @throws Exception in case of I/O errors
     */
    JSONObject scanImage(MultipartFile file) throws Exception;
}
