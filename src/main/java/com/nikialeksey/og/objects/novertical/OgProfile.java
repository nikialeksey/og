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
package com.nikialeksey.og.objects.novertical;

import com.nikialeksey.og.metadata.OgtContent;
import com.nikialeksey.og.metadata.OgtMeta;
import com.nikialeksey.og.metadata.OgtMetaBlock;
import com.nikialeksey.og.metadata.OgtPath;
import com.nikialeksey.og.metadata.OgtProperty;
import com.nikialeksey.og.metadata.Path;

public final class OgProfile implements Profile {

    private final String first;
    private final String last;
    private final String username;

    public OgProfile(final String first, final String last, final String username) {
        this.first = first;
        this.last = last;
        this.username = username;
    }


    @Override
    public String html() {
        return html(new OgtPath("og"));
    }

    @Override
    public String html(final Path prefix) {
        final Path profile = prefix.andThen("profile");
        return new OgtMetaBlock()
            .append(
                new OgtMeta(
                    new OgtProperty(profile.andThen("first_name")),
                    new OgtContent(first)
                )
            )
            .append(
                new OgtMeta(
                    new OgtProperty(profile.andThen("last_name")),
                    new OgtContent(last)
                )
            )
            .append(
                new OgtMeta(
                    new OgtProperty(profile.andThen("username")),
                    new OgtContent(username)
                )
            )
            .asString();
    }
}
