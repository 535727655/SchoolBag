package Bo;

import java.util.List;

import Dao.ImfoDao;
import Entity.Imformation;
import Entity.UsersEntity;

public class ImfoBo {
	/**
	 * ����ָ��ǰ�û�����Ϣ
	 * ����״̬
	 * user:������
	 * state:��Ϣ״̬
	 * */
	public List<Imformation> SelImfo(UsersEntity user,int state){
		return new ImfoDao().SelImfo(user, state);
	}
	
	/**������Ϣ  �������������ʱ���͸������˵�ȷ����Ϣ   Ĭ��ȷ��ʱ��Ϊnull  �����˵��ʱ�޸�ʱ��Ϊ��ǰʱ��*/
	public boolean send(Imformation im){
		return new ImfoDao().send(im);
	}	
	/**�޸Ĳ鿴ʱ�� Ϊdefault*/
	public boolean Lookup(Imformation im){
		return new ImfoDao().Lookup(im);
	}		
	/**�޸�imfo״̬servlet*/
	public boolean UpImfoState(Imformation im){
		return new ImfoDao().UpImfoState(im);
	}		
	/**����id����imfo��Ϣ*/
	public Imformation SelImfo(int imfoid){
		return new ImfoDao().SelImfo(imfoid);
	}
}
