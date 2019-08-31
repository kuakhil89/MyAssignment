package com.directory.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.directory.exception.ServiceException;
import com.directory.model.FileDescription;
import com.directory.service.ListFilesInDirectory;
/**
 * @author R_Legend
 *
 */
@SpringBootApplication(scanBasePackages={"com.directory.controller","com.directory.service","com.directory.business","com.directory.exception"})
@RestController
public class NuanceApplication {
	
	@Autowired
	ListFilesInDirectory listFilesInDirectory;
	
	private static final Logger logger = LoggerFactory.getLogger(NuanceApplication.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NuanceApplication.class, args);
	}
	/**
	 * Returns the List files and directories for the specified Directory in XML Format
	 * @param directoryPath
	 * @return
	 * @throws IOException
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "/listAllFiles", method = RequestMethod.GET,
	        produces ={MediaType.APPLICATION_XML_VALUE})
	   public List<FileDescription> listAllFilesAndDirectories(@RequestParam("directoryPath") String directoryPath) throws IOException, ServiceException {
		logger.info("Returning all the Directories and files In Controller");
		List<FileDescription> fileList=new ArrayList<FileDescription>();
		if( directoryPath!=null && (directoryPath.charAt(0)=='G' || directoryPath.charAt(0)=='D')){
			fileList=listFilesInDirectory.listFilesAndDirectory(directoryPath);
		}
		else{
			throw new ServiceException("No Such Directory found in the System Please use either G or D directory");
		}
		return fileList;
	   }

}
