package com.backmanager.backmanager.param;

public class PathParam {
    private String root = null;

    public PathParam(){
        this.root = System.getProperty("user.dir") + "\\src\\main\\java\\com\\backmanager\\backmanager\\";
    }

    public String getRootPath(){
        return this.root;
    }
    public String rootNextPath(String param){
        return this.getRootPath() + param+"\\";
    }
}
