/*
 * Copyright 2004-2017 H2 Group. Multiple-Licensed under the MPL 2.0,
 * and the EPL 1.0 (http://h2database.com/html/license.html).
 * Initial Developer: H2 Group
 */
package org.h2.mvstore.tx;

import org.h2.value.VersionedValue;

/**
 * Class CommittedVersionedValue.
 * <UL>
 * <LI> 12/24/18 8:48 PM initial creation
 * </UL>
 *
 * @author <a href='mailto:andrei.tokar@gmail.com'>Andrei Tokar</a>
 */
class VersionedValueCommitted extends VersionedValue {
    /**
     * The current value.
     */
    public final Object value;

    VersionedValueCommitted(Object value) {
        this.value = value;
    }

    static VersionedValue getInstance(Object value) {
        assert value != null;
        return value instanceof VersionedValue ? (VersionedValue) value : new VersionedValueCommitted(value);
    }

    public Object getCurrentValue() {
        return value;
    }

    public Object getCommittedValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
