package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import logger.FrameworkLogger;
import logger.FrameworkLogger.LEVEL;

public class FileUtils {

	public static boolean makePath(String sPath) {
        File file = new File(sPath);
        if(file.exists()) {
            FrameworkLogger.log("File \'" + sPath + "\' exists.", LEVEL.debug, FileUtils.class);
            return true;
        } else if(!makePath(file.getParent())) {
            FrameworkLogger.log("File \'" + sPath + "\' makePath() failed.", LEVEL.debug, FileUtils.class);
            return false;
        } else {
            try {
                file.createNewFile();
                FrameworkLogger.log("File \'" + sPath + "\' created.", LEVEL.debug, FileUtils.class);
            } catch (IOException var3) {
                FrameworkLogger.log("Error while creating File: \'" + sPath + "\'. Error: " + var3.getMessage(), LEVEL.debug, FileUtils.class);
                FrameworkLogger.log("Error while creating File: \'" + sPath + "\'.", LEVEL.fatal, FileUtils.class);
            }

            return file.exists();
        }
    }

    public static boolean fileExists(String sFile) {
        return isExist(sFile);
    }

    public static boolean folderExists(String sFolder) {
        return isExist(sFolder);
    }

    private static boolean isExist(String sName) {
        FrameworkLogger.log("File \'" + sName + "\'", LEVEL.debug, FileUtils.class);
        return (new File(sName)).exists();
    }

    public static void removeFolder(String sFolderPath) {
        File file = new File(sFolderPath);
        file.delete();
        FrameworkLogger.log("File \'" + sFolderPath + "\' Removed.", LEVEL.debug, FileUtils.class);
    }

    public static boolean makeFolder(String sFolderPath) {
        if(!(new File(sFolderPath)).isDirectory()) {
            FrameworkLogger.log("Folder \'" + sFolderPath + "\' created.", LEVEL.debug, FileUtils.class);
            return (new File(sFolderPath)).mkdir();
        } else {
            FrameworkLogger.log("Folder \'" + sFolderPath + "\' already exists.", LEVEL.debug, FileUtils.class);
            return true;
        }
    }

    public static String getTempPath() {
        return "";
    }

    public static void createTextFile(String sFile) {
        File file = new File(sFile);

        try {
            file.createNewFile();
        } catch (IOException var3) {
            FrameworkLogger.log("Error while creating File: \'" + sFile + "\'. Error: " + var3.getMessage(), LEVEL.debug, FileUtils.class);
            FrameworkLogger.log("Error while creating File: \'" + sFile + "\'.", LEVEL.fatal, FileUtils.class);
        }

    }

    public FileReader readFile(String filePath) {
        if(fileExists(filePath)) {
            try {
                return new FileReader(filePath);
            } catch (FileNotFoundException var3) {
                FrameworkLogger.log("Error while reading File: \'" + filePath + "\'. Error: " + var3.getMessage(), LEVEL.debug, FileUtils.class);
                FrameworkLogger.log("Error while reading File: \'" + filePath + "\'.", LEVEL.fatal, FileUtils.class);
            }
        }

        return null;
    }

    public String getFileData(String filePath) {
        if(fileExists(filePath)) {
            try {
                BufferedReader e = new BufferedReader(new FileReader(new File(filePath)));
                StringBuilder sb = new StringBuilder();

                String line;
                while((line = e.readLine()) != null) {
                    sb.append(line.trim());
                }

                return sb.toString();
            } catch (IOException var5) {
                FrameworkLogger.log("Error while reading File: \'" + filePath + "\'. Error: " + var5.getMessage(), LEVEL.debug, FileUtils.class);
                FrameworkLogger.log("Error while reading File: \'" + filePath + "\'.", LEVEL.fatal, FileUtils.class);
                return null;
            }
        } else {
            return null;
        }
    }
	
}
