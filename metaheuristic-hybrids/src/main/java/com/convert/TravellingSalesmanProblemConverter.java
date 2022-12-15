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

    public TravellingSalesmanProblem convert(String sourceType) {
        String raw = FILE_PATH_PREFIX + sourceType;
        TravellingSalesmanProblem problem = new TravellingSalesmanProblem();
        try {
            InputStream in = new GZIPInputStream(Files.newInputStream(Paths.get(raw)));
            Scanner sc = new Scanner(in);
            int countNum = 1;
            int dimension = 0;
            int startLineNo = 0;
            List<City> cityList = new ArrayList<>();
            List<Integer> cityIdList = new ArrayList<>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                log.info(line);
                if (line.startsWith("DIMENSION")) {
//                    String[] s = line.trim().split(" ");
//                    dimension = Integer.parseInt(String.valueOf(s[2]));
                    log.info(String.valueOf(dimension));
                }
                if(line.startsWith("NODE_COORD_SECTION")){
                    startLineNo = countNum;
                    log.info("startLineNo {}", startLineNo);
                }
                if (countNum > startLineNo  + 2 && countNum < 30) {
                    String[] s = line.trim().split(" ");
                    City city = new City(Double.parseDouble(String.valueOf(s[1])), Double.parseDouble(String.valueOf(s[2])));
                    cityList.add(city);
                }
                countNum += 1;
            }
            problem.setCityList(cityList);
            problem.setCityIdList(cityIdList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(problem.getCityList().toString());


        return problem;
    }
}
