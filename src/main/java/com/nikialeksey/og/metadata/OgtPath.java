/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Alexey Nikitin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.nikialeksey.og.metadata;

import java.util.Collection;
import org.cactoos.collection.CollectionOf;
import org.cactoos.collection.Filtered;
import org.cactoos.collection.Joined;

public final class OgtPath implements Path {

    private final Collection<String> names;

    public OgtPath(final String... names) {
        this(new CollectionOf<>(names));
    }

    public OgtPath(final Collection<String> names) {
        this.names = new Filtered<>((name) -> !name.isEmpty(), names);
    }

    @Override
    public String value() {
        final char delim = ':';
        final StringBuilder builder = new StringBuilder();
        for (final String name : names) {
            builder.append(name);
            builder.append(delim);
        }
        if (builder.length() > 0 && builder.charAt(builder.length() - 1) == delim) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }

    @Override
    public Path andThen(final String name) {
        return new OgtPath(new Joined<String>(names, new CollectionOf<>(name)));
    }
}
