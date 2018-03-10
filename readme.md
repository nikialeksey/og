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
<meta property="og:article:published_time" content="2017-03-10T15:12+07:00" />
<meta property="og:article:author:profile:first_name" content="Alexey" />
<meta property="og:article:author:profile:last_name" content="Nikitin" />
<meta property="og:article:author:profile:username" content="nikialeksey" />
<meta property="og:article:tag" content="android" />
<meta property="og:article:tag" content="programming" />
```

# Parsing
**TBD**