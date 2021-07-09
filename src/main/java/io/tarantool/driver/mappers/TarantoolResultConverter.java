package io.tarantool.driver.mappers;

import io.tarantool.driver.api.TarantoolResult;
import io.tarantool.driver.api.TarantoolResultImpl;
import org.msgpack.value.ArrayValue;
import org.msgpack.value.Value;

/**
 * @author Alexey Kuzin
 */
public class TarantoolResultConverter<V extends Value, T> implements ValueConverter<V, TarantoolResult<T>> {

    private static final long serialVersionUID = 20200708L;

    private final ValueConverter<ArrayValue, T> tupleConverter;

    public TarantoolResultConverter(ValueConverter<ArrayValue, T> tupleConverter) {
        this.tupleConverter = tupleConverter;
    }

    @Override
    public TarantoolResult<T> fromValue(V value) {
        return new TarantoolResultImpl<>(value, tupleConverter);
    }
}
