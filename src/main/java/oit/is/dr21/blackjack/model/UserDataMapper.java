package oit.is.dr21.blackjack.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDataMapper {

  @Select("SELECT coin FROM userData WHERE name = #{name}")
  int selectCoinByName(String name);

  @Update("UPDATE userData SET coin = #{coin} WHERE name = #{name}")
  void updateCoinByName(String name, int coin);
}
