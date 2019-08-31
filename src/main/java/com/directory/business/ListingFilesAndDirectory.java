package com.directory.business;

import java.util.List;

import com.directory.model.FileDescription;

/**
 * @author R_Legend
 *
 */
public interface ListingFilesAndDirectory {
	/**
	 * @param fileDescription
	 * @return
	 */
	public List<FileDescription> listFilesAndDirectory(List<FileDescription> fileDescription);

}
