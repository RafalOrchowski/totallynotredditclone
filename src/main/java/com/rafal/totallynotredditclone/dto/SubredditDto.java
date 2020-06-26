package com.rafal.totallynotredditclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubredditDto {

    private Long Id;
    private String Name;
    private String description;
    private Integer numberofPosts;

}
