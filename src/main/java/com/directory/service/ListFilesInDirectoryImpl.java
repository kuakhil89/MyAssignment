package com.directory.service;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.directory.business.ListingFilesAndDirectory;
import com.directory.controller.NuanceApplication;
import com.directory.model.FileDescription;

/**
 * @author R_Legend
 *This is the core component of the system. This class is responsible for
 * the complete orchestration of listing files and directories.
 */
@Component
public class ListFilesInDirectoryImpl implements ListFilesInDirectory {

	@Autowired
	ListingFilesAndDirectory listingFilesAndDirectory;
	private static final Logger logger = LoggerFactory.getLogger(ListFilesInDirectoryImpl.class);

	/* (non-Javadoc)
	 * Its takes the Directory absolute path and list content inside it recursively
	 * @see com.dicrectory.service.ListFilesInDirectory#listFilesAndDirectory(java.lang.String)
	 */
	@Override
	public List<FileDescription> listFilesAndDirectory(String absolutePath) {
		logger.info("Returning all the Directories and files InSide  ListFilesInDirectoryImpl");
		List<FileDescription> fileDescription = new ArrayList<FileDescription>();
		try (Stream<Path> walk = Files.walk(Paths.get(absolutePath))) {

			List<String> result = walk.map(x -> x.toString()).collect(Collectors.toList());
			for (String path : result) {
				FileDescription fileDetails = new FileDescription();
				int index = path.lastIndexOf("\\");
				String fileName = path.substring(index + 1);
				fileDetails.setFileName(fileName);
				fileDetails.setFileDescription(path);
				File file = new File(path);
				if (file.isFile()) {
					long bytes = file.length();
					fileDetails.setFileSize(Long.toString(bytes));
					fileDetails.setFlagValue("f");
				} else {
					fileDetails.setFlagValue("d");
				}
				fileDescription.add(fileDetails);
			}
			fileDescription = listingFilesAndDirectory.listFilesAndDirectory(fileDescription);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return fileDescription;
	}

}
