package com.example.mumerali.asc.Retrofit.Models;


import com.google.gson.annotations.SerializedName;

public class Files {

    @SerializedName("file name")
    private String file_name;

    @SerializedName("size")
    private String file_size;

    @SerializedName("url")
    private String file_url;


    public String getFile_name()
    {
        return file_name;

    }

    public String getFile_size()
    {
        return file_size;

    }

    public String getFile_url()
    {
        return file_url;

    }

}

