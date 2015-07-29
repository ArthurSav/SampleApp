package io.c0nnector.github.sampleapp.modules;

import io.c0nnector.github.sampleapp.application.Application;

public final class Modules {

    public static Object[] list(Application app) {

        return new Object[]{
                new AppModule(app)
        };
    }

    private Modules() {
        // No instances.
    }
}
