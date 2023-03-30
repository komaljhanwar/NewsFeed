package com.demo.news.feed;

import lombok.Getter;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

import static org.apache.tomcat.util.file.ConfigFileLoader.getSource;

@Getter
public class GenericEvent<T> implements ResolvableTypeProvider {

    private T message;
    private Object source;

    public GenericEvent(Object source, T message) {
        this.source = source;
        this.message = message;
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(
                getClass(), ResolvableType.forInstance(getSource())
        );
    }
}
