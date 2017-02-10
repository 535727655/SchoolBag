package Bo;

import java.util.List;
import java.util.Map;

import Dao.schoolDao;

public class SchoolBo {
	//查找address  查找所有addressid and addressname
		public  List<Map<String,String>> getAllSchool() throws Exception{
			return new schoolDao().getAllSchool();
		}
}
