package br.com.thomasdacosta.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class S3FileDTO {

    private String fileName;
    private String content;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static S3FileDTO getInstance(String fileName, String content) {
        S3FileDTO s3File = new S3FileDTO();
        s3File.setFileName(fileName);
        s3File.setContent(content);
        return s3File;
    }

}
