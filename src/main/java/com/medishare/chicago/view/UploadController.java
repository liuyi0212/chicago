package com.medishare.chicago.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by liuy on 2018/5/28.
 * Description: @DESCRIPTION
 */
@Controller
public class UploadController {

    @ResponseBody
    @RequestMapping(path = "/file/import/", method = {RequestMethod.POST})
    public String fileImport(@RequestParam("filefile") MultipartFile file) throws Exception {
        System.out.println("into fileImport");
        return "/import/";
    }

    @ResponseBody
    @RequestMapping(path = "/string/import/", method = {RequestMethod.POST})
    public String stringImport(@RequestParam(value = "filefilefile", required = false) String file) throws Exception {
        System.out.println("into stringImport");
        return "/import/"+file;
    }

    @ResponseBody
    @RequestMapping(path = "/all/import/", method = {RequestMethod.POST})
    public String allImport(HttpServletResponse resp,
                            @RequestParam("typetype") String type,
                            @RequestParam("filefilefilefile") MultipartFile file) throws Exception {
        System.out.println("into allImport");
        return "/import/"+type+file;
    }



}
