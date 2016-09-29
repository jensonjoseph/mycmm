package com.jensonjo.controller;

import java.sql.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jensonjo.db.ConnectManager;
import com.jensonjo.pagebeans.PageBean;
import com.jensonjo.pagebeans.Person;
import com.jensonjo.pagebeans.PersonJsonObject;
import com.jensonjo.pagebeans.Student;

/*
 * In Spring MVC a Class Object is directly converted into JSON object provide;
 * Return type of method is of that Class, 
 * @ResponseBody annotation is used, and 
 * jackson-core-asl-1.9.13.jar, jackson-jaxrs-1.9.13.jar and jackson-mapper-asl-1.9.13.jar are included in lib
 * 
 * 
 */

@Controller
public class DashboardController {

	@RequestMapping(value = "/home", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView loadHomeContent(
			@ModelAttribute("pagebean") PageBean pagebean) {
		/*
		 * PageBean object is set in URL query string. for e.g.
		 * fromPage="+current_tab+"&dt="+today+"
		 */

		System.out.println("Loading Dashboard");
		ModelAndView model = new ModelAndView("dashboard");
		// Logic goes here

		System.out.println("Loading dashboard complete");
		return model;
	}

	@RequestMapping("/query")
	public ModelAndView generateQueryHeader(
			@ModelAttribute("pagebean") PageBean pagebean) {
		// @PathVariable("userName") String userName
		SimpleDateFormat dtFormater = new SimpleDateFormat("yyyy-MM-dd");
		String msg = "Please update your bookmark to http://localhost:8080/eCMM/home";

		ModelAndView model = new ModelAndView("query");
		System.out.println("Script/Client date : " + pagebean.getDt()
				+ " Server date : " + dtFormater.format(new Date()));
		if (!pagebean.getFromPage().equals("none")) {
			if (pagebean.getDt().equals(dtFormater.format(new Date()))) {
				System.out.println("Loading Query");
				for (int i = 0; i < 100000; i++) {
					for (int j = 0; j < 10000; j++) {
						int k = 0;
					}
				}
				System.out.println("Loading query complete");
			} else {
				pagebean.setFromPage("expired");
			}
		}

		model.addObject("bookmarkUrl", msg);
		return model;
	}

	@RequestMapping("/admin")
	public ModelAndView generateAdminHeader(
			@ModelAttribute("pagebean") PageBean pagebean) {
		// @PathVariable("userName") String userName
		SimpleDateFormat dtFormater = new SimpleDateFormat("yyyy-MM-dd");
		ModelAndView model = new ModelAndView("admin");
		String msg = "Please update your bookmark to http://localhost:8080/eCMM/home";
		System.out.println(msg);
		if (!pagebean.getFromPage().equals("none")) {
			if (pagebean.getDt().equals(dtFormater.format(new Date()))) {
				System.out.println("Loading Admin");
				// Logic goes here
				for (int i = 0; i < 100000; i++) {
					for (int j = 0; j < 10000; j++) {
						int k = 0;
					}
				}
				System.out.println("Loading admin complete");
			} else {
				pagebean.setFromPage("expired");
			}
		}

		model.addObject("bookmarkUrl", msg);
		return model;
	}

	@RequestMapping(value = "/load_json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Student getStudent() {
		return new Student(23, "meghna", "Naidu", "meghna@gmail.com",
				"8978767878");
	}

	@RequestMapping(value = "/admin_load_json", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Student> getStudentList() {
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(23, "Meghna", "Naidu", "meghna@gmail.com",
				"8978767878"));
		studentList.add(new Student(3, "Robert", "Parera", "robert@gmail.com",
				"8978767878"));
		studentList.add(new Student(93, "Andrew", "Strauss",
				"andrew@gmail.com", "8978767878"));
		studentList.add(new Student(239, "Eddy", "Knight", "knight@gmail.com",
				"7978767878"));

		return studentList;
	}


	@RequestMapping(value = "/server", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String demoServerSideProcessing(
			HttpServletRequest request, HttpServletResponse response) {
		String[] cols = { "engine", "browser", "platform", "version", "grade" };
		String table = "ajax";

		JSONObject result = new JSONObject();
		JSONArray array = new JSONArray();
		int amount = 10;
		int start = 0;
		int echo = 0;
		int col = 0;

		String engine = "";
		String browser = "";
		String platform = "";
		String version = "";
		String grade = "";

		String dir = "asc";
		String sStart = request.getParameter("iDisplayStart");
		String sAmount = request.getParameter("iDisplayLength");
		String sEcho = request.getParameter("sEcho");
		String sCol = request.getParameter("iSortCol_0");
		String sdir = request.getParameter("sSortDir_0");

		engine = request.getParameter("sSearch_0");
		browser = request.getParameter("sSearch_1");
		platform = request.getParameter("sSearch_2");
		version = request.getParameter("sSearch_3");
		grade = request.getParameter("sSearch_4");

		List<String> sArray = new ArrayList<String>();
		if (!engine.equals("")) {
			String sEngine = " engine like '%" + engine + "%'";
			sArray.add(sEngine);
			// or combine the above two steps as:
			// sArray.add(" engine like '%" + engine + "%'");
			// the same as followings
		}
		if (!browser.equals("")) {
			String sBrowser = " browser like '%" + browser + "%'";
			sArray.add(sBrowser);
		}
		if (!platform.equals("")) {
			String sPlatform = " platform like '%" + platform + "%'";
			sArray.add(sPlatform);
		}
		if (!version.equals("")) {
			String sVersion = " version like '%" + version + "%'";
			sArray.add(sVersion);
		}
		if (!grade.equals("")) {
			String sGrade = " grade like '%" + grade + "%'";
			sArray.add(sGrade);
		}

		String individualSearch = "";
		if (sArray.size() == 1) {
			individualSearch = sArray.get(0);
		} else if (sArray.size() > 1) {
			for (int i = 0; i < sArray.size() - 1; i++) {
				individualSearch += sArray.get(i) + " and ";
			}
			individualSearch += sArray.get(sArray.size() - 1);
		}

		if (sStart != null) {
			start = Integer.parseInt(sStart);
			if (start < 0)
				start = 0;
		}
		if (sAmount != null) {
			amount = Integer.parseInt(sAmount);
			if (amount < 10 || amount > 100)
				amount = 10;
		}
		if (sEcho != null) {
			echo = Integer.parseInt(sEcho);
		}
		if (sCol != null) {
			col = Integer.parseInt(sCol);
			if (col < 0 || col > 5)
				col = 0;
		}
		if (sdir != null) {
			if (!sdir.equals("asc"))
				dir = "desc";
		}
		String colName = cols[col];
		int total = 0;
		Connection conn = ConnectManager.getConnection();
		try {
			String sql = "SELECT count(*) FROM " + table;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				total = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		int totalAfterFilter = total;
		// result.put("sEcho",echo);

		try {
			String searchSQL = "";
			String sql = "SELECT * FROM " + table;
			String searchTerm = request.getParameter("sSearch");
			String globeSearch = " where (engine like '%" + searchTerm + "%'"
					+ " or browser like '%" + searchTerm + "%'"
					+ " or platform like '%" + searchTerm + "%'"
					+ " or version like '%" + searchTerm + "%'"
					+ " or grade like '%" + searchTerm + "%')";
			if (searchTerm != "" && individualSearch != "") {
				searchSQL = globeSearch + " and " + individualSearch;
			} else if (individualSearch != "") {
				searchSQL = " where " + individualSearch;
			} else if (searchTerm != "") {
				searchSQL = globeSearch;
			}
			sql += searchSQL;
			sql += " order by " + colName + " " + dir;
			sql += " limit " + start + ", " + amount;

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				JSONObject ja = new JSONObject();
				ja.put("engine", rs.getString("engine"));
				ja.put("browser", rs.getString("browser"));
				ja.put("platform", rs.getString("platform"));
				ja.put("version", rs.getString("version"));
				ja.put("grade", rs.getString("grade"));
				array.put(ja);
			}
			String sql2 = "SELECT count(*) FROM " + table;
			if (searchTerm != "") {
				sql2 += searchSQL;
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ResultSet rs2 = ps2.executeQuery();
				if (rs2.next()) {
					totalAfterFilter = rs2.getInt("count(*)");
				}
			}
			result.put("iTotalRecords", total);
			result.put("iTotalDisplayRecords", totalAfterFilter);
			result.put("aaData", array);
			// conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result.toString());
		return result.toString();
	}
	
	
	@RequestMapping("/contactus")
	public ModelAndView generateContactus(@ModelAttribute("pagebean") PageBean pagebean) {
		// @PathVariable("userName") String userName
		SimpleDateFormat dtFormater = new SimpleDateFormat("yyyy-MM-dd");
		String msg = "Please update your bookmark to http://localhost:8080/eCMM/home";

		ModelAndView model = new ModelAndView("contactus");
		if (!pagebean.getFromPage().equals("none")) {
			if (pagebean.getDt().equals(dtFormater.format(new Date()))) {
				System.out.println("Loading Contact US");
				for (int i = 0; i < 100000; i++) {
					for (int j = 0; j < 10000; j++) {
						int k = 0;
					}
				}
				System.out.println("Loading query complete");
			} else {
				pagebean.setFromPage("expired");
			}
		}

		model.addObject("bookmarkUrl", msg);
		return model;
	}
}
