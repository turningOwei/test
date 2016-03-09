#MD后缀名的文件就是Markdown文件，Markdown 是一种轻量级的标记语言，
由John Gruber和Aaron Swartz创建，使其成为可读性最大并可再发行的可输入输出的格式。
这种语言创建灵感来自于已经存在的带标记的电子邮件文本。
Markdown 允许 HTML 语法，所以使用者如果需要可以直接用 HTML来表示是可以的。
Markdown最初由Gruber应用在Perl语言中，但它已经有多种编程语言应用了。
它是开源项目，并以BSD-style许可证的许可方式以插件形式或内容管理系统形式发布。

*http://blog.sina.com.cn/s/blog_4ddef8f80102v19t.html*

md是Markdown的缩写，md是一种易读易写的文本格式（easy-to-read, easy-to-write plain text format），并且可以很方便的转换成HTML格式显示在网页中。 以后项目的readme就可以用md格式编写了，下面列出了md格式的基本语法。

标题 Headings：
# 标题 1 (对应HTML中的标签)
## 标题 2 (对应HTML中的标签)
......
###### 标题 6 (对应HTML中的标签)

注意：标题与#之间要留一个空格

段落 Paragraph ：
两段文字之间至少要留有一个空行（one or more blank lines）

字体 Styling Text：
斜体： *This text will be italic*  （对应HTML中的标签）
粗体：**This text will be bold** （对应HTML中的标签）

列表 Lists：
无序号的列表 Unordered Lists
* item 
* item
或者
- item
- item
注意： *和-要与列表内容之间要有空格， *是实心的圆点，-是空心的圆点

有序号的列表 Ordered List:s
1. item
2. item
注意： 列表序号与列表内容之间要有空格

嵌套的列表 Nested Lists:
1. item
  1.1 item
  1.2 item
注意： 嵌套列表要缩进2个空格  indenting list items by two spaces

引用 Blockquotes：
引用文字前填加 > （indicate blockquotes with a >）
> 引用文本

代码快 Code Block
To produce a code block in Markdown, simply indent every line of the block by at least 4 spaces or 1 tab.
在每行代码前，使用4个空格或者tab缩进。
例如：
# Title
    if x > y:
        print x

链接 Links：
把链接文字放在中括号[]中，把对应的URL放到小括号()中。（wrapping link text in brackets [ ], and then wrapping the link in parenthesis ( ) ）.
[Sina Blog](blog.sina.com.cn)

参考URL：
1. https://help.github.com/articles/markdown-basics
2. http://zhangchi.de/post/intro-to-markdown.html