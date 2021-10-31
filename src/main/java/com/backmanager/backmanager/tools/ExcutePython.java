package com.backmanager.backmanager.tools;

import java.io.BufferedReader;  

import java.io.IOException;  

import java.io.InputStreamReader;

import com.backmanager.backmanager.param.PathParam;  

public class ExcutePython {  


    public static void topythonByParam(String pythonName,String param) {  
        Process proc;  
        PathParam pathParam = new PathParam();
        try {  

            String[] args1 = new String[] { "python", pathParam.rootNextPath("python")+pythonName+".py", param};  

            proc=Runtime.getRuntime().exec(args1);  

            //用输入输出流来截取结果  

            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));  

            String line = null;  

            while ((line = in.readLine()) != null) {  

                System.out.println(line);  

            }

            in.close();  

            proc.waitFor();  

        } catch (IOException e) {  

            e.printStackTrace();  

        } catch (InterruptedException e) {  

            e.printStackTrace();  

        }  

 

    }  

} 