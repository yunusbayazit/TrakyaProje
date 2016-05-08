package com.example.yunus.trakyadepo.Infrastructure;

import com.example.yunus.trakyadepo.Model.modelauth;
import com.lacronicus.easydatastorelib.ObjectEntry;
import com.lacronicus.easydatastorelib.Preference;

/**
 * Created by yunus on 17.03.2016.
 */
public interface UserPrefs {
    @Preference("LogedInUser")
    ObjectEntry<modelauth> LogedInUser();
}