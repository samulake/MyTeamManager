package org.samulake.web.ui.predicates;

import java.util.Collection;
import java.util.function.Predicate;

public class OnlyOnePredicate implements Predicate<Collection<?>> {

    private OnlyOnePredicate singleton;

    @Override
    public boolean test(Collection<?> objects) {
        return objects.size() == 1;
    }
}
