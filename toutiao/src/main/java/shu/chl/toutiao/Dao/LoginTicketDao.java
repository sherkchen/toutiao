package shu.chl.toutiao.Dao;

import org.apache.ibatis.annotations.*;
import shu.chl.toutiao.Bean.LoginTicket;

@Mapper
public interface LoginTicketDao {
      String TABLE_NAME="login_ticket";
      String INSERT_FIELDS=" user_id,ticket,expired,status";
      String SELECT_FIELDS = " id, " + INSERT_FIELDS;
      @Insert({"Insert into",TABLE_NAME,"(",INSERT_FIELDS,")"," values(#{userId},#{ticket},#{expired},#{status})"})
      int addTicket(LoginTicket ticket);
      @Update({"update ",TABLE_NAME," set status=#{status} where ticket=#{ticket}"})
      void updateStatus(@Param("ticket") String ticket,@Param("status") int status);
      @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where ticket=#{ticket}"})
      LoginTicket selectByTicket(String ticket);
}
