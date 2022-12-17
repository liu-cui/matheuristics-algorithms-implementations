package com.convert;

import com.entity.tsp.model.City;
import com.entity.tsp.model.TravellingSalesmanProblem;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
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

    private static final String FILE_PATH_PREFIX = "metaheuristic-hybrids/src/main/resources/tsp/";
    private static final int START_LINE_NO = 6;

    public TravellingSalesmanProblem convert(String sourceType) {
        String raw = FILE_PATH_PREFIX + sourceType;
        TravellingSalesmanProblem problem = new TravellingSalesmanProblem();
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
}
