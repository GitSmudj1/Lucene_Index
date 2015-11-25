package model;

import java.util.Date;

/**
 * Created by thomassinclair on 16/11/15.
 */
public interface DataModel {
    String getDoc();

    String getTitle();

    Date getDate();

    String getDept();

    String getBureau();

    String getAgency();

    String getAction();

    String getContent();
}
