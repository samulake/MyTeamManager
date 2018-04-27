package org.samulake.web.ui.model;

import java.util.Observer;

public interface Model<DTO> extends Observer{
    DTO getData();
}
