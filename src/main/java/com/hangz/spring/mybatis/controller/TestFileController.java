package com.hangz.spring.mybatis.controller;

import com.google.common.collect.Lists;
import com.hangz.spring.mybatis.utils.RandomUtil;
import com.hangz.spring.mybatis.vo.ComputeTimeVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author karl xie
 * Created on 2020-04-29 11:07
 */
@RestController
@RequestMapping("/test/file")
public class TestFileController {

    @RequestMapping("tmp")
    public void testTmpFile() throws IOException {
        String suffix = ".txt";
        File f = File.createTempFile("test_" + RandomUtil.uuid(), suffix);
        List<ComputeTimeVo> list = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(
                    ComputeTimeVo.builder().id(i).beginTime(new Date()).endTime(new Date()).value(i * 2.0).build());
        }

        Map<Integer, List<ComputeTimeVo>> collect =
                list.stream().collect(Collectors.groupingBy(ComputeTimeVo::getId));
        BufferedWriter br = null;
        StringBuffer sb = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
        try {
            //解决读取的时候中文的乱码问题
            br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"));
            br.write(String.valueOf(collect.size()));
            br.newLine();
            for (Map.Entry<Integer, List<ComputeTimeVo>> entry : collect.entrySet()) {
                Integer id = entry.getKey();
                List<ComputeTimeVo> computeTimeVoList = entry.getValue();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(id);
                stringBuilder.append(" ");
                stringBuilder.append(computeTimeVoList.size());
                br.write(stringBuilder.toString());
                br.newLine();
                for (ComputeTimeVo computeTimeVo : computeTimeVoList) {
                    StringBuilder strB = new StringBuilder();
                    strB.append(sdf.format(computeTimeVo.getBeginTime()));
                    strB.append(" ");
                    strB.append(sdf.format(computeTimeVo.getEndTime()));
                    strB.append("  ");
                    strB.append(computeTimeVo.getValue());
                    br.write(strB.toString());
                    br.newLine();
                }
            }
            br.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert br != null;
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}