package com.jd.m.cms.bjshare.domain.vo;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by tianyanbo on 2018/4/21.
 */
public class ShareContentRequestVo {

  private Integer type;
  private MultipartFile titles;
  private MultipartFile contents;

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public MultipartFile getTitles() {
    return titles;
  }

  public void setTitles(MultipartFile titles) {
    this.titles = titles;
  }

  public MultipartFile getContents() {
    return contents;
  }

  public void setContents(MultipartFile contents) {
    this.contents = contents;
  }
}
