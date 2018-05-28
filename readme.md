![Elegant Objects Respected Here](http://www.elegantobjects.org/badge.svg)

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.nikialeksey/og/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.nikialeksey/og)
[![Build Status](https://travis-ci.org/nikialeksey/og.svg?branch=master)](https://travis-ci.org/nikialeksey/og)
[![codecov](https://codecov.io/gh/nikialeksey/og/branch/master/graph/badge.svg)](https://codecov.io/gh/nikialeksey/og)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/nikialeksey/og/blob/master/LICENSE.txt)

# The Open Graph Java implementation
[The Open Graph](http://ogp.me/) is a protocol for creating object in social 
graph from a web page.

# Generation
```java
new OgArticle(
    new OgtDateTime(OffsetDateTime.of(2017, 3, 10, 15, 12, 0, 0, ZoneOffset.ofHours(7))),
    new OgProfile("Alexey", "Nikitin", "nikialeksey"),
    "android", "programming"
).html()
```
will produce:
```xml
<meta property="article:published_time" content="2017-03-10T15:12+07:00" />
<meta property="article:author:profile:first_name" content="Alexey" />
<meta property="article:author:profile:last_name" content="Nikitin" />
<meta property="article:author:profile:username" content="nikialeksey" />
<meta property="article:tag" content="android" />
<meta property="article:tag" content="programming" />
```

# Parsing
**TBD**