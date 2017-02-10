package Bo;

import java.util.List;

import Dao.HistoryDao;
import Entity.HistoryEntity;


public class HistoryBo {
	    //记录表 接收
		List<HistoryEntity> receiveTask(String userId){
			return new HistoryDao().MyreceiveTask(userId);	
		}
		//已完成我接受的
		List<HistoryEntity> CompleteHistory(String userId){
			return new HistoryDao().MyCompleteHistory(userId);
		}
		//取消我接受的任务
		List<HistoryEntity> InprocessHistory(String userId){
			return new HistoryDao().MyInprocessHistory(userId);
		}
		//我发布的任务
		List<HistoryEntity> issueHistory(String userId){
			return new HistoryDao().MyissueHistory(userId);
		}
}
