package Bo;

import java.util.List;
import java.util.Map;

import Dao.schoolDao;

public class SchoolBo {
	//����address  ��������addressid and addressname
		public  List<Map<String,String>> getAllSchool() throws Exception{
			return new schoolDao().getAllSchool();
		}
}
