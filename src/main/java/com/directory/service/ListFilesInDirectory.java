package com.directory.service;
import java.util.List;

import com.directory.model.FileDescription;
/**
 * @author R_Legend
 *
 */
public interface ListFilesInDirectory {
	/**
	 * @param absolutePath
	 * @return
	 */
	public List<FileDescription> listFilesAndDirectory(String absolutePath);

}
