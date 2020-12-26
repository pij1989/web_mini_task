package com.pozharsky.dmitri.manager;

import java.util.Locale;
import java.util.ResourceBundle;

public enum MessageManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private String resourceName = "property.message";

    MessageManager() {
        this.resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
    }

    public void changeLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }
}
