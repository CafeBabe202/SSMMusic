package cn.happyOnion801.SSMMusic.dao;

import cn.happyOnion801.SSMMusic.bean.Singer;
import cn.happyOnion801.SSMMusic.bean.SingerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SingerMapper {
    long countByExample(SingerExample example);

    int deleteByExample(SingerExample example);

    int deleteByPrimaryKey(Integer singerid);

    int insert(Singer record);

    int insertSelective(Singer record);

    List<Singer> selectByExample(SingerExample example);

    Singer selectByPrimaryKey(Integer singerid);

    int updateByExampleSelective(@Param("record") Singer record, @Param("example") SingerExample example);

    int updateByExample(@Param("record") Singer record, @Param("example") SingerExample example);

    int updateByPrimaryKeySelective(Singer record);

    int updateByPrimaryKey(Singer record);
}