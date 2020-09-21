package com.dts.rentgameapi.config;

import com.dts.rentgameapi.RentConstant;
import org.jconfig.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;

@Component
public class AppConfig {
    private static String configName;
    private static boolean configured = false;

    @PostConstruct
    public void init() {
        configuration(RentConstant.CONFIG_FILE_NAME, RentConstant.CONFIG_FOLDER, DEFAULT_CONTENT);
    }

    public boolean configuration(String name, String configPath, String defaultContent) {
        File f = new File(configPath);
        if (!f.exists())
            f.mkdir();
        if (name.endsWith("xml")) {
            configPath += name + ".xml";
            configName = name;
        } else {
            configPath += name;
            configName = name.replace(".xml", "");
        }
        f = new File(configPath);
        if (ConfigManager.getInstance().addConfiguration(configName, f, defaultContent))
            configured = true;
        return configured;
    }

    public Configuration getConfiguration() {
        return ConfigManager.getInstance().getConfiguration(configName);
    }

    public static String DEFAULT_CONTENT;

    static {
        DEFAULT_CONTENT = "<?xml version=\"1.0\" ?>";
        DEFAULT_CONTENT += "\n";
        DEFAULT_CONTENT += "\t<properties>";
        DEFAULT_CONTENT += "\n";
        DEFAULT_CONTENT += "\t<category name=\"RENTGAME\">\n";
        DEFAULT_CONTENT += "\t\t<property name=\"SYSTEM_LOG_PATH\" value=\"\"/>\n";
        DEFAULT_CONTENT += "\t\t<property name=\"PORT\" value=\"9911\"/>\n";
        DEFAULT_CONTENT += "\t\t<property name=\"NUM_CORE\" value=\"10\"/>\n";
        DEFAULT_CONTENT += "\t\t<property name=\"MAX_POOL_SIZE\" value=\"20\"/>\n";
        DEFAULT_CONTENT += "\t\t<property name=\"TIMEOUT\" value=\"30\"/>\n";
        DEFAULT_CONTENT += "\t\t<property name=\"ACCEPTED_IP\" value=\"localhost,127.0.0.1\"/>\n";
        DEFAULT_CONTENT += "\t\t<property name=\"IS_TEST\" value=\"1\"/>\n";
        DEFAULT_CONTENT += "\t</category>\n";
        DEFAULT_CONTENT += "\t<category name=\"JDBC\">\n";
        DEFAULT_CONTENT += "\t\t<property name=\"HOST\" value=\"localhost\"/>\n";
        DEFAULT_CONTENT += "\t\t<property name=\"PORT\" value=\"27017\"/>\n";
        DEFAULT_CONTENT += "\t\t<property name=\"USERNAME\" value=\"thienloc71\"/>\n";
        DEFAULT_CONTENT += "\t\t<property name=\"PASSWORD\" value=\"thienloc71\"/>\n";
        DEFAULT_CONTENT += "\t\t<property name=\"DB_NAME\" value=\"topshare\"/>\n";
        DEFAULT_CONTENT += "\t\t<property name=\"connectionsPerHost\" value=\"5\"/>\n";
        DEFAULT_CONTENT += "\t\t<property name=\"threadsAllowedToBlockForConnectionMultiplier\" value=\"5\"/>\n";
        DEFAULT_CONTENT += "\t\t<property name=\"maxWaitTime\" value=\"15000\"/>\n";
        DEFAULT_CONTENT += "\t\t<property name=\"connectTimeout\" value=\"30000\"/>\n";
        DEFAULT_CONTENT += "\t\t<property name=\"socketTimeout\" value=\"29000\"/>\n";
        DEFAULT_CONTENT += "\t\t<property name=\"socketKeepAlive\" value=\"true\"/>\n";
        DEFAULT_CONTENT += "\t\t<property name=\"autoConnectRetry\" value=\"true\"/>\n";
        DEFAULT_CONTENT += "\t</category>\n";
        DEFAULT_CONTENT += "\t</properties>";
    }

}
