#https://github.com/HaraldWalker/user-agent-utils/tree/master#
上面这哥们写的不能真正获取浏览器名称

访问下属url能获取到浏览器名称
#http://www.useragentstring.com/index.php#
其提供的接口是
#http://www.useragentstring.com/pages/api.php#
Mini API

Here's a very simple API to analyze user agent strings and use the result on your website or application

You can send a ua string as post or get request (form field or in the query string).
Use 'uas' as parameter name: 

?uas=Opera/9.70%20(Linux%20i686%20;%20U;%20en-us)%20Presto/2.2.0 

this will automatically parse the string. To get some data you have to add one more parameter: 
Get key/value pairs

By adding &getText=all 

http://www.useragentstring.com/?uas=Opera/9.70%20(Linux%20i686%20;%20U;%20en-us)%20Presto/2.2.0&getText=all 

you will get a text file with key value pairs like
agent_type=Browser;agent_name=Opera;agent_version=9.70...
Get JSON

By adding &getJSON=all 

http://www.useragentstring.com/?uas=Opera/9.70%20(Linux%20i686%20;%20U;%20en-us)%20Presto/2.2.0&getJSON=all 

you will get a text file with a JSON object like
{"agent_type":"Browser","agent_name":"Opera","agent_version":"9.70", "os_type":"Linux","os_name":"Linux".... 

Always URL encode your strings or you will get problems with special characters like #
If you don't want all the values, you can create a list of parameters separated by dashes (-)
Possible parameters are:
agent_type
agent_name
agent_version
os_type
os_name
os_versionName
os_versionNumber
linux_distibution

This will just get agent name and version: getText=agent_name-agent_version