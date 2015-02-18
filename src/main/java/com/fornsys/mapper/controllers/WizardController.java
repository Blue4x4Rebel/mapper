package com.fornsys.mapper.controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fornsys.mapper.model.FileDetails;
import com.fornsys.mapper.model.SessionSettings;
import com.fornsys.mapper.model.SourceFactory;
import com.fornsys.mapper.model.SourceFactoryLocator;

@Controller
@Scope("request")
@RequestMapping("/wizard")
public class WizardController {
	private static final Logger _log = LoggerFactory.getLogger(WizardController.class);
	
	@Inject
	SourceFactoryLocator sourceFactoryLocator;
	
	@Inject
	SessionSettings sset;
	
	@RequestMapping(value="/upload",
					method=RequestMethod.POST)
	public String doUpload(@RequestParam("sourceFile") MultipartFile file, Model model) throws IOException {
		_log.info("Receiving file...");
		
		try ( InputStream ins = file.getInputStream() ) {
			Path returnFileName = Paths.get("/tmp", file.getOriginalFilename().toLowerCase());
			try( OutputStream ous = new FileOutputStream(returnFileName.toFile()) ) {
				int read;
				byte[] bytes = new byte[1024];
				while( (read = ins.read(bytes)) != -1 ) {
					ous.write(bytes,0,read);
				}
				ous.flush();
				
				SourceFactory factory = sourceFactoryLocator.getFactory(file.getContentType());
				FileDetails fileDetails = factory.createFileDetails(returnFileName.toString());
				sset.setFileDetails(fileDetails);
//				model.addAttribute("file", fileDetails);
			} catch( IOException e ) {
				throw e;
			}
		} catch( IOException e ) {
			_log.error("Error receiving file", e);
			throw e;
		}
		
		return "wizard";
	}
	
	@RequestMapping(value="/file",
					method=RequestMethod.PUT,
					consumes="application/json",
					produces="application/json")
	@ResponseBody
	public boolean doUpdateFileField(@RequestBody FileDetails fieldUpdate) {
		return false;
	}
}
