package cn.happyOnion801.SSMMusic.dao;

import cn.happyOnion801.SSMMusic.bean.Music;
import cn.happyOnion801.SSMMusic.bean.MusicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MusicMapper {
    long countByExample(MusicExample example);

    int deleteByExample(MusicExample example);

    int deleteByPrimaryKey(Integer musicid);

    int insert(Music record);

    int insertSelective(Music record);

    List<Music> selectByExample(MusicExample example);

    List<Music> selectAll();

    Music selectByPrimaryKey(Integer musicid);

    int updateByExampleSelective(@Param("record") Music record, @Param("example") MusicExample example);

    int updateByExample(@Param("record") Music record, @Param("example") MusicExample example);

    int updateByPrimaryKeySelective(Music record);

    int updateByPrimaryKey(Music record);

    int setTypeToOther(int sid);
}