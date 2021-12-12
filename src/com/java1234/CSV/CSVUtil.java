package com.java1234.CSV;
import com.java1234.model.DeviceType;

import java.io.*;
import java.util.List;

public class CSVUtil {

    public static void writeRowName(String[] rowName, BufferedWriter csvWriter) throws IOException {
        for (String temp : rowName) {
            StringBuffer sb = new StringBuffer();
            String rowStr = sb.append("\"").append(temp).append("\",").toString();
            csvWriter.write(rowStr);
        }
        csvWriter.newLine();
    }

    public static void writeRow(DeviceType deviceType, BufferedWriter csvWriter) throws IOException {
        StringBuffer sb = new StringBuffer();

        String rowStrDeviceName = sb.append("\"").append(deviceType.getName()).append("\",").toString();
        csvWriter.write(rowStrDeviceName);
        sb.setLength(0);

        String rowStrDeviceCategory = sb.append("\"").append(deviceType.getType()).append("\",").toString();
        csvWriter.write(rowStrDeviceCategory);
        sb.setLength(0);

        String rowStrDeviceModel = sb.append("\"").append(deviceType.getModel()).append("\",").toString();
        csvWriter.write(rowStrDeviceModel);
        sb.setLength(0);

        String rowStrDeviceSizes = sb.append("\"").append(deviceType.getSpec()).append("\",").toString();
        csvWriter.write(rowStrDeviceSizes);
        sb.setLength(0);

        String rowStrRunningState = sb.append("\"").append(deviceType.getMoney()).append("\",").toString();
        csvWriter.write(rowStrRunningState);
        sb.setLength(0);


        String rowStrBatch = sb.append("\"").append(deviceType.getCrname()).append("\",").toString();
        csvWriter.write(rowStrBatch);
        sb.setLength(0);

        String rowStrBrandName = sb.append("\"").append(deviceType.getBatch()).append("\",").toString();
        csvWriter.write(rowStrBrandName);

        csvWriter.newLine();
    }




    public static File createCSVFileOfStudent(String[] head, List<DeviceType> list5, String path) {
        //  public static File createCSVFileOfStudent(String[] head, ResultSet list5, String path) {
        File csvFile = null;
        BufferedWriter csvWriter = null;
        try {
            csvFile = new File(path + File.separator + "Device.csv");
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();

            csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "GB2312"), 1024);
            writeRowName(head, csvWriter);

            if (!list5.isEmpty()) {
                for (DeviceType deviceType : list5) {
                    writeRow(deviceType, csvWriter);
                }
                csvWriter.flush();
            }
        } catch (Exception e) {
//            e.printStackTrace();
        } finally {
            try {
                csvWriter.close();
            } catch (IOException e) {
//                e.printStackTrace();
            }
        }
        return csvFile;
    }
}
