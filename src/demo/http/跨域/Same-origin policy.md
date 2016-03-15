Same-origin policy 同源策略
This mechanism bears a particular significance for modern web applications that extensively depend on HTTP cookies to maintain authenticated user sessions, as servers act based on the HTTP cookie information to reveal sensitive information or take state-changing actions. A strict separation between content provided by unrelated sites must be maintained on the client-side to prevent the loss of data confidentiality or integrity.

同源策略机制为现代广泛依赖于cookie维护用户会话的Web浏览器定义了一个特殊的功能，严格隔离不相关的网站提供的内容，防止客户端数据机密性或完整性丢失。

对于现代web应用 广泛 认证 -http cookies维持用户的会话,这种机制承担了特别的意义

作为服务器充当基于HTTP cookie信息透露敏感信息或采取状态改变行动

通过不相关的网站所提供的内容之间的严格分离必须在客户端进行维护，以防止数据的机密性和完整性的损失。


案例:直接获取其他网站登录的用户名,密码。写个恶意脚本就能获取
