package org.samulake.web.ui.view.utils;

import com.vaadin.ui.Component;
import org.samulake.web.ui.component.annotation.ViewComponent;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ComponentsExtractorUtils {

    private static Predicate<Field> isViewComponentPredicate() {
        return component -> component.getAnnotation(ViewComponent.class) != null;
    }

    public static Map<String, Component> extractViewComponents(Object viewObjectInstance) {
        if(viewObjectInstance != null) {
            return getAllFields(viewObjectInstance.getClass()).stream()
                    .filter(isViewComponentPredicate())
                    .collect(Collectors.toMap(Field::getName, getFieldValueFunction(viewObjectInstance)));
        } else return new HashMap<>();
    }

    public static List<Field> getAllFields(Class<?> type) {
        List<Field> fields = new ArrayList();
        if(Optional.ofNullable(type).isPresent()) {
            fields.addAll(Arrays.asList(type.getDeclaredFields()));
            fields.addAll(getAllFields(type.getSuperclass()));
        }
        return fields;
    }

    private static Function<Field, Component> getFieldValueFunction(Object viewObjectInstance) {
        return field -> {
            try {
                field.setAccessible(true);
                return (Component) field.get(viewObjectInstance);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Field inaccessible");
            }
        };
    }
}
