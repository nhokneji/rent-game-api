package com.dts.rentgameapi.config;

import org.jconfig.Configuration;
import org.jconfig.ConfigurationManager;
import org.jconfig.ConfigurationManagerException;
import org.jconfig.handler.XMLFileHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigManager {
    private static ConfigManager instance;

    private ConfigManager() {

    }

    public static ConfigManager getInstance() {
        if (instance == null)
            instance = new ConfigManager();
        return instance;
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public synchronized boolean addConfiguration(String configName, File file, String defaultConfig) {
        try {
            ConfigurationManager cm = ConfigurationManager.getInstance();
            if (!file.exists()) {
                createDefaultConfigFile(file, defaultConfig);
            }
            XMLFileHandler fileHandler = new XMLFileHandler();
            fileHandler.setFile(file);
            cm.load(fileHandler, configName);
        } catch (ConfigurationManagerException exception) {
            logger.error(exception.getMessage(), exception.getCause());
            return false;
        }
        return true;
    }

    private void createDefaultConfigFile(File file, String defaultConfig) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(defaultConfig);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e.getCause());
        }
    }

    public Configuration getConfiguration(String configName) {
        return ConfigurationManager.getConfiguration(configName);
    }
}
