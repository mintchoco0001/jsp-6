package fileupload;

import common.JDBConnect;

public class MyFileDAO extends JDBConnect{

	public MyFileDAO() {
		super();
	}
	public int insertFile(MyFileDTO dto) {
		
		int applyResult = 0;

		try {
			String query = "insert into myfile (idx, title, cate, ofile, sfile) values (seq_board_num.nextval, ?, ?, ?, ?)";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getCate());
			psmt.setString(3, dto.getOfile());
			psmt.setString(4, dto.getSfile());
			applyResult = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insert 예외 발생함");
			e.printStackTrace();
		}
		return applyResult;
	}
}
