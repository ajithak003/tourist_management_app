package com.daoInterface;

import java.sql.SQLException;
import java.util.List;

import com.module.PackageModeClass;

public interface PackageModeDaoInterface {

	public boolean insertUser(PackageModeClass user) throws ClassNotFoundException, SQLException;
    List<PackageModeClass> getAllUser() throws ClassNotFoundException, SQLException;
	public void getUserById(PackageModeClass user) throws ClassNotFoundException, SQLException;
	public void updateuser(PackageModeClass user) throws ClassNotFoundException, SQLException;
	public void deleteuser(PackageModeClass user) throws ClassNotFoundException, SQLException;
	public void validateUser(PackageModeClass user) throws ClassNotFoundException, SQLException;
	
	
}
