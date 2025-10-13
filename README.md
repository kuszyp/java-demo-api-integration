# java-demo-api-integration

## Description

Coding part from one of the live coding session i had. This is the updated version not the live one.

There were two tasks.

1. First one. Reach external API and list 15 latest articles. The response should contain only three fields from the
   article. In my case those were `id`, `title` and `summary`.
2. Second task. List 15 latest **UNREAD** articles.

I prepared the `ArticleController` with two functions inside. One for each task.

The `getUnreadArticles` function stores articles that are returned each time it is executed.

Once returned article is identified as **read** and will not be returned again.

To have expected amount of articles i create `while` loop to get the articles until i reach expected amount of 15.

---

The API to consume is [Spaceflight News API](https://api.spaceflightnewsapi.net/v4/docs/).
There are no limitations what frameworks or libraries to use. One and only condition is to use Java.
