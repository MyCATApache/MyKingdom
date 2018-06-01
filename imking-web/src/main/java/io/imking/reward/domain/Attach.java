package io.imking.reward.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Attach {
    private Integer id;

    private String attachGroup;

    private String fileName;

    private Byte fileType;

    private String saveName;

    private String savePath;

    private String fileDesc;

    private Integer size;

    private String extension;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;
}