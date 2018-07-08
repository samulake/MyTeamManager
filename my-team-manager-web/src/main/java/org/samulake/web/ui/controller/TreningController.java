package org.samulake.web.ui.controller;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import org.samulake.web.core.dto.TreningDto;
import org.samulake.web.service.IEventService;
import org.samulake.web.ui.view.impl.TreningView;

@UIScope
@SpringComponent
public class TreningController extends AbstractController<TreningView, IEventService<TreningDto>> {
}
