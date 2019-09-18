package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.vo.CategoryVo;

public class CategoryDaoTest {
	public static void main(String[] args) {

		getListTest();

	}

	public static void getListTest() {
		List<CategoryVo> list = new CategoryDao().getList();
		for (CategoryVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void insertTest(String name) {
		CategoryVo vo = new CategoryVo();
		vo.setName(name);

		new CategoryDao().insert(vo);

	}
}
