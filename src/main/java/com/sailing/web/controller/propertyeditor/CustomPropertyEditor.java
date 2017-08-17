package com.sailing.web.controller.propertyeditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CustomPropertyEditor implements PropertyEditorRegistrar
{

    @Override
    public void registerCustomEditors(PropertyEditorRegistry binder) {
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"),true));

    }
}
