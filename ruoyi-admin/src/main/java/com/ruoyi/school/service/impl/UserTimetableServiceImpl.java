package com.ruoyi.school.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.school.mapper.UserTimetableMapper;
import com.ruoyi.school.domain.UserTimetable;
import com.ruoyi.school.service.IUserTimetableService;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import org.json.JSONObject;
import org.json.JSONArray;
import com.ruoyi.school.service.IBaiduOcrClient;

/**
 * timetableService业务层处理
 * 
 * @author chenc
 * @date 2025-07-30
 */
@Service
public class UserTimetableServiceImpl implements IUserTimetableService 
{
    @Autowired
    private UserTimetableMapper userTimetableMapper;

    @Autowired
    private IBaiduOcrClient IBaiduOcrClient;

    /**
     * 查询timetable
     * 
     * @param id timetable主键
     * @return timetable
     */
    @Override
    public UserTimetable selectUserTimetableById(Long id)
    {
        return userTimetableMapper.selectUserTimetableById(id);
    }

    /**
     * 查询timetable列表
     * 
     * @param userTimetable timetable
     * @return timetable
     */
    @Override
    public List<UserTimetable> selectUserTimetableList(UserTimetable userTimetable)
    {
        return userTimetableMapper.selectUserTimetableList(userTimetable);
    }

    /**
     * 新增timetable
     * 
     * @param userTimetable timetable
     * @return 结果
     */
    @Override
    public int insertUserTimetable(UserTimetable userTimetable)
    {
        return userTimetableMapper.insertUserTimetable(userTimetable);
    }

    /**
     * 修改timetable
     * 
     * @param userTimetable timetable
     * @return 结果
     */
    @Override
    public int updateUserTimetable(UserTimetable userTimetable)
    {
        return userTimetableMapper.updateUserTimetable(userTimetable);
    }

    /**
     * 批量删除timetable
     * 
     * @param ids 需要删除的timetable主键
     * @return 结果
     */
    @Override
    public int deleteUserTimetableByIds(Long[] ids)
    {
        return userTimetableMapper.deleteUserTimetableByIds(ids);
    }

    /**
     * 删除timetable信息
     * 
     * @param id timetable主键
     * @return 结果
     */
    @Override
    public int deleteUserTimetableById(Long id)
    {
        return userTimetableMapper.deleteUserTimetableById(id);
    }

    @Override
    public List<UserTimetable> scanImageAndGenerateTimetable(MultipartFile file, Long userId) {
        List<UserTimetable> list = new ArrayList<>();
        try {
            byte[] imageBytes = file.getBytes();
            JSONObject result = IBaiduOcrClient.scanImage(imageBytes);



            JSONArray wordsResult = result.getJSONArray("words_result");
            List<String> words = new ArrayList<>();
            for (int i = 0; i < wordsResult.length(); i++) {
                JSONObject obj = wordsResult.getJSONObject(i);
                words.add(obj.getString("words"));
            }

            // 你现在已经有了所有提取的文字
            // 假设顺序是固定的，可以简单地提取字段
            String startTimeRaw = words.get(4); // "30/7/25"
            String endTimeRaw = words.get(5);   // "30/7/25Test" → 你可能要清洗数据
            String title = words.get(6);        // "test app"
            String dayOfWeek = words.get(7);    // "Wednesday"
            String description = words.get(3);

            // 清洗时间字段
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/mm/yyyy");
            inputFormat.setLenient(false);

            UserTimetable item = new UserTimetable();
            item.setUserId(userId);
            item.setStartTime(inputFormat.parse(startTimeRaw));
            item.setEndTime(inputFormat.parse(endTimeRaw));
            item.setTitle(title);
            item.setDescription(description);
            item.setDayOfWeek(dayOfWeek);
            System.out.println(item);
            insertUserTimetable(item);
            list.add(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}
