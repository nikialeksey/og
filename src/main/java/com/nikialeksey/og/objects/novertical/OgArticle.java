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
import com.nikialeksey.og.types.DateTime;
import java.util.List;
import org.cactoos.list.ListOf;

public final class OgArticle implements Article {

    private final DateTime published;
    private final List<Profile> authors;
    private final List<String> tags;

    public OgArticle(final DateTime published, final Profile authors, final String... tags) {
        this(published, new ListOf<>(authors), new ListOf<>(tags));
    }

    public OgArticle(final DateTime published, final Profile authors, final String tags) {
        this(published, new ListOf<>(authors), new ListOf<>(tags));
    }

    public OgArticle(final DateTime published, final List<Profile> authors, final List<String> tags) {
        this.published = published;
        this.authors = authors;
        this.tags = tags;
    }

    @Override
    public String html() {
        return html(new OgtPath("og"));
    }

    @Override
    public String html(final Path prefix) {
        final Path article = prefix.andThen("article");
        final OgtMetaBlock metas = new OgtMetaBlock();
        metas.append(
            new OgtMeta(
                new OgtProperty(article.andThen("published_time")),
                new OgtContent(published)
            )
        );
        for (final Profile author : authors) {
            metas.append(author.html(article.andThen("author")));
        }
        for (final String tag : tags) {
            metas.append(
                new OgtMeta(
                    new OgtProperty(article.andThen("tag")),
                    new OgtContent(tag)
                )
            );
        }
        return metas.asString();
    }
}
