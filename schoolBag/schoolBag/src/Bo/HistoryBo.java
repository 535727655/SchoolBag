package Bo;

import java.util.List;

import Dao.HistoryDao;
import Entity.HistoryEntity;


public class HistoryBo {
	    //��¼�� ����
		List<HistoryEntity> receiveTask(String userId){
			return new HistoryDao().MyreceiveTask(userId);	
		}
		//������ҽ��ܵ�
		List<HistoryEntity> CompleteHistory(String userId){
			return new HistoryDao().MyCompleteHistory(userId);
		}
		//ȡ���ҽ��ܵ�����
		List<HistoryEntity> InprocessHistory(String userId){
			return new HistoryDao().MyInprocessHistory(userId);
		}
		//�ҷ���������
		List<HistoryEntity> issueHistory(String userId){
			return new HistoryDao().MyissueHistory(userId);
		}
}
