package coding.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/2/10 5:06 PM
 * @Version: 1.initial version; 2023/2/10 5:06 PM
 */
public class StreamTest {

    public static void main(String[] args) {

        City yunyang = new City("yunyang", 100);
        City wanzhou = new City("wanzhou", 101);
        List<City> cityList = new ArrayList<>();
        cityList.add(yunyang);
        cityList.add(wanzhou);

        Province chongqing = new Province(cityList);

        List<Province> provinceList = new ArrayList<>();
        provinceList.add(chongqing);

        Country china = new Country(provinceList);

        Optional.ofNullable(china)
                .flatMap(country -> Optional.ofNullable(country.getProvinceList()));
    }

    public static void printCityName(City city) {
        System.out.println(city.getCityName());
    }

    @Data
    @AllArgsConstructor
    public static class Country {
        public List<Province> provinceList;
    }

    @Data
    @AllArgsConstructor
    public static class Province {
        public List<City> cityList;
    }

    @Data
    @AllArgsConstructor
    public static class City {
        public String cityName;
        public Integer cityCode;
    }
}
