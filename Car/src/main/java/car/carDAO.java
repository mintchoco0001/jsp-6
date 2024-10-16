package car;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import common.JDBConnect;

public class carDAO extends JDBConnect {

    // DB 리스트 조회
    public List<carDTO> getAllCars() {
        List<carDTO> carList = new ArrayList<>();
        String sql = "SELECT * FROM car";

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                carDTO car = new carDTO();
                car.set제조회사(rs.getString("제조회사"));
                car.set자동차이름(rs.getString("자동차이름"));
                car.set색상(rs.getString("색상"));
                car.set가격(rs.getInt("가격"));
                car.set출고날짜(rs.getDate("출고날짜"));
                car.set상세사양(rs.getString("상세사양"));
                car.setCarURL(rs.getString("carURL"));
                
                carList.add(car);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carList;
    }
    
    public List<carDTO> searchCars(String carinfo) {
        List<carDTO> searchResults = new ArrayList<>();
        String sql = "SELECT * FROM car WHERE 자동차이름 LIKE ? OR 제조회사 LIKE ?";
        
        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, "%" + carinfo + "%");
            psmt.setString(2, "%" + carinfo + "%");
            
            rs = psmt.executeQuery();
            while (rs.next()) {
                carDTO car = new carDTO();
                car.set제조회사(rs.getString("제조회사"));
                car.set자동차이름(rs.getString("자동차이름"));
                car.set색상(rs.getString("색상"));
                car.set가격(rs.getInt("가격"));
                car.set출고날짜(rs.getDate("출고날짜"));
                car.set상세사양(rs.getString("상세사양"));
                car.setCarURL(rs.getString("carURL"));
                
                searchResults.add(car);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchResults;
    }
}
