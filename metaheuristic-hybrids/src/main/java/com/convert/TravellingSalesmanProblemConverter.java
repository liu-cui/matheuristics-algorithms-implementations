package com.convert;

import com.entity.tsp.City;
import com.entity.tsp.TravellingSalesmanProblem;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

/**
 * @author liucui
 */
@Slf4j
public class TravellingSalesmanProblemConverter {
    private static final String TXT_FILE = "txt";
    private static final String GZ_FILE = "gz";
    private static final String FILE_PATH_PREFIX = "metaheuristic-hybrids/src/main/resources/tsp/";
    private static final int START_LINE_NO = 6;

    public TravellingSalesmanProblem convert(String sourceType) throws IOException {
        TravellingSalesmanProblem problem = new TravellingSalesmanProblem();
        String[] s = sourceType.split("\\.");
        String fileType = s[s.length - 1];
        if (GZ_FILE.equals(fileType)) {
            problem = convertGzipFile(sourceType, problem);
        }
        if (TXT_FILE.equals(fileType)) {
            problem = convertTxtFile(sourceType, problem);
        }
        return problem;
    }

    public TravellingSalesmanProblem convertGzipFile(String sourceType, TravellingSalesmanProblem problem) {
        String raw = FILE_PATH_PREFIX + sourceType;
        log.info(raw);
        try {
            InputStream in = new GZIPInputStream(Files.newInputStream(Paths.get(raw)));
            Scanner sc = new Scanner(in);
            int countNum = 1;
            int dimension = 0;
            List<City> cityList = new ArrayList<>();
            List<Integer> cityIdList = new ArrayList<>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                String[] s = line.split(" ");
                if (line.startsWith("DIMENSION")) {
                    dimension = Integer.parseInt(String.valueOf(s[2]));
                }
                if (countNum > START_LINE_NO && countNum <= START_LINE_NO + dimension) {
                    City city = new City(Double.parseDouble(String.valueOf(s[1])), Double.parseDouble(String.valueOf(s[2])));
                    cityList.add(city);
                    cityIdList.add(Integer.parseInt(String.valueOf(s[0])));

                }
                countNum += 1;
            }
            problem.setCityList(cityList);
            problem.setCityIdList(cityIdList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return problem;
    }

    public TravellingSalesmanProblem convertTxtFile(String sourceType, TravellingSalesmanProblem problem) throws IOException {
        String raw = FILE_PATH_PREFIX + sourceType;
        BufferedReader data = new BufferedReader(new InputStreamReader(new FileInputStream(raw)));
        int citySize = 0;
        List<Integer> cityIdList = new ArrayList<>();
        List<City> cityList = new ArrayList<>();

        String strBuffer;
        String[] arrStrBuffer;
        int id;
        double x;
        double y;


        while ((strBuffer = data.readLine()) != null) {
            if (strBuffer.startsWith("DIMENSION")) {
                arrStrBuffer = strBuffer.trim().split(" ");
                citySize = Integer.parseInt(String.valueOf(arrStrBuffer[2]));
                problem.setSize(citySize);
            }
            if (!Character.isAlphabetic(strBuffer.charAt(0))) {
                break;
            }
        }
        assert strBuffer != null;
        arrStrBuffer = strBuffer.split(" ");
        id = Integer.parseInt(String.valueOf(arrStrBuffer[0]));
        x = Double.parseDouble(String.valueOf(arrStrBuffer[1]));
        y = Double.parseDouble(String.valueOf(arrStrBuffer[2]));
        cityIdList.add(id);
        cityList.add(new City(x, y));

        for (int i = 1; i < citySize; i++) {
            strBuffer = data.readLine();
            arrStrBuffer = strBuffer.split(" ");
            id = Integer.parseInt(String.valueOf(arrStrBuffer[0]));
            x = Double.parseDouble(String.valueOf(arrStrBuffer[1]));
            y = Double.parseDouble(String.valueOf(arrStrBuffer[2]));
            cityIdList.add(id);
            cityList.add(new City(x, y));
        }
        problem.setSize(citySize);
        problem.setCityIdList(cityIdList);
        problem.setCityList(cityList);
        return problem;
    }

}

