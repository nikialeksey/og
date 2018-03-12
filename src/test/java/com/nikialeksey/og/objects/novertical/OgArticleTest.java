package com.nikialeksey.og.objects.novertical;

import com.nikialeksey.og.types.OgtDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class OgArticleTest {
    @Test
    public void articleHtml() {
        Assert.assertThat(
            new OgArticle(
                new OgtDateTime(OffsetDateTime.of(2017, 3, 10, 15, 12, 0, 0, ZoneOffset.ofHours(7))),
                new OgProfile("Alexey", "Nikitin", "nikialeksey"),
                "android", "programming"
            ).html(),
            IsEqual.equalTo(
                "<meta property=\"article:published_time\" content=\"2017-03-10T15:12+07:00\" />\n" +
                "<meta property=\"article:author:profile:first_name\" content=\"Alexey\" />\n" +
                "<meta property=\"article:author:profile:last_name\" content=\"Nikitin\" />\n" +
                "<meta property=\"article:author:profile:username\" content=\"nikialeksey\" />\n" +
                "<meta property=\"article:tag\" content=\"android\" />\n" +
                "<meta property=\"article:tag\" content=\"programming\" />\n"
            )
        );
    }
}