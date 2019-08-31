package com.directory.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.directory.model.FileDescription;
import com.directory.service.ListFilesInDirectoryImpl;
/**
 * @author R_Legend
 *This class is responsible to implement Sorting Logic
 */
@Service
public class ListingFilesAndDirectoryImpl implements ListingFilesAndDirectory {
	
	private static final Logger logger = LoggerFactory.getLogger(ListFilesInDirectoryImpl.class);

	/* (non-Javadoc)
	 * It returns the contents inside the directory in sorted order on basis of file name
	 * @see com.dicrectory.business.ListingFilesAndDirectory#listFilesAndDirectory(java.util.List)
	 */
	@Override
	public List<FileDescription> listFilesAndDirectory(List<FileDescription> fileDescription) {
		logger.info("Returning all the Directories and files in Sorted Order InSide  ListingFilesAndDirectoryImpl");
		fileDescription.sort((f1,f2)->(f1.getFileName().compareTo(f2.getFileName())));
		return fileDescription;
	}

}
