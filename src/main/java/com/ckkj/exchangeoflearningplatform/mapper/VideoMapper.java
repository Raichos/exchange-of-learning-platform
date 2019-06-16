package com.ckkj.exchangeoflearningplatform.mapper;

import com.ckkj.exchangeoflearningplatform.model.Video;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VideoMapper {

    @Insert("INSERT INTO video_info (title_id,video_name,post_time,video_size,video_type,score,video_path) VALUES (#{titleId},#{videoName},#{postTime},#{videoSize},#{videoType},#{score},#{videoPath});")
    int insertVideo(Video video);


}
