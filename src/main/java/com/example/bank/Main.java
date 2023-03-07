package com.example.bank;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends ResourceBundle.Control
{
    public static Locale locale;
    public static Locale country;
    public static Locale language;

    protected Main(Locale country, Locale language)
    {
        this.language = language;
        this.country = country;
    }
    public static Locale getLocal()
    {
        if(locale == null)
        {
            locale = Locale.GERMAN;
        }
        return locale;
    }
    public static void setLocal(Locale newLocale)
    {
        locale = newLocale;
    }

}
