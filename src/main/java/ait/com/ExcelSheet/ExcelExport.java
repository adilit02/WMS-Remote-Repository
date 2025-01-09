package ait.com.ExcelSheet;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute.Use;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import ait.com.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelExport extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", " attachment; filename=User.xlsx");
		List<User> UserList = (List<User>) model.get("UserList");

		System.out.println("--------> " + UserList);

		Sheet sheet = workbook.createSheet("User");

		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("EMAIL");
		row.createCell(3).setCellValue("PASSWORD");
		row.createCell(4).setCellValue("ROLL");

		/*  int count=1;
		 * for (User user : UserList) { row = sheet.createRow(count++);
		 * row.createCell(0).setCellValue(user.getId());
		 * row.createCell(1).setCellValue(user.getName());
		 * row.createCell(2).setCellValue(user.getEmail());
		 * row.createCell(3).setCellValue(user.getPassword());
		 * row.createCell(4).setCellValue(user.getRoll());
		 * 
		 * }
		 */

		
		//-------------------Using Java 8-------------------
		    UserList.forEach(user -> {    
			Row r = sheet.createRow(user.getId());
			r.createCell(0).setCellValue(user.getId());
			r.createCell(1).setCellValue(user.getName());
			r.createCell(2).setCellValue(user.getEmail());
			r.createCell(3).setCellValue(user.getPassword());
			r.createCell(4).setCellValue(user.getRoll());
		});
	}

}
