package com.fornsys.mapper.rest.services.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/rest/files")
public class FileManagerService {
	private static final Logger _log = LoggerFactory.getLogger(FileManagerService.class);
	
	@RequestMapping(value="/upload",
					consumes=MediaType.MULTIPART_FORM_DATA_VALUE,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean uploadFile(@RequestParam("name") String[] names,
            @RequestParam("file") MultipartFile[] files) throws IOException {
        if (files.length != names.length)
            return false; //"Mandatory information missing";

        for( int i=0; i < files.length; i++ ) {
        	MultipartFile file = files[i];

			try ( InputStream ins = file.getInputStream() ) {
				Path returnFileName = Paths.get("/tmp", names[i].toLowerCase());
				try( OutputStream ous = new FileOutputStream(returnFileName.toFile()) ) {
					int read;
					byte[] bytes = new byte[1024];
					while( (read = ins.read(bytes)) != -1 ) {
						ous.write(bytes,0,read);
					}
					ous.flush();
				} catch( IOException e ) {
					throw e;
				}
			} catch( IOException e ) {
				_log.error("Error receiving file", e);
				throw e;
			}
		}
		
		return true;
	}
	
}
