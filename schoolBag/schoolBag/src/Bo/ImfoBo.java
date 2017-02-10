package Bo;

import java.util.List;

import Dao.ImfoDao;
import Entity.Imformation;
import Entity.UsersEntity;

public class ImfoBo {
	/**
	 * 查找指定前用户的消息
	 * 根据状态
	 * user:接收人
	 * state:消息状态
	 * */
	public List<Imformation> SelImfo(UsersEntity user,int state){
		return new ImfoDao().SelImfo(user, state);
	}
	
	/**发送消息  接收人完成任务时发送给发布人的确认消息   默认确认时间为null  接收人点击时修改时间为当前时间*/
	public boolean send(Imformation im){
		return new ImfoDao().send(im);
	}	
	/**修改查看时间 为default*/
	public boolean Lookup(Imformation im){
		return new ImfoDao().Lookup(im);
	}		
	/**修改imfo状态servlet*/
	public boolean UpImfoState(Imformation im){
		return new ImfoDao().UpImfoState(im);
	}		
	/**根据id查找imfo信息*/
	public Imformation SelImfo(int imfoid){
		return new ImfoDao().SelImfo(imfoid);
	}
}
