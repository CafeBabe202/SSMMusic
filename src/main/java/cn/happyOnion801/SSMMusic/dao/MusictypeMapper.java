package cn.happyOnion801.SSMMusic.dao;

import cn.happyOnion801.SSMMusic.bean.Musictype;
import cn.happyOnion801.SSMMusic.bean.MusictypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MusictypeMapper {
    long countByExample(MusictypeExample example);

    int deleteByExample(MusictypeExample example);

    int deleteByPrimaryKey(Integer musictypeid);

    int insert(Musictype record);

    int insertSelective(Musictype record);

    List<Musictype> selectByExample(MusictypeExample example);

    Musictype selectByPrimaryKey(Integer musictypeid);

    int updateByExampleSelective(@Param("record") Musictype record, @Param("example") MusictypeExample example);

    int updateByExample(@Param("record") Musictype record, @Param("example") MusictypeExample example);

    int updateByPrimaryKeySelective(Musictype record);

    int updateByPrimaryKey(Musictype record);

}